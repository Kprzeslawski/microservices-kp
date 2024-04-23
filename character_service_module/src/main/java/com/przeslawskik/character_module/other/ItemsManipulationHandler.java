package com.przeslawskik.character_module.other;

import com.mongodb.lang.Nullable;
import com.przeslawskik.character_module.ResourcesRegister.BaseItem;
import com.przeslawskik.character_module.documents.Hero;
import com.przeslawskik.character_module.documents.Item;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class ItemsManipulationHandler {

    public static Item createNewItemBasedOnRegister(
            BaseItem template, Hero forWho
    ) {
        return createNewItemBasedOnRegister(template,forWho, 0.2);
    }
    public static Item createNewItemBasedOnRegister(
            BaseItem template, Hero forWho,
            @Nullable double statsVariation
    ){
        Random r = new Random();
        double randomValue = 1. - statsVariation + statsVariation * 2 * r.nextDouble();
        return Item.builder()
                .name(template.getName())
                .stats(
                        template
                                .getAvg_stats()
                                .entrySet()
                                .stream()
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        m -> ((int) Math.round(m.getValue() * randomValue))
                                ))
                )
                .build();
    }








}
