package com.example.fluxacademy.records;

import com.example.fluxacademy.model.Animal;
import com.example.fluxacademy.model.FoodType;

public record SmartKoala(int tails, boolean canHoop) implements Animal {

    public SmartKoala {
        System.out.println("SmartKoala: tails = " + tails + "canHoop:" + canHoop);
        if (canHoop) {
            throw new IllegalStateException("SmartKoala wouldn't do that");
        }
    }

    @Override
    public String pet() {
        return "yawn";
    }

    @Override
    public String feed(FoodType foodType) {
        return "just eating eucaliptus";
    }
}
