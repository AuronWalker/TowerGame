package seng201.team25.unittests.services;

import org.junit.jupiter.api.Test;
import seng201.team25.services.PlayerManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerManagerTest {
    @Test
    final void testStoreValues() {
        // These input values are limited by the UI - no need to check edge cases here
        PlayerManager.storeValues("Name", 3, 10);
        assertEquals(PlayerManager.getPlayerName(), "Name");
        assertEquals(PlayerManager.getDifficulty(), 3);
        assertEquals(PlayerManager.getRounds(), 10);
    }
}
