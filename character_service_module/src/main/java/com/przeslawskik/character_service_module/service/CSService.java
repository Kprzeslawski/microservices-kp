package com.przeslawskik.character_service_module.service;

import com.przeslawskik.character_service_module.documents.Hero;
import com.przeslawskik.character_service_module.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CSService {

    @Autowired
    private HeroRepository heroRepository;

    public Integer test_save(){
//        Hero h = new Hero();
      var h = Hero.builder()
                .name("test")
                .level(1)
                .exp(0)
                .build();

        heroRepository.save(h);

        return 0;
    }
}
