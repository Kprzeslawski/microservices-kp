package com.przeslawskik.character_module.other;

public enum SlotEnum {
    HAND("hand"),
    CHEST("chest"),
    HELMET("helmet"),
    LEGGINGS("leggings"),
    BOOTS("boots");
    private final String asString;

    SlotEnum(String asString){
        this.asString = asString;
    }

    @Override
    public String toString() {
        return asString;
    }

}
