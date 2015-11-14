package at.ac.tuwien.mase.backend.controllers;

import at.ac.tuwien.mase.backend.repositories.interfaces.ITagRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xvinci on 11/14/15.
 */
@RestController
@RequestMapping("/tags")
public class TagController {
    private static final Logger logger = LogManager.getLogger(TagController.class);

    private ITagRepository repository;

    @Autowired
    public TagController(ITagRepository repo) {this.repository = repo;}

    @RequestMapping(method= RequestMethod.GET)
    public void  test(@PathVariable("q") String query) {
        logger.debug("Testlog");
    }
}
