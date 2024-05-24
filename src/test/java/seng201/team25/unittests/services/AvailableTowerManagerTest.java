package seng201.team25.unittests.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team25.models.Tower;
import seng201.team25.services.AvailableTowerManager;

import static org.junit.jupiter.api.Assertions.*;

public class AvailableTowerManagerTest {
    // Store the available towers, for use in testing later
    private final Tower[] towersToBuy = {
            new Tower(0, 1, 2,1,1),
            new Tower(1, 1, 1, 1, 2),
            new Tower(2, 1, 1, 1, 3),
            new Tower(3, 0, -2, 1, 4),
            new Tower(4, 0, -2, 1, 5)};

    private static final String[] resourceTypeMap = {"Wood", "Stone", "Fruit", "Upgrade 1", "Upgrade 2"};

    @BeforeEach
    void beforeEach() {
        AvailableTowerManager.clearAvailableTowers();
    }

    @Test
    final void testTowersToBuy() {
        assertArrayEquals(AvailableTowerManager.getTowersToBuy(), AvailableTowerManager.towersToBuy);
    }

    @Test
    final void testAddNumber() {
        // Add a tower, check numberOfTowers is 1
        AvailableTowerManager.addAvailableTower(towersToBuy[0]);
        assertEquals(AvailableTowerManager.numberOfTowers(), 1);

        // Add 50 towers, check numberOfTowers is 51
        for (int i = 0; i < 50; i++) {
            AvailableTowerManager.addAvailableTower(towersToBuy[i % 5]);
        }
        assertEquals(AvailableTowerManager.numberOfTowers(), 51);

        // Check number of towers of type override
        assertEquals(AvailableTowerManager.numberOfTowers(1), 10);
    }

    @Test
    void testRemoveAndClear() {
        // Clear towers (beforeEach), so check we are at 0
        assertEquals(AvailableTowerManager.numberOfTowers(), 0);

        // Remove a tower that isn't in the available towers from the list, check false returned
        assertFalse(AvailableTowerManager.removeTowerOfType(0));

        // Add 50 towers, none of which have resource ID 5, then check we can't remove resource ID 5
        for (int i = 0; i < 50; i++) {
            AvailableTowerManager.addAvailableTower(towersToBuy[i % 4]);
        }
        assertFalse(AvailableTowerManager.removeTowerOfType(5));

        // Remove a tower of a resource type we do have, then check the count decreased
        assertTrue(AvailableTowerManager.removeTowerOfType(1));
        assertEquals(AvailableTowerManager.numberOfTowers(), 49);

        // Verify we can clear a larger number of towers
        AvailableTowerManager.clearAvailableTowers();
        assertEquals(AvailableTowerManager.numberOfTowers(), 0);
    }

    @Test
    final void testResourceString() {
        for (int i = 0; i < 5; i++) {
            assertEquals(AvailableTowerManager.getResourceTypeString(i), resourceTypeMap[i]);
        }
    }

    @Test
    final void testAvailableIndex() {
        AvailableTowerManager.clearAvailableTowers();
        assertEquals(AvailableTowerManager.getNextAvailableIndex(), 0);
        AvailableTowerManager.addAvailableTower(towersToBuy[0]);
        assertEquals(AvailableTowerManager.getNextAvailableIndex(), 1);
        AvailableTowerManager.addAvailableTower(towersToBuy[0]);
        assertEquals(AvailableTowerManager.getNextAvailableIndex(), 2);
        AvailableTowerManager.addAvailableTower(towersToBuy[0]);
        assertEquals(AvailableTowerManager.getNextAvailableIndex(), -1);
    }

}
