package com.example.fluxacademy.records;

import com.example.fluxacademy.model.Animal;
import com.example.fluxacademy.model.FoodType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Kangaroo implements Animal {

    private int tails;
    boolean canHoop;

    // some animal methods:
    @Override
    public String pet() {
        return "hoop";
    }

    @Override
    public String feed(FoodType foodType) {
        return "a bit picky";
    }
}
