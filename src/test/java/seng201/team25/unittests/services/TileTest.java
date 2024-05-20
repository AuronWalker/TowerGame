package seng201.team25.unittests.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seng201.team25.models.Tile;
import seng201.team25.models.Tower;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TileTest {
    private Tile tile;
    private Tower mockTower;

    /**
    * Testing that creating a tile works.
    * Called before other test are ran providing variables
    **/
    @BeforeEach
    void setUp() {
        tile = new Tile();
        mockTower = mock(Tower.class);
    }

    /**
    * Testing that the inital values are set correctly.
    **/
    @Test
    void testConstructor() {
        assertNull(tile.getTower());
        assertFalse(tile.hasTower());
    }

    /**
    * Testing that a tower can be set to tile.
    **/
    @Test
    void testSetTower() {
        tile.setTower(mockTower);
        assertEquals(mockTower, tile.getTower());
        assertTrue(tile.hasTower());
    }

    /**
    * Testing that tower on tile can be sold.
    **/
    @Test
    void testSellTower() {
        tile.setTower(mockTower);
        when(mockTower.getCost()).thenReturn(100);

        tile.sellTower();

        assertNull(tile.getTower());
        assertFalse(tile.hasTower());
        verify(mockTower, times(1)).getCost();
    }

    /**
    * Testing that the boolean is false if there is no tower and true if there is.
    **/
    @Test
    void testHasTower() {
        assertFalse(tile.hasTower());
        tile.setTower(mockTower);
        assertTrue(tile.hasTower());
    }

    /**
    * Testing that the tower on tile can be accessed
    **/
    @Test
    void testGetTower() {
        assertNull(tile.getTower());
        tile.setTower(mockTower);
        assertEquals(mockTower, tile.getTower());
    }
}
