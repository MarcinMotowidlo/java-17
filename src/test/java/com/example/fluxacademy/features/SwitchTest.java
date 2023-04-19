package com.example.fluxacademy.features;

import com.example.fluxacademy.model.FoodType;
import com.example.fluxacademy.service.SwitchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SwitchTest {

    private SwitchService switchService = new SwitchService();


    @Test
    public void testSwitchOldSyntax() {
        switchService.oldStyleWithoutBreak(FoodType.CARROT);
    }

    @Test
    public void testSwitchOldSyntaxWithBreak() {
        switchService.oldStyleWithBreak(FoodType.CARROT);
    }


    @Test
    public void testNewSyntaxSwitchExpression() {
        switchService.newSyntaxSwitchExpression(FoodType.CARROT);
    }

    @Test
    public void testYieldFoodType() {
        String typeOfFoodString = switchService.yieldFoodType(FoodType.CARROT);
        Assertions.assertEquals("Vegetable", typeOfFoodString);
    }
}
