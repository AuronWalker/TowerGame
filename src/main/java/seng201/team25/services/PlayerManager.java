package seng201.team25.services;

/**
 * Static method to store the player name, difficulty and number of rounds
 * as set by the player during setup.
 */
public class PlayerManager {
    private static String playerName;
    private static int difficulty;
    private static int rounds;

    /**
     * Stores the values provided by the player in the static variables of the class.
     * @param name The name of the player
     * @param requestedDifficulty The difficulty requested by the player, from 0 through 2
     * @param requestedRounds The number of rounds requested by the player, from 5 through 15
     */
    public static void storeValues(String name, int requestedDifficulty, int requestedRounds) {
        playerName = name;
        difficulty = requestedDifficulty;
        rounds = requestedRounds;
        System.out.printf("%s, %d, %d", getPlayerName(), getDifficulty(), getRounds());
    }

    /**
     * Returns the name of the player, as entered in the setup screen.
     * @return player name
     */
    public static String getPlayerName() {
        return playerName;
    }

    /**
     * Returns the requested difficulty, as entered in the setup screen.
     * @return integer representation of difficulty
     */
    public static int getDifficulty() {
        return difficulty;
    }

    /**
     * Returns the requested number of rounds, as entered in the setup screen.
     * @return number of rounds.
     */
    public static int getRounds() {
        return rounds;
    }
}
