package com.example.fluxacademy.model;

public class Dog implements Animal {

    @Override
    public String pet() {
        return "woof";
    }

    @Override
    public String feed(FoodType foodType) {
        return switch (foodType) {
            case MEAT, MILK, WORM -> "delightful";
            case CARROT -> "not convinced";
            default -> "have to try first";
        };
    }

    public String playCatch() {
        return "goodBoy";
    }
}
