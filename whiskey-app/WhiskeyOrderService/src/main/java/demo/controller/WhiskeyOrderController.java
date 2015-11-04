package demo.controller;


import demo.clients.InventoryServiceClientImpl;
import demo.model.Whiskey;
import demo.model.WhiskeyOrder;
import demo.repos.WhiskeyOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskeyOrderController {



    @RequestMapping(value="/order", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
    public Iterable<WhiskeyOrder> getWhiskey() {
        return null;
    }

    @RequestMapping(value="/order/{uuid}", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
    public WhiskeyOrder getWhiskey(@PathVariable(value = "uuid") String uuid) {

        return null;
    }

    @RequestMapping(value="/order/whiskey/{uuid}", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
    public List<WhiskeyOrder> getWhiskeyOrders(@PathVariable(value = "uuid") String uuid) {
        return null;
    }

    @RequestMapping(value="/order/", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.PUT)
    public WhiskeyOrder createWhiskey( @RequestBody WhiskeyOrder order) {

        //Get the whiskey

        //check the inventory

        //update the inventory

        //patch the document

        //save the order

        return null;
    }


}
