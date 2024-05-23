package seng201.team25.unittests.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import seng201.team25.models.Tower;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TowerTest {
    private Tower tower;
    private ImageView mockEmptyTile;
    private ImageView mockDisplayTile;

    /**
    * Testing that creating a tower works
    * Called before other test are ran providing variables
    **/
    @BeforeEach
    void setUp() {
        mockEmptyTile = mock(ImageView.class);
        mockDisplayTile = mock(ImageView.class);
        when(mockEmptyTile.getLayoutY()).thenReturn(100.0);
    }

    
    @Test
    void testConstructorWithoutStats() {
        tower = new Tower(1);
        assertEquals(1, tower.getResourceType());
        assertEquals(1, tower.getLevel());
        assertEquals(1, tower.getResourceAmount());
        assertEquals(3, tower.getReloadSpeed());
    }

    @Test
    void testConstructorWithTilesAndDirection() {
        tower = new Tower(1, mockEmptyTile, mockDisplayTile, true);
        assertEquals(1, tower.getResourceType());
        assertEquals(mockDisplayTile, tower.getCurrentDisplay());
        assertEquals(mockEmptyTile, tower.getCurrentTile());
    }

    @Test
    void testConstructorWithStats() {
        tower = new Tower(1, 2, 3, 4, 5);
        assertEquals(1, tower.getResourceType());
        assertEquals(2, tower.getResourceAmount());
        assertEquals(3, tower.getReloadSpeed());
        assertEquals(4, tower.getLevel());
        assertEquals(5, tower.getCost());
    }

    @Test
    void testSetCost() {
        tower = new Tower(0);
        assertEquals(1, tower.getCost());
        tower = new Tower(1);
        assertEquals(2, tower.getCost());
        tower = new Tower(2);
        assertEquals(3, tower.getCost());
        tower = new Tower(3);
        assertEquals(4, tower.getCost());
        tower = new Tower(4);
        assertEquals(5, tower.getCost());
    }

    @Test
    void testIncreaseLevel() {
        tower = new Tower(1);
        tower.increaseLevel();
        assertEquals(2, tower.getLevel());
        assertEquals(2, tower.getResourceAmount());
        assertEquals(2, tower.getReloadSpeed());
    }

    @Test
    void testDecreaseLevel() {
        tower = new Tower(1, 2, 2, 2, 5);
        tower.decreaseLevel();
        assertEquals(1, tower.getLevel());
        assertEquals(1, tower.getResourceAmount());
        assertEquals(3, tower.getReloadSpeed());
    }

    @Test
    void testGetPosition() {
        tower = new Tower(1, mockEmptyTile, mockDisplayTile, true);
        assertEquals(new Point2D(0, 100.0), tower.getPosition());
    }

    @Test
    void testReloadSpeed() {
        tower = new Tower(1);
        assertEquals(3, tower.getReloadSpeed());
        assertEquals(3, tower.getCurrentReloadSpeed());
        tower.lowerCurrentReloadSpeed();
        assertEquals(2, tower.getCurrentReloadSpeed());
        tower.resetCurrentReloadSpeed();
        assertEquals(3, tower.getCurrentReloadSpeed());
    }

    @Test
    void testGetResourceType() {
        tower = new Tower(1);
        assertEquals(1, tower.getResourceType());
    }

    @Test
    void testGetResourceAmount() {
        tower = new Tower(1, 2, 3, 4, 5);
        assertEquals(2, tower.getResourceAmount());
    }
}
