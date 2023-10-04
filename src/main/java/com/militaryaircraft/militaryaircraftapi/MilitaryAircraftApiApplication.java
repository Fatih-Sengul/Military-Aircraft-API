package com.militaryaircraft.militaryaircraftapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.militaryaircraft.militaryaircraftapi.mappers")
@SpringBootApplication
public class MilitaryAircraftApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MilitaryAircraftApiApplication.class, args);
    }

}
