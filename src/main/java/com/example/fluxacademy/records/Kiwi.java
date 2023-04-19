package com.example.fluxacademy.records;

import com.example.fluxacademy.model.Animal;
import com.example.fluxacademy.model.FoodType;

import java.util.Objects;

public class Kiwi implements Animal {
    private int wings = 2;
    private Boolean fly;

    public int getWings() {
        return wings;
    }

    public void setWings(int wings) {
        this.wings = wings;
    }

    public boolean isFly() {
        return fly;
    }

    public void setFly(boolean fly) {
        this.fly = fly;
    }

    @Override
    public String toString() {
        return "KiwiClass{" +
                "wings=" + wings +
                ", fly=" + fly +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Kiwi kiwi = (Kiwi) o;
        return wings == kiwi.wings && fly == kiwi.fly;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wings, fly);
    }

    // some Animal methods:

    @Override
    public String pet() {
        return "<kiwi sound>";
    }

    @Override
    public String feed(FoodType foodType) {
        return "yummy";
    }
}
