package seng201.team25.models;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Point2D;

public class Cart {
    private Image cartSprite = new Image(getClass().getResourceAsStream("/assets/cart/cart.png"));
    private Image treeDisplay = new Image(getClass().getResourceAsStream("/assets/cart/cartTree.png"));
    private int xLayout = 531;
    private int totalResource;
    private int currentResource=0;
    private Label amount;
    private Point2D position;

    public Cart(AnchorPane anchorPane, int speed, int resourceType, int _totalResource){
        ImageView cart = new ImageView();
        ImageView cartDisplay = new ImageView();
        amount = new Label();
        totalResource = _totalResource;

        cart.setImage(cartSprite);
        setDisplay(cartDisplay, resourceType);

        cartDisplay.setLayoutX(xLayout);
        cartDisplay.setLayoutY(505);
        amount.setLayoutX(575);
        amount.setLayoutY(720);
        amount.setText(currentResource+"/"+totalResource);
        amount.setTextFill(Color.BLACK);

        cart.setLayoutX(528);
        cart.setLayoutY(600);
        
        cartDisplay.setScaleX(0.7);
        cartDisplay.setScaleY(0.7);
        cart.setScaleX(0.7);
        cart.setScaleY(0.7);
        amount.setFont(Font.font(30));
        amount.setStyle("-fx-font-weight: bold");

        position = new Point2D(0, cart.getLayoutY());
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long timestamp) {
                cart.setLayoutY(cart.getLayoutY() - speed);
                cartDisplay.setLayoutY(cartDisplay.getLayoutY() - speed);
                amount.setLayoutY(amount.getLayoutY() - speed);
                position = new Point2D(0, cart.getLayoutY());
            }
        };
        timer.start();


        
        anchorPane.getChildren().add(cart);
        anchorPane.getChildren().add(cartDisplay);
        anchorPane.getChildren().add(amount);
    }

    private void setDisplay(ImageView cartDisplay, int resourceType){
        if(resourceType == 0){
            cartDisplay.setImage(treeDisplay);
        }
    }

    public void fillCart(int fillAmount){
        currentResource += fillAmount;
        if(currentResource > totalResource) currentResource = totalResource;
        amount.setText(currentResource+"/"+totalResource);
    }

    public Point2D getPosition(){
        return position;
    }
}
