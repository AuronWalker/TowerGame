package seng201.team25.unittests.services;

import org.junit.jupiter.api.Test;
import seng201.team25.services.NameVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameVerifierTest {
    @Test
    void testLength() {
        // Test min and max length
        assertEquals(1, NameVerifier.verifyName("aaa"));
        assertEquals(1, NameVerifier.verifyName("aaaaaaaaaaaaaaa"));

        // Test edges
        assertEquals(-2, NameVerifier.verifyName("aa"));
        assertEquals(-2, NameVerifier.verifyName("aaaaaaaaaaaaaaaa"));

        // Test extremes
        assertEquals(-2, NameVerifier.verifyName(""));
        assertEquals(-2, NameVerifier.verifyName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    @Test
    void testSymbols() {
        // Test common symbols
        assertEquals(-1, NameVerifier.verifyName("!aa"));
        assertEquals(-1, NameVerifier.verifyName("@aa"));
        assertEquals(-1, NameVerifier.verifyName("#aa"));
        assertEquals(-1, NameVerifier.verifyName("$aa"));
        assertEquals(-1, NameVerifier.verifyName("%aa"));
        assertEquals(-1, NameVerifier.verifyName("^aa"));
        assertEquals(-1, NameVerifier.verifyName("&aa"));
        assertEquals(-1, NameVerifier.verifyName("*aa"));
        assertEquals(-1, NameVerifier.verifyName("(aa"));
        assertEquals(-1, NameVerifier.verifyName(")aa"));
        assertEquals(-1, NameVerifier.verifyName("+aa"));
        assertEquals(-1, NameVerifier.verifyName("-aa"));
        assertEquals(-1, NameVerifier.verifyName(".aa"));
        assertEquals(-1, NameVerifier.verifyName("/aa"));
    }
}
