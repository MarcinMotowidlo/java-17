package com.example.fluxacademy.features;

import com.example.fluxacademy.model.Animal;
import com.example.fluxacademy.model.Cat;
import com.example.fluxacademy.model.Dog;
import com.example.fluxacademy.model.FoodType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

@ExtendWith(MockitoExtension.class)
public class NullPointerTest {

    @Test
    public void testNullPointer_showStacktrace() {
        HashMap<String, Animal> animals = new HashMap<>();
        animals.put("dog", new Dog());
        animals.put("cat", new Cat());
        animals.put("fish", null);

        NullPointerException exception = Assertions.assertThrows(NullPointerException.class, () -> {
            animals.get("fish").feed(FoodType.WORM);
        });
        Assertions.assertEquals(
                "Cannot invoke \"com.example.fluxacademy.model.Animal.feed(com.example.fluxacademy.model.FoodType)\" " +
                        "because the return value of \"java.util.HashMap.get(Object)\" is null", exception.getMessage());
    }

}
