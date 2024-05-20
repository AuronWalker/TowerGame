package seng201.team25.services;

import javafx.scene.control.Label;

public class RoundManager {
    private int currentRound = 0;
    private int maxRounds = 0;
    private Label roundLabel;
    private int difficulty = PlayerManager.getDifficulty();

    /**
    * Sets the RoundManager with the players maxRound picked from setup screen.
    * Additonally gets the label that will display round info.
    * @param newRoundLabel label that sets the label.
    * @param max int to set maxRounds to.
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
    **/
    public int getCurrentRound(){
        return currentRound;
    }

    /**
    * Returns the players set max number of rounds.
    **/
    public int getMaxRounds(){
        return maxRounds;
    }

    /**
    * sets currentRound back to 0.
    **/
    public void resetCurrentRound(){
        currentRound = 0;
    }
}
