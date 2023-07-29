package com.emikobell.urlshortener;

import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EncodeTests {

    @Test
    public void encodedStringIsBase62() throws Exception {
        
        // given
        long testNum = 9999999999999L;
        String expectedString = "2q3Rktod";

        // when
        String encodedString = Encode.encodeBase62(testNum);

        // then
        assertEquals(encodedString, expectedString);
    }

    @Test
    public void encodeAnyLongToBase62() throws Exception {

        // given 
        long testNum = new Random().nextLong();

        // when
        String encodedString = Encode.encodeBase62(testNum);

        // then
        assertNotNull(encodedString);
    }

    @Test
    public void decodedStringIsBase10() throws Exception {

        // given
        String testBase64 = "5AlM98a";
        long expectedLong = 293862272376L;

        // when
        long decodedLong = Encode.decodeBase62(testBase64);

        // then
        assertEquals(decodedLong, expectedLong);
    }
}
