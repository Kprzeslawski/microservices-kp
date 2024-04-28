package com.przeslawskik.character_module.other;

import com.mongodb.lang.Nullable;
import com.przeslawskik.character_module.ResourcesRegister.entities.ItemEntity;
import com.przeslawskik.character_module.documents.Hero;
import com.przeslawskik.character_module.documents.Item;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class ItemsManipulationHandler {

    public static Item createNewItemBasedOnRegister(
            ItemEntity template
    ) {
        return createNewItemBasedOnRegister(template, 0.2);
    }
    public static Item createNewItemBasedOnRegister(
            ItemEntity template,
            @Nullable double statsVariation
    ){
        Random r = new Random();
        double randomValue = 1. - statsVariation + statsVariation * 2 * r.nextDouble();
        return Item.builder()
                .name(template.getName())
                .slot(template.getSlot().toString())
                .stats(
                        template
                                .getAvg_stats()
                                .entrySet()
                                .stream()
                                .collect(Collectors.toMap(
                                        m -> m.getKey().toString(),
                                        m -> ((int) Math.round(m.getValue() * randomValue))
                                ))
                )
                .build();
    }








}
