package example.customer.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VCenterDiscoveryController {

    @RequestMapping(value = "/message", method= RequestMethod.GET)
    public String sayHello() {
        return "Hello";
    }
}
