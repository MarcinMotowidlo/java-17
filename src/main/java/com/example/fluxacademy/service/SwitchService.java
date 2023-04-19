package com.example.fluxacademy.service;

import com.example.fluxacademy.model.FoodType;
import org.springframework.stereotype.Service;

@Service
public class SwitchService {

    public void oldStyleWithoutBreak(FoodType foodType) {
        switch (foodType) {
            case APPLE, CARROT:
                System.out.println("Vegetable");
            case MILK:
                System.out.println("Dairy");
            case WORM, MEAT:
                System.out.println("Meat");
            default:
                System.out.println("Undefined food");
        }
    }

    public void oldStyleWithBreak(FoodType foodType) {
        switch (foodType) {
            case APPLE, CARROT:
                System.out.println("Vegetable");
                break;
            case MILK:
                System.out.println("Dairy");
                break;
            case WORM, MEAT:
                System.out.println("Meat");
                break;
            default:
                System.out.println("Undefined food");
                break;
        }
    }


    public void newSyntaxSwitchExpression(FoodType foodType) {
        switch (foodType) {
            case APPLE, CARROT -> System.out.println("Vegetable");
            case MILK -> System.out.println("Dairy");
            case WORM, MEAT -> System.out.println("Meat");
            default -> System.out.println("Undefined food");
        }
    }

    public String yieldFoodType(FoodType foodType) {
        return switch (foodType) {
            case APPLE, CARROT:
                yield "Vegetable";
            case MILK:
                yield "Dairy";
            case WORM, MEAT:
                yield "Meat";
            default:
                yield "Undefined food";
        };
    }
}
