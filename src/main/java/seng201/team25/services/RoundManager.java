package seng201.team25.services;

public class RoundManager {
    private static int currentRound = 0;
    private static int maxRounds = 0;

    public static void setMaxRounds(int max){
        maxRounds = max;
    }

    public static void incrementCurrentRound(){
        currentRound++;
    }

    public static int getCurrentRound(){
        return currentRound;
    }

    public static int getMaxRounds(){
        return maxRounds;
    }
}
