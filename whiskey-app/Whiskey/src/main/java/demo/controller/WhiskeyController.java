package demo.controller;


import demo.model.Whiskey;
import demo.repos.WhiskeyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class WhiskeyController {

    @Autowired
    WhiskeyRepo repo;

    @RequestMapping(value="/whiskey", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
    public Iterable<Whiskey> getWhiskey() {
        return repo.findAll();
    }

    @RequestMapping(value="/whiskey/{uuid}", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
    public Whiskey getWhiskey(@PathVariable(value = "uuid") String uuid) {
        return repo.findOne(uuid);
    }

    @RequestMapping(value="/whiskey", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.PUT)
    public Whiskey createWhiskey(@RequestBody Whiskey whiskey) {
        return repo.save(whiskey);
    }

    @RequestMapping(value="/whiskey/{uuid}", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.PATCH)
    public Whiskey createWhiskey(@PathVariable(value = "uuid") String uuid, @RequestBody Whiskey whiskey) {

        Whiskey currentWhiskey = repo.findOne(uuid);

        if (whiskey.getInventory() != null && whiskey.getInventory() != currentWhiskey.getInventory()) {
            currentWhiskey.setInventory(whiskey.getInventory());
        }

        repo.save(whiskey);
        return currentWhiskey;
    }


}
