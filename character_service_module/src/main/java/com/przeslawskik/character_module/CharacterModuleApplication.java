package com.przeslawskik.character_module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.*;
@SpringBootApplication
@EnableEurekaClient
public class CharacterModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharacterModuleApplication.class, args);
	}

}
