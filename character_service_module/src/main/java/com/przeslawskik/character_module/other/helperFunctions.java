package com.przeslawskik.character_module.other;

public class helperFunctions {
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public static double getRandomizedDamageMultiplier(){
        return Math.random() * 0.6 + 0.7;
    }
}
