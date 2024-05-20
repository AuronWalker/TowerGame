package seng201.team25.services;

import javafx.scene.control.Label;

public class RoundManager {
    private int currentRound = 0;
    private int maxRounds = 0;
    private Label roundLabel;
    private int difficulty = PlayerManager.getDifficulty();

    public void setMaxRounds(int max){
        maxRounds = max;
    }

    public void setRoundLabel(Label newRoundLabel){
        roundLabel = newRoundLabel;
    }

    public void incrementCurrentRound(){
        currentRound++;
        roundLabel.setText(currentRound + "/" + maxRounds);
    }

    public int getCurrentRound(){
        return currentRound;
    }

    public int getMaxRounds(){
        return maxRounds;
    }

    public void resetCurrentRound(){
        currentRound = 0;
    }
}
