package seng201.team25.services;

/**
 * Class to manage a static gold balance between controllers
 */

public class GoldManager {
    private static int gold;

    public static void setGold(int goldValue) {
        gold = goldValue;
    }

    public static int getGoldBalance() {
        return gold;
    }

    public static void increaseGoldBalance(int goldToAdd) {
        gold += goldToAdd;
    }

    public static void decreaseGoldBalance(int goldToTake) {
        gold -= goldToTake;
    }
}
