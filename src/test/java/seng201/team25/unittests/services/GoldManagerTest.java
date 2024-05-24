package seng201.team25.unittests.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team25.services.GoldManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldManagerTest {
    @BeforeEach
    void resetGoldManager() {
        GoldManager.setGold(0);
    }
    @Test
    final void testInitialGoldBalance() {
        assertEquals(GoldManager.getGoldBalance(), 0);
    }

    @Test
    final void testSetGold() {
        // Check setting works
        GoldManager.setGold(1);
        assertEquals(GoldManager.getGoldBalance(), 1);

        // Check setting a second time overwrites old value
        GoldManager.setGold(5);
        assertEquals(GoldManager.getGoldBalance(), 5);

        // Check very large numbers work
        GoldManager.setGold(9999999);
        assertEquals(GoldManager.getGoldBalance(), 9999999);

        // Implied that zero values work by BeforeEach
        // No checking against negative numbers, as setGold is only ever used to set gold >= 0 in code
    }

    @Test
    final void testGoldIncrement() {
        // Adding 5 should increase to 5
        GoldManager.increaseGoldBalance(5);
        assertEquals(GoldManager.getGoldBalance(),5);

        // Adding 5 should increase to 10
        GoldManager.increaseGoldBalance(5);
        assertEquals(GoldManager.getGoldBalance(),10);

        // Adding 1,000,000 should increase to 1,000,010
        GoldManager.increaseGoldBalance(1000000);
        assertEquals(GoldManager.getGoldBalance(),1000010);
    }

    @Test
    final void testGoldDecrement() {
        // Setting initial 10 gold, taking 5. decreaseGoldBalance should return 5, getGoldBalance should return 5
        GoldManager.setGold(10);
        assertEquals(GoldManager.decreaseGoldBalance(5), 5);
        assertEquals(GoldManager.getGoldBalance(), 5);

        // Take more gold than we have, should return -1. Taking exact amount we have should return 0
        assertEquals(GoldManager.decreaseGoldBalance(6), -1);
        assertEquals(GoldManager.decreaseGoldBalance(9999999), -1);
        assertEquals(GoldManager.decreaseGoldBalance(5), 0);
        // not testing -ve numbers, never used

        // Taking a small amount from a very large amount
        GoldManager.setGold(1000000);
        assertEquals(GoldManager.decreaseGoldBalance(1), 999999);
    }
}
