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

//No unit test due to it being more of a servcie than a class making it very hard to test
//I may come back and add a bunch of functions to add a unit test latter if there is time.

/**
 * Manages each round of the game, including speed and difficulty.
 */
public class Round {
    private int spawnerTimer;
    private List<Cart> activeCarts;
    private final List<Tower> activeTowers;
    private int amountOfCarts = 0;
    private final int totalCarts;
    private final Timeline spawner;
    private final Timeline rangeCheck;
    private final Button startButton;
    private final Button shopButton;
    private final Random rng;
    private final boolean roundDifficulty;
    private final AnchorPane anchorPane;

    private int amountOfTree;
    private int amountOfRock;
    private int amountOfFruit;

    private final RoundManager rm;
    private final MainGameController mg;
    
    /**
    * Sets the Round based on difficulty and what round it currently is.
    * @param _activeTowers List of all current towers in the game.
    * @param _anchorPane Anchor pane to attach the cart image to.
    * @param _startButton Button that starts the round.
    * @param _shopButton Button that opens the shop.
    * @param _mg Game controller to send to cart when spawned.
    * @param _rm Round manager with all the relevant info for the round.
     * @param _roundDifficulty The requested difficulty of the game.
     * @param treeCarts the number of tree carts in the round
     * @param fruitCarts the number of fruit carts in the round
     * @param rockCarts the number of stone carts in the round
    **/
    public Round(boolean _roundDifficulty, int treeCarts, int rockCarts, int fruitCarts, List<Tower> _activeTowers, AnchorPane _anchorPane, Button _startButton, Button _shopButton, MainGameController _mg, RoundManager _rm){
        anchorPane = _anchorPane;
        spawner = new Timeline(new KeyFrame(Duration.seconds(1), e -> spawnCart(anchorPane)));
        spawner.setCycleCount(Animation.INDEFINITE);
        rangeCheck = new Timeline(new KeyFrame(Duration.seconds(0.1), e -> checkRange()));
        rangeCheck.setCycleCount(Animation.INDEFINITE);

        roundDifficulty = _roundDifficulty;
        rm = _rm;
        mg = _mg;
        rng = new Random();

        startButton = _startButton;
        shopButton = _shopButton;

        amountOfTree = treeCarts;
        amountOfRock = rockCarts;
        amountOfFruit = fruitCarts;

        activeCarts = new ArrayList<>();
        activeTowers = _activeTowers;
        spawnerTimer = 4;
        totalCarts = treeCarts + fruitCarts + rockCarts;
        
        spawner.playFromStart();
        rangeCheck.playFromStart();
    }

    /**
    * Spawns the cart at an interval set by spawnerTimer.
    * @param anchorPane Anchor pane to attach the cart image to.
    **/
    private void spawnCart(AnchorPane anchorPane){
        //Gets how many of each resource is spawning.
        int amountResources = 1;
        if(amountOfTree != 0) amountResources +=1;
        else if(amountOfRock != 0) amountResources +=1;
        else if(amountOfFruit != 0) amountResources +=1;

        //Picks a random one of those resources
        spawnerTimer += 1;
        if(spawnerTimer >= 5){
            int resourceType = rng.nextInt(amountResources);
            resourceType = getResource(resourceType);

            //Scale how likely cart is to get a speed boost by current round and game difficulty
            int randomSpeedBoost = rng.nextInt(10 - rm.getCurrentRound() - PlayerManager.getDifficulty());
            float speed = 0.7f + ((float) PlayerManager.getDifficulty() /10) + ((float) rm.getCurrentRound() /10);
            if(randomSpeedBoost == 0) speed += 0.3f;
            System.out.println(speed);

            int totalResource = 10 + rm.getCurrentRound();
            if(roundDifficulty) totalResource += 2;

            activeCarts.add(new Cart(anchorPane, speed, resourceType, totalResource, mg));
            amountOfCarts += 1;
            spawnerTimer = 0;
        }
        
        if(amountOfCarts >= totalCarts){
            spawner.stop();
            spawnerTimer = 5; 
        }
    }

    /**
     * Handles taking resources from a tower
     * @param resourceType the type of resource to take
     */
    private int getResource(int resourceType){
        if(resourceType == 0){
            if(amountOfTree <= 0){
                if(amountOfRock > 0){
                    resourceType+=1;
                    amountOfRock --;
                }else if(amountOfFruit > 0){
                    resourceType+=2;
                    amountOfFruit-=1;
                }
            }else{
                amountOfTree -= 1;
            }
        }else if(resourceType == 1){
            if(amountOfRock <= 0){
                if(amountOfTree > 0){
                    amountOfTree -= 1;
                    resourceType -=1 ;
                }
                else if(amountOfFruit > 0){
                    resourceType +=1;
                    amountOfFruit -=1;
                }
            }else {
                amountOfRock -= 1;
            }
        }else{
            if(amountOfFruit <= 0){
                if(amountOfTree > 0){
                    amountOfTree -= 2;
                    resourceType -=1 ;
                }
                else if(amountOfRock > 0){
                    resourceType -= 1;
                    amountOfRock -=1;
                }
            }else{
                amountOfFruit-= 1;
            }
        }
        return resourceType;
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
                        if(rm.checkWon()){
                            GameOverManager.winScreen(anchorPane, mg);
                        }else if(!GameOverManager.isGameOver()) endRound();
                        
                        rangeCheck.stop();
                    }
                }
            }
        }
    }

    /**
    * Displays the round and shop button again while resetting active carts and adding gold.
    **/
    private void endRound(){
        startButton.setVisible(true);
        shopButton.setVisible(true);
        activeCarts = new ArrayList<>();

        if(roundDifficulty)GoldManager.increaseGoldBalance(2);
        else GoldManager.increaseGoldBalance(3);

        mg.updateGoldLabels();
        rm.incrementCurrentRound();
    }
}