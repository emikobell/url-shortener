package com.emikobell.urlshortener;

import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EncodeTests {

    @Test
    public void encodedStringIsBase62() throws Exception {
        long testNum = 9999999999999L;
        String encodedString = Encode.encodeBase62(testNum);
        String expectedString = "2q3Rktod";
        assertEquals(encodedString, expectedString);
    }

    @Test
    public void encodeAnyLongToBase62() throws Exception {
        long testNum = new Random().nextLong();
        String encodedString = Encode.encodeBase62(testNum);
        assertNotNull(encodedString);
    }
}
