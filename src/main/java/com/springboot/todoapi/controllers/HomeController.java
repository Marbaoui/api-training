package com.springboot.todoapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(value= "/")
    public String hello() {
        return "Welcome to my world";
    }
    @GetMapping(value= "/{name}")
    public String greetingWithName(@PathVariable String name){
        return "Hello " + name;
        // string.format("Hello %s", name )
    }
}
