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
    private int diffculty = PlayerManager.getDifficulty();
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
    

    public Round(List<Tower> _activeTowers, AnchorPane anchorPane, Button _startButton, Button _shopButton, MainGameController mg, RoundManager rm){
        spawner = new Timeline(new KeyFrame(Duration.seconds(1), e -> spawnCart(anchorPane, mg, rm)));
        spawner.setCycleCount(Animation.INDEFINITE);
        rangeCheck = new Timeline(new KeyFrame(Duration.seconds(0.1), e -> checkRange(rm)));
        rangeCheck.setCycleCount(Animation.INDEFINITE);

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

    private void spawnCart(AnchorPane anchorPane, MainGameController mg, RoundManager rm){
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

    private void checkRange(RoundManager rm){
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
                    System.out.println("Nearly there");
                    if(cart.getPosition().getY() <= killDistance && spawner.getStatus().equals(Animation.Status.STOPPED)){
                        System.out.println(GameOverManager.gameOver);
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