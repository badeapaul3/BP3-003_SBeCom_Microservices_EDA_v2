package com.demo.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paul Badea
 **/
@RestController
public class DataController {
    @GetMapping("/data")
    public String data(){
        return "Hello from resource server (S2)";
    }

}
