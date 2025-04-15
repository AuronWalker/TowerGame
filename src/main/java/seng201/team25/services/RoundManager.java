package seng201.team25.services;

import java.util.List;
import java.util.Random;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import seng201.team25.gui.MainGameController;
import seng201.team25.models.Round;
import seng201.team25.models.Tower;

/**
 * Manages game rounds and checks for win / loss conditions.
 */
public class RoundManager {
    private int currentRound = 0;
    private final int maxRounds;
    private final Label roundLabel;

    /**
    * Sets the RoundManager with the players maxRound picked from setup screen.
    * Additionally, gets the label that will display round info.
    * @param newRoundLabel label that sets the label.
    **/
    public RoundManager(Label newRoundLabel){
        maxRounds = PlayerManager.getRounds();
        roundLabel = newRoundLabel;
    }

    /**
    * Adds one to current round and updates the label to display it.
    **/
    public void incrementCurrentRound(){
        currentRound++;
        roundLabel.setText(currentRound + "/" + maxRounds);
    }

    /**
    * Returns current round.
     * @return number of round
    **/
    public int getCurrentRound(){
        return currentRound;
    }

    /**
    * Returns the players set max number of rounds.
     * @return max number of rounds
    **/
    public int getMaxRounds(){
        return maxRounds;
    }

    /**
     * Checks if the game has been won.
     * @return win state
     */
    public boolean checkWon(){
        return currentRound == maxRounds;
    }

    /**
     * Displays buttons to allow the user to select an easy or hard round at the beginning of each round
     * @param roundButton button element
     * @param easy whether the overall gamemode is set to easy
     * @param activeTowers list of active towers
     * @param anchorPane anchor pane to display buttons
     * @param startButton button element to start the game
     * @param shopButton button element to switch to the shop
     * @param mainGameController global mainGameController
     * @param roundManager global roundManager
     */
    public void displayRoundButton(Button roundButton, boolean easy, List<Tower> activeTowers, AnchorPane anchorPane, Button startButton, Button shopButton, MainGameController mainGameController, RoundManager roundManager){
        roundButton.setVisible(true);

        String difficultyString;
        int baseAmount;
        if(easy) {
            difficultyString = "Easy!";
            baseAmount = 1;
        }
        else {
            difficultyString = "Hard!";
            baseAmount = 2;
        }

        //Starts Round
        Random rng = new Random();
        int treeAmount = 0;
        int rockAmount = 0;
        int fruitAmount = 0;


        if(roundManager.getCurrentRound() == 0){
            treeAmount = rng.nextInt(2) + baseAmount;
        } else if(roundManager.getCurrentRound() == 1){
            treeAmount = rng.nextInt(3) + baseAmount;
            rockAmount = rng.nextInt(2) + baseAmount;
        }else if(roundManager.getCurrentRound() >= 2){
            treeAmount = rng.nextInt(4) + baseAmount;
            rockAmount = rng.nextInt(3) + baseAmount;
            fruitAmount = rng.nextInt(2) + baseAmount;
        }

        //variables need to be final for button action
        final int finalTreeAmount = treeAmount;
        final int finalRockAmount = rockAmount;
        final int finalFruitAmount = fruitAmount;
        
        roundButton.setText(difficultyString + " Trees: " + treeAmount + " Rocks: " + rockAmount + " Fruit: " + fruitAmount);

        roundButton.setOnAction(event -> {
            new Round(easy, finalTreeAmount, finalRockAmount, finalFruitAmount, activeTowers, anchorPane, startButton, shopButton, mainGameController, roundManager);
            mainGameController.hideRoundInfo();
        });
    }
}
