package com.example.fluxacademy.features;

import com.example.fluxacademy.model.Animal;
import com.example.fluxacademy.model.Cat;
import com.example.fluxacademy.model.FoodType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PatternMatchingTest {


    @Test
    public void testOldSyntax() {
        // given
        Animal animal = new Cat();

        // when
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            System.out.println("Feeding Cat with " + cat.feed(FoodType.MILK) + " and does he like it? " + cat.doILikeIt());
        }
    }


    @Test
    public void testNewSyntaxPatternMatching() {
        // given
        Animal animal = new Cat();

        // when
        if (animal instanceof Cat cat) {
            System.out.println("Feeding Cat with " + cat.feed(FoodType.MILK) + " and does he like it? " + cat.doILikeIt());
        }
    }


    @Test
    public void testNewSyntaxPatternMatching_withAdditionalExpression() {
        // given
        Animal animal = new Cat();

        // when
        if (animal instanceof Cat cat && cat.doILikeIt()) {
            System.out.println("Feeding Cat with " + cat.feed(FoodType.MILK) + " and does I know he likes it");
        }
    }

//    @Test
//    public void testNewSyntaxPatternMatching_withAdditionalExpression_compilationFailure() {
//        // given
//        Animal animal = new Cat();
//
//        // when
//        if (animal instanceof Cat cat || cat.doILikeIt()) {
//            System.out.println("Feeding Cat with " + cat.feed(FoodType.MILK) + " and does I know he likes it");
//        }
//    }

    @Test
    public void testNewSyntaxPatternMatching_withAdditionalExpression_runtimeException() {
        // given
        Animal animal = new Cat();

        if (!(animal instanceof Cat cat)) {
            throw new RuntimeException();
        }
        // this part is reachable only if it's a cat
        System.out.println("Does cat likes it? " + cat.doILikeIt());
    }
}