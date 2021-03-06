package at.ac.tuwien.mase.backend.controllers;

import at.ac.tuwien.mase.backend.models.Location;
import at.ac.tuwien.mase.backend.repositories.interfaces.ILocationRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by capta on 14.11.2015.
 */
@RestController
@RequestMapping("/locations")
public class LocationController {
    private static final Logger logger = LogManager.getLogger(LocationController.class);

    private ILocationRepository repository;

    @Autowired
    public LocationController(ILocationRepository repo) {this.repository = repo;}

    @RequestMapping(method= RequestMethod.GET)
    public List<String> getSimilarLocations(@RequestParam("q") String query) {

        logger.debug("Getting similar tags for tag "+query);

        List<Location> qresult = repository.autocompleteLocation(query);

        if(qresult.size() == 0) {
            logger.debug("No locations found");
            return new ArrayList<String>();
        } else if(qresult.size() < 5)
        {
            logger.debug("Less than 5 locations found");
            qresult = qresult.subList(0, qresult.size());
        }
        else
            qresult = qresult.subList(0, 4);

       List<String> result = qresult.stream().map(Location::getName).collect(Collectors.toList());

        return result;
    }
}
