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

    @Autowired
    InventoryServiceClientImpl inventoryServiceClient;

    @Autowired
    WhiskeyOrderRepo repo;

    @RequestMapping(value="/order", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
    public Iterable<WhiskeyOrder> getWhiskey() {
        return repo.findAll();
    }

    @RequestMapping(value="/order/{uuid}", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
    public WhiskeyOrder getWhiskey(@PathVariable(value = "uuid") String uuid) {
        return repo.findOne(uuid);
    }

    @RequestMapping(value="/order/whiskey/{uuid}", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
    public List<WhiskeyOrder> getWhiskeyOrders(@PathVariable(value = "uuid") String uuid) {
        return repo.findByWhiskeyUUID(uuid);
    }

    @RequestMapping(value="/order/", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.PUT)
    public WhiskeyOrder createWhiskey( @RequestBody WhiskeyOrder order) {
        Whiskey whiskey = inventoryServiceClient.getWhiskey(order.getWhiskeyUUID());
        if (whiskey.getInventory() < order.getNumber()) {
            throw new IllegalArgumentException("Insufficient Inventory");
        }

        whiskey.setInventory(whiskey.getInventory() - order.getNumber());
        inventoryServiceClient.updateWhiskey(order.getWhiskeyUUID(),whiskey);
        return repo.save(order);
    }


}
