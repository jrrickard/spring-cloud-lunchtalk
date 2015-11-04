package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
//Add Eureka Client
//Add Circuit Breakers
//Add Feign Clients
public class WhiskeyOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhiskeyOrderApplication.class, args);
    }
}
