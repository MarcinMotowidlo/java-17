package com.example.fluxacademy.model;

public class Fish implements Animal {

    @Override
    public String pet() {
        return "bulp";
    }

    @Override
    public String feed(FoodType foodType) {
        return switch (foodType) {
            case WORM -> "delightful";
            default -> "is there a hook?";
        };
    }
}
