package com.example.fluxacademy.features;

import com.example.fluxacademy.records.Kangaroo;
import com.example.fluxacademy.records.Kiwi;
import com.example.fluxacademy.records.Koala;
import com.example.fluxacademy.records.SmartKoala;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RecordTest {

    @Test
    public void testRecords() {
        // given
        Kangaroo kangaroo = new Kangaroo(1, true); // lombok
        Kiwi kiwi = new Kiwi(); // plain java
        Koala koala = new Koala(1, false); // record
//        Koala koala_noArgs = new Koala(); // no arg c'tor not avilable

        // hashCodes

        System.out.println(kangaroo.hashCode());
        System.out.println(kiwi.hashCode());
        System.out.println(koala.hashCode());
        System.out.println("---------------------------------------------------------------------------");
        // to Strings
        System.out.println(kangaroo);
        System.out.println(kiwi);
        System.out.println(koala);

        // assertions
        Assertions.assertEquals(koala.tails(), kangaroo.getTails());
    }

    @Test
    public void testRecords_testCopies() {
        // given
        Koala koala = new Koala(1, false);

        Koala koalaCopy = new Koala(koala.tails(), koala.canHoop());
        // to Strings
        System.out.println(koala);
        System.out.println(koala.hashCode());
        System.out.println(koalaCopy);
        System.out.println(koalaCopy.hashCode());
        // assertions
        Assertions.assertEquals(koala, koalaCopy);
        Assertions.assertNotSame(koala, koalaCopy); // equivalent ==
    }

    @Test
    public void testRecords_testSmartContructor() {
        // given
        Koala koala = new Koala(1, true);
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            new SmartKoala(koala.tails(), koala.canHoop());
        });
        Assertions.assertEquals("SmartKoala wouldn't do that", exception.getMessage());
    }
}
