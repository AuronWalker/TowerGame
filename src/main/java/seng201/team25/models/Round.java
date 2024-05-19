package seng201.team25.models;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import seng201.team25.services.GameOverManager;
import seng201.team25.services.GoldManager;
import seng201.team25.services.PlayerManager;

public class Round {
    private int diffculty = PlayerManager.getDifficulty();
    private int spawnerTimer;
    private List<Cart> activeCarts;
    private List<Tower> activeTowers;
    private int amountOfCarts = 0;
    private Timeline spawner;
    private Timeline rangeCheck;
    private Button startButton;
    private Button shopButton;
    

    public Round(int _roundNum, List<Tower> _activeTowers, AnchorPane anchorPane, Button _startButton, Button _shopButton){
        spawner = new Timeline(new KeyFrame(Duration.seconds(1), e -> spawnCart(anchorPane)));
        spawner.setCycleCount(Animation.INDEFINITE);
        rangeCheck = new Timeline(new KeyFrame(Duration.seconds(0.1), e -> checkRange()));
        rangeCheck.setCycleCount(Animation.INDEFINITE);

        startButton = _startButton;
        shopButton = _shopButton;

        activeCarts = new ArrayList<Cart>();
        activeTowers = _activeTowers;
        spawnerTimer = 5;
        
        spawner.playFromStart();
        rangeCheck.playFromStart();
    }

    private void spawnCart(AnchorPane anchorPane){
        spawnerTimer += 1;
        if(spawnerTimer >= 5){
            activeCarts.add(new Cart(anchorPane, 1, 0, 10));
            amountOfCarts += 1;
            spawnerTimer = 0;
        }
        
        if(amountOfCarts >= 3){
            spawner.stop();
            spawnerTimer = 5; 
        }
    }

    private void checkRange(){
        int killDistance = -40;
        for (Tower tower : activeTowers) {
            tower.lowerCurrentReloadSpeed();
            int cartIndex = 0;
            for (Cart cart : activeCarts) {
                cartIndex += 1;
                double distance = cart.getPosition().distance(tower.getPosition());
                if(distance<80 && tower.getCurrentReloadSpeed() <= 0){
                    cart.fillCart(1);
                    tower.resetCurrentReloadSpeed();
                }
                if(cartIndex == activeCarts.size()){
                    if(cart.getPosition().getY() <= killDistance && spawner.getStatus().equals(Animation.Status.STOPPED)){
                        rangeCheck.stop();
                        if(!GameOverManager.gameOver){
                            startButton.setVisible(true);
                            shopButton.setVisible(true);
                            activeCarts = new ArrayList<Cart>();
                            GoldManager.setGold(5);
                        }
                    }
                }
            }
        }
    }
}