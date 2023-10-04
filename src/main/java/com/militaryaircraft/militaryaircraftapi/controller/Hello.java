package com.militaryaircraft.militaryaircraftapi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/say")
public class Hello {


    @GetMapping("/hello")
    public String hello(){
        return "Helooooo";
    }
}
