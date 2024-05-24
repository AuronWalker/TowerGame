package seng201.team25.unittests.services;

import javafx.application.Platform;
import javafx.scene.control.Label;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seng201.team25.services.PlayerManager;
import seng201.team25.services.RoundManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoundManagerTest {
    private static RoundManager roundManager;


    @BeforeAll
    static void testInitialisation() {
        // Although this class isn't a JFX controller, it references JFX objects. Need a dummy display to test.
        Platform.startup(() -> {});
        PlayerManager.storeValues("DummyName", 5, 5);
        roundManager = new RoundManager(new Label());
    }

    @Test
    final void testSavedRounds() {
        assertEquals(roundManager.getMaxRounds(), PlayerManager.getRounds());
    }

    @Test
    final void testRoundsAndWin() {
        // Check current round is 0
        assertEquals(roundManager.getCurrentRound(), 0);

        // Check each increment increases the current round by 1
        for (int i = 0; i < 5; i++) {
            roundManager.incrementCurrentRound();
            assertEquals(roundManager.getCurrentRound(), i + 1);
        }

        // We should have now hit the win condition. Check we have won.
        assertTrue(roundManager.checkWon());

        // UI prevents further rounds from being played, ignoring case where currentRound > maxRound
    }
}
