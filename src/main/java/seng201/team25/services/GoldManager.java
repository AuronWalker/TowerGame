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

    public static int increaseGoldBalance(int goldToAdd) {
        gold += goldToAdd;
        return gold;
    }

    public static int decreaseGoldBalance(int goldToTake) {
        if (goldToTake > gold) {
            return -1;
        }
        gold -= goldToTake;
        return gold;
    }
}
