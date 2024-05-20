package seng201.team25.unittests.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.geometry.Point2D;
import javafx.scene.layout.AnchorPane;
import seng201.team25.gui.MainGameController;
import seng201.team25.models.Cart;

public class CartTest {
    private AnchorPane anchorPane;
    private MainGameController mg;
    private Cart cart;

    /**
    * Testing that creating a cart works.
    * Called before other test are ran providing variables
    **/
    @BeforeEach
    void setUp() {
        anchorPane = new AnchorPane();
        mg = new MainGameController();
        cart = new Cart(anchorPane, 5, 0, 10, mg);
    }

    /**
    * Testing that the inital values are set correctly.
    **/
    @Test
    void testConstructor() {
        assertEquals(0, cart.getResourceType());
        assertEquals(new Point2D(0, 600), cart.getPosition());
    }

    /**
    * Testing that cart filling works.
    **/
    @Test
    void testFillCart() {
        cart.fillCart(5);
        assertEquals(5, cart.getResourceType());

        cart.fillCart(10);
        assertEquals(10, cart.getResourceType()); // Should not exceed totalResource
    }

    /**
    * Testing that cart filling works.
    **/
    @Test
    void testGetPosition() {
        //Unsure of how to change movement from a test doc with something that has a thread
        Point2D initialPosition = cart.getPosition();
        assertEquals(new Point2D(0, 600), initialPosition);
    }

    /**
    * Testing carts can have different resource types.
    **/
    @Test
    void testGetResourceType() {
        assertEquals(0, cart.getResourceType()); // Resource type tree (0)
        
        Cart rockCart = new Cart(anchorPane, 5, 1, 10, mg);
        assertEquals(1, rockCart.getResourceType()); // Resource type rock (1)
        
        Cart fruitCart = new Cart(anchorPane, 5, 2, 10, mg);
        assertEquals(2, fruitCart.getResourceType()); // Resource type fruit (2)
    }
}
