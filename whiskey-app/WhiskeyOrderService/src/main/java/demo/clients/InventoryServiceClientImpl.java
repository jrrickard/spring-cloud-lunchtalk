package demo.clients;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import demo.model.Whiskey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InventoryServiceClientImpl {


    //Auto Wire the Feign Client
    @Autowired
    InventoryService feignClient;

    //Implement the contract, hystrix commands


    @HystrixCommand
    public Iterable<Whiskey> getWhiskey() {
        return feignClient.getWhiskey();
    }


    @HystrixCommand
    public Whiskey getWhiskey(String uuid) {
        return feignClient.getWhiskey(uuid);
    }



    @HystrixCommand
    public Whiskey updateWhiskey( String uuid, Whiskey whiskey) {
        return feignClient.updateWhiskey(uuid, whiskey);
    }

}
