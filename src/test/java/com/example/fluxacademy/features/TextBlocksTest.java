package com.example.fluxacademy.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TextBlocksTest {

    @Test
    public void simpleTest() {
        // given:
        String oldSyntax = "{\n" +
                "  \"name\": \"John Doe\",\n" +
                "  \"age\": 45,\n" +
                "  \"address\": \"Doe Street, 23, Java Town\"\n" +
                "}";

        String newSyntax = """
                {
                  "name": "John Doe",
                  "age": 45,
                  "address": "Doe Street, 23, Java Town"
                }""";
        // when:
        System.out.println(oldSyntax);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(newSyntax);
        // then:
        Assertions.assertEquals(oldSyntax, newSyntax);
    }

    @Test
    public void simpleTestWithPreceding () {
        // given:
        String oldSyntax = "{\n" +
                "  \"name\": \"John Doe\",\n" +
                "  \"age\": 45,\n" +
                "  \"address\": \"Doe Street, 23, Java Town\"\n" +
                "}";

        String newSyntaxNoSpaces = """
                {
                  "name": "John Doe",
                  "age": 45,
                  "address": "Doe Street, 23, Java Town"
                }""";

        String textWithAdditionalSpacingLeft = """
                {
                  "name": "John Doe",
                  "age": 45,
                  "address": "Doe Street, 23, Java Town"
                }
             """;

        String textWithAdditionalSpacingRight = """
                {
                  "name": "John Doe",
                  "age": 45,
                  "address": "Doe Street, 23, Java Town"
                }
                    """;
        // when:
        System.out.println(oldSyntax);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(newSyntaxNoSpaces);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(textWithAdditionalSpacingLeft);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(textWithAdditionalSpacingRight);
        // then:
        Assertions.assertEquals(oldSyntax, newSyntaxNoSpaces);
        Assertions.assertNotEquals(oldSyntax, textWithAdditionalSpacingLeft);
        Assertions.assertNotEquals(newSyntaxNoSpaces, textWithAdditionalSpacingRight); // due to new line at end
    }
}

