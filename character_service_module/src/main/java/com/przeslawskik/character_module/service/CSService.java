package com.przeslawskik.character_module.service;

import com.przeslawskik.character_module.documents.Hero;
import com.przeslawskik.character_module.other.StatsEnum;
import com.przeslawskik.character_module.repository.HeroRepository;
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
                .stats(
                        new HashMap<>(){{
                          put(StatsEnum.ATTACK_DAMAGE,1);
                          put(StatsEnum.ARMOR,2);
                        }}
                )
                .build();


        heroRepository.save(h);

        return 0;
    }
}
