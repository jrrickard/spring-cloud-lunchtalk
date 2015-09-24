package org.lunchtalk.web;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello.
 */
@Controller
@ConfigurationProperties
public class HelloController {

    private String appName;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello from: " + appName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
