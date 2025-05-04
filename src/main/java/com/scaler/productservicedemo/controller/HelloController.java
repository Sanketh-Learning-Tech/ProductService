package com.scaler.productservicedemo.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/say/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello World" + name;
    }

    @PostMapping("/data")
    public String returnDetails(){
        return "Hello World";
    }

}
