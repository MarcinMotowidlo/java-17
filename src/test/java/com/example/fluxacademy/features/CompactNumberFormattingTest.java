package com.example.fluxacademy.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.NumberFormat;
import java.util.Locale;

@ExtendWith(MockitoExtension.class)
public class CompactNumberFormattingTest {

    @Test
    public void testDifferentCompactFormats_short() {
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.SHORT);

        // when / then:
        Assertions.assertEquals("1K", fmt.format(1000));
        Assertions.assertEquals("100K", fmt.format(100000));
        Assertions.assertEquals("1M", fmt.format(1000000));
    }

    @Test
    public void testDifferentCompactFormats_long() {
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.LONG);

        // when / then:
        Assertions.assertEquals("1 thousand", fmt.format(1000));
        Assertions.assertEquals("100 thousand", fmt.format(100000));
        Assertions.assertEquals("1 million", fmt.format(1000000));
    }

    @Test
    public void testDifferentCompactFormats_long_german() {
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.GERMAN, NumberFormat.Style.LONG);

        // when / then:
        Assertions.assertEquals("1 Tausend", fmt.format(1000));
        Assertions.assertEquals("100 Tausend", fmt.format(100000));
        Assertions.assertEquals("1 Million", fmt.format(1000000));
    }

    @Test
    public void testDifferentCompactFormats_complexCase() {
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.SHORT);

        // when / then:
        Assertions.assertEquals("1K", fmt.format(1234));
        Assertions.assertEquals("123K", fmt.format(123456));
        Assertions.assertEquals("1M", fmt.format(1234567));

        Assertions.assertEquals("1K", fmt.format(1499));
        Assertions.assertEquals("2K", fmt.format(1500));

        Assertions.assertEquals("1M", fmt.format(1499999));
        Assertions.assertEquals("2M", fmt.format(1500000));
    }
}
