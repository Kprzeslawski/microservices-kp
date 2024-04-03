package com.przeslawskik.battle_module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BattleModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(BattleModuleApplication.class, args);
    }
}
