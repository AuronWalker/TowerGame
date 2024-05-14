package seng201.team25.services;

public class PlayerManager {
    static String playerName;
    static int difficulty;
    static int rounds;
    public void storeValues(String name, int requestedDifficulty, int requestedRounds) {
        playerName = name;
        difficulty = requestedDifficulty;
        rounds = requestedRounds;
        System.out.printf("%s, %d, %d", getPlayerName(), getDifficulty(), getRounds());
    }

    public static String getPlayerName() {
        return playerName;
    }
    public static int getDifficulty() {
        return difficulty;
    }
    public static int getRounds() {
        return rounds;
    }
}
