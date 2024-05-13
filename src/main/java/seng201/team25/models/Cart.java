package seng201.team25.models;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Cart {
    private Image cartSprite = new Image(getClass().getResourceAsStream("/assets/cart.png"));

    public Cart(AnchorPane anchorPane){
        ImageView cart = new ImageView();
        cart.setImage(cartSprite);
        cart.setX(531);
        cart.setY(600);
        cart.setScaleX(0.7);
        cart.setScaleY(0.7);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long timestamp) {
                cart.setLayoutY(cart.getLayoutY() - 1);
            }
        };

        timer.start();

        anchorPane.getChildren().add(cart);
    }
}
