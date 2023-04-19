package com.example.fluxacademy.model;

public class Cat implements Animal {

    @Override
    public String pet() {
        return "miau";
    }

    @Override
    public String feed(FoodType foodType) {
        return switch (foodType) {
            case MEAT, MILK -> "delightful";
            case WORM -> "not convinced";
            default -> String.valueOf(doILikeIt());
        };
    }

    public boolean doILikeIt() {
        return true;
    }
}
