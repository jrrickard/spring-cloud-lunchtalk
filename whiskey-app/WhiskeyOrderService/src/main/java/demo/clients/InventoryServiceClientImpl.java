package demo.clients;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import demo.model.Whiskey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InventoryServiceClientImpl {

    @Autowired
    InventoryService inventoryService;


    @HystrixCommand
    public Iterable<Whiskey> getWhiskey() {
        return inventoryService.getWhiskey();
    }


    @HystrixCommand
    public Whiskey getWhiskey(String uuid) {
        return inventoryService.getWhiskey(uuid);
    }


    @HystrixCommand
    public Whiskey updateWhiskey(String uuid, Whiskey whiskey) {
        return inventoryService.updateWhiskey(uuid,whiskey);
    }

}
