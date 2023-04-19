package com.example.fluxacademy.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class StreamsTest {

    @Test
    public void testStreamToList_oldJava() {
        Stream<String> stringStream = Stream.of("a", "b", "c");
        List<String> stringList = stringStream.collect(Collectors.toList());

        Assertions.assertTrue(stringList instanceof List);
    }

    @Test
    public void testStreamToList_newJava() {
        Stream<String> stringStream = Stream.of("a", "b", "c");
        List<String> stringList = stringStream.toList();
        Assertions.assertTrue(stringList instanceof List);
    }
}
