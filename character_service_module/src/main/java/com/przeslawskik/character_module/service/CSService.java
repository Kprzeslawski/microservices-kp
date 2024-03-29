package com.przeslawskik.character_module.service;

import com.przeslawskik.character_module.documents.Hero;
import com.przeslawskik.character_module.documents.Item;
import com.przeslawskik.character_module.mapper.HeroStatsResponse;
import com.przeslawskik.character_module.other.ItemsManipulationHandler;
import com.przeslawskik.character_module.other.ItemsRegister;
import com.przeslawskik.character_module.other.StatsEnum;
import com.przeslawskik.character_module.repository.HeroRepository;
import com.przeslawskik.character_module.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CSService {

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private ItemRepository itemRepository;

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

        Item i = ItemsManipulationHandler.createNewItemBasedOnRegister(ItemsRegister.WOODEN_SWORD,h);

        itemRepository.save(i);

        return 0;
    }

    public HeroStatsResponse getChampStats(Integer id) {
        return null;
    }

    public Boolean createNewHero() {
        return null;
    }

    public Boolean addItemToInventory() {
        return null;
    }

    public Boolean awardWithXp() {
        return null;
    }

    public Boolean changeEquipment() {
        return null;
    }

    public Boolean getHeroInventory() {
        return null;
    }
}
