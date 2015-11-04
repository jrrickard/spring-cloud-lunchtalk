package demo.clients;

import demo.model.Whiskey;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("WhiskeyInventory")
public interface InventoryService {
    @RequestMapping(value="/whiskey", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.GET)
    Iterable<Whiskey> getWhiskey();

    @RequestMapping(value="/whiskey/{uuid}", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
    Whiskey getWhiskey(@PathVariable(value = "uuid") String uuid);

    @RequestMapping(value="/whiskey/{uuid}", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.PATCH)
    Whiskey updateWhiskey(@PathVariable(value = "uuid") String uuid, @RequestBody Whiskey whiskey);

}

