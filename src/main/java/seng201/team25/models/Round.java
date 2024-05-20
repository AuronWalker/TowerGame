package seng201.team25.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import seng201.team25.gui.MainGameController;
import seng201.team25.services.GameOverManager;
import seng201.team25.services.GoldManager;
import seng201.team25.services.PlayerManager;
import seng201.team25.services.RoundManager;

public class Round {
    private int spawnerTimer;
    private List<Cart> activeCarts;
    private List<Tower> activeTowers;
    private int amountOfCarts = 0;
    private int totalCarts = 3;
    private Timeline spawner;
    private Timeline rangeCheck;
    private Button startButton;
    private Button shopButton;
    private Random rng;

    private RoundManager rm;
    private MainGameController mg;
    
    /**
    * Sets the Round based on difficulty and what round it currently is.
    * @param _activeTowers List of all current towers in the game.
    * @param _anchorPane Anchor pane to attach the cart image to.
    * @param _startButton Button that starts the round.
    * @param _shopButton Button that opens the shop.
    * @param mg Game controller to send to cart when spawned.
    * @param rm Round manager with all the relevant info for the round.
    **/
    public Round(List<Tower> _activeTowers, AnchorPane anchorPane, Button _startButton, Button _shopButton, MainGameController _mg, RoundManager _rm){
        spawner = new Timeline(new KeyFrame(Duration.seconds(1), e -> spawnCart(anchorPane)));
        spawner.setCycleCount(Animation.INDEFINITE);
        rangeCheck = new Timeline(new KeyFrame(Duration.seconds(0.1), e -> checkRange()));
        rangeCheck.setCycleCount(Animation.INDEFINITE);

        rm = _rm;
        mg = _mg;
        rng = new Random();

        startButton = _startButton;
        shopButton = _shopButton;

        activeCarts = new ArrayList<Cart>();
        activeTowers = _activeTowers;
        spawnerTimer = 4;
        totalCarts += rm.getCurrentRound();
        
        spawner.playFromStart();
        rangeCheck.playFromStart();
    }

    /**
    * Spawns the cart at an interval set by spwnerTimer
    * @param _anchorPane Anchor pane to attach the cart image to.
    **/
    private void spawnCart(AnchorPane anchorPane){
        int resourceType = rng.nextInt(1);
        if(rm.getCurrentRound() == 1){
            resourceType = rng.nextInt(2);
        } else if(rm.getCurrentRound() >= 2){
            resourceType = rng.nextInt(3);
        }

        spawnerTimer += 1;
        if(spawnerTimer >= 5){
            activeCarts.add(new Cart(anchorPane, 1, resourceType, 10, mg));
            amountOfCarts += 1;
            spawnerTimer = 0;
        }
        
        if(amountOfCarts >= 3){
            spawner.stop();
            spawnerTimer = 5; 
        }
    }

    /**
    * Checks the distance between the tower and the cart to know when to fill
    **/
    private void checkRange(){
        int killDistance = -40;
        for (Tower tower : activeTowers) {
            tower.lowerCurrentReloadSpeed();
            int cartIndex = 0;
            for (Cart cart : activeCarts) {
                cartIndex += 1;
                double distance = cart.getPosition().distance(tower.getPosition());
                if(distance<80 && tower.getCurrentReloadSpeed() <= 0 && tower.getResourceType() == cart.getResourceType()){
                    cart.fillCart(1);
                    tower.resetCurrentReloadSpeed();
                }
                if(cartIndex == activeCarts.size()){
                    if(cart.getPosition().getY() <= killDistance && spawner.getStatus().equals(Animation.Status.STOPPED)){
                        if(GameOverManager.gameOver == false){
                            startButton.setVisible(true);
                            shopButton.setVisible(true);
                            activeCarts = new ArrayList<Cart>();
                            GoldManager.setGold(5);
                            rm.incrementCurrentRound();
                        }
                        rangeCheck.stop();
                    }
                }
            }
        }
    }
}