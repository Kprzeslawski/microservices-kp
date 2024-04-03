package com.przeslawskik.loc_n_mob_module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LocationsAndMobModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(LocationsAndMobModuleApplication.class, args);
    }
}
