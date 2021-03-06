package at.ac.tuwien.mase.backend.controllers;

import at.ac.tuwien.mase.backend.controllers.exceptions.ControllerException;
import at.ac.tuwien.mase.backend.models.User;
import at.ac.tuwien.mase.backend.repositories.interfaces.IUserRepository;
import at.ac.tuwien.mase.backend.viewmodels.UserEdit;
import at.ac.tuwien.mase.backend.viewmodels.UserRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lobmaier on 14.11.2015.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @RequestMapping(value="/{username}", method=RequestMethod.GET)
    public UserRead read(@AuthenticationPrincipal User principal) throws ControllerException {
        return new UserRead(principal);
    }

    @RequestMapping(method=RequestMethod.POST)
    public UserRead register(@RequestBody UserEdit user) throws ControllerException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new ControllerException("Username not available.");
        }
        if (user.getPassword() == null || user.getName() == null || user.getPhone() == null) {
            throw new ControllerException("Please provide username, password, name and phone number.");
        }
        User u = new User();
        u.setUsername(user.getUsername());
        u.setName(user.getName());
        u.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        u.setPhone(user.getPhone());
        u.setLogo(user.getLogo());
        userRepository.save(u);
        return new UserRead(userRepository.findByUsername(user.getUsername()));
    }

    @RequestMapping(value="/{username}", method=RequestMethod.POST)
    public UserRead edit(@AuthenticationPrincipal User principal, @RequestBody UserEdit user) throws ControllerException {
        User u = userRepository.findByUsername(principal.getUsername());
        if (u == null) {
            throw new ControllerException("Username not found.");
        }
        if (user.getName() != null) {
            u.setName(user.getName());
        }
        if (user.getPassword() != null) {
            u.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        }
        if (user.getPhone() != null) {
            u.setPhone(user.getPhone());
        }
        if (user.getLogo() != null) {
            u.setLogo(user.getLogo());
        }
        userRepository.save(u);
        return new UserRead(u);
    }
}
