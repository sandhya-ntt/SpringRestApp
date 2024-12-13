package com.keepLearning.TouristApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sampleController {

    @GetMapping("/hello")
    public String sample() {
        return "Hello World";
    }
}
