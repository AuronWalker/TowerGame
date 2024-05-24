package seng201.team25.unittests.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team25.models.Tower;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TowerTest {
    @Test
    void testLevelModifiers() {
        // make a new tower, assert initial level is 1, reload speed is 3, resource amount is 1
        Tower tower = new Tower(0);
        assertEquals(1, tower.getLevel());
        assertEquals(3, tower.getCurrentReloadSpeed());
        assertEquals(1, tower.getResourceAmount());
        assertEquals(3, tower.getReloadSpeed());

        // increment the tower level, ensure equals 2
        tower.increaseLevel();
        assertEquals(2, tower.getLevel());
        assertEquals(2, tower.getReloadSpeed());
        assertEquals(2, tower.getResourceAmount());
    }

    @Test
    void testReloadSpeedModifiers() {
        Tower tower = new Tower(0);
        assertEquals(3, tower.getReloadSpeed());
        tower.lowerCurrentReloadSpeed();
        assertEquals(2, tower.getCurrentReloadSpeed());
        tower.resetCurrentReloadSpeed();
        assertEquals(3, tower.getCurrentReloadSpeed());

        // not testing -ve case, prevented by RoundController logic.
    }

    @Test
    void testCost() {
        Tower tower = new Tower(0);
        assertEquals(0, tower.getCost());
    }
}
