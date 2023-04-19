package com.example.fluxacademy.records;

import com.example.fluxacademy.model.Animal;
import com.example.fluxacademy.model.FoodType;

public record Koala(int tails, boolean canHoop) implements Animal {

    @Override
    public String pet() {
        return "yawn";
    }

    @Override
    public String feed(FoodType foodType) {
        return "just eating eucaliptus";
    }
}
