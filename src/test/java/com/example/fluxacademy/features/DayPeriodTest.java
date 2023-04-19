package com.example.fluxacademy.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@ExtendWith(MockitoExtension.class)
public class DayPeriodTest {

    @Test
    public void dayPeriodTest_english() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("B");
        Assertions.assertEquals("in the morning", dateTimeFormatter.format(LocalTime.of(8, 0)));
        Assertions.assertEquals("in the afternoon", dateTimeFormatter.format(LocalTime.of(13, 0)));
        Assertions.assertEquals("in the evening", dateTimeFormatter.format(LocalTime.of(20, 0)));
        Assertions.assertEquals("at night", dateTimeFormatter.format(LocalTime.of(23, 0)));
        Assertions.assertEquals("midnight", dateTimeFormatter.format(LocalTime.of(0, 0)));
    }

    @Test
    public void dayPeriodTest_german() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("B").withLocale(Locale.forLanguageTag("DE"));
        Assertions.assertEquals("morgens", dateTimeFormatter.format(LocalTime.of(8, 0)));
        Assertions.assertEquals("nachmittags", dateTimeFormatter.format(LocalTime.of(13, 0)));
        Assertions.assertEquals("abends", dateTimeFormatter.format(LocalTime.of(20, 0)));
        Assertions.assertEquals("abends", dateTimeFormatter.format(LocalTime.of(23, 0))); // notice that evening and night are same
        Assertions.assertEquals("Mitternacht", dateTimeFormatter.format(LocalTime.of(0, 0)));
    }


    @Test
    public void dayPeriodTest_edgeCases() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("B");
        Assertions.assertEquals("in the morning", dateTimeFormatter.format(LocalTime.of(11, 59)));
        Assertions.assertEquals("noon", dateTimeFormatter.format(LocalTime.of(12, 00)));
        Assertions.assertEquals("in the afternoon", dateTimeFormatter.format(LocalTime.of(12, 01)));

        Assertions.assertEquals("in the afternoon", dateTimeFormatter.format(LocalTime.of(17, 59)));
        Assertions.assertEquals("in the evening", dateTimeFormatter.format(LocalTime.of(18, 00))); // english evening starts at 18
        Assertions.assertEquals("in the evening", dateTimeFormatter.format(LocalTime.of(20, 59)));

        Assertions.assertEquals("at night", dateTimeFormatter.format(LocalTime.of(21, 0))); // english night starts at 21
        Assertions.assertEquals("midnight", dateTimeFormatter.format(LocalTime.of(0, 0)));
        Assertions.assertEquals("at night", dateTimeFormatter.format(LocalTime.of(05, 59)));
        Assertions.assertEquals("in the morning", dateTimeFormatter.format(LocalTime.of(06, 00)));  // english morning starts at 6

    }

    @Test
    public void dayPeriodTest_CulturalDifferences() {
        DateTimeFormatter englishFormatter = DateTimeFormatter.ofPattern("B");
        DateTimeFormatter germanFormatter = DateTimeFormatter.ofPattern("B").withLocale(Locale.forLanguageTag("DE"));

        Assertions.assertEquals("at night", englishFormatter.format(LocalTime.of(05, 00)));
        Assertions.assertEquals("in the morning", englishFormatter.format(LocalTime.of(06, 00)));  // english morning starts at 6

        Assertions.assertEquals("nachts", germanFormatter.format(LocalTime.of(04, 00)));
        Assertions.assertEquals("morgens", germanFormatter.format(LocalTime.of(05, 00)));  // german morning starts at 5 :)

    }

}
