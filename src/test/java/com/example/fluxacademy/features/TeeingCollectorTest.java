package com.example.fluxacademy.features;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class TeeingCollectorTest {

    @Test
    public void testTeeingCollector() {
        List<Integer> grades = List.of(3, 5, 5, 2, 5, 3, 4, 3, 5, 4, 4, 2);
        var averageGrade = grades.stream()
                .collect(
                        Collectors.teeing(
                                Collectors.summingDouble(i -> i), // downstream1
                                Collectors.counting(), // downstream2
                                (sum, n) -> sum / n // merger
                        ));
        System.out.println(averageGrade);
    }
}
