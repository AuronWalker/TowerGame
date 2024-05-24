package seng201.team25.services;

import seng201.team25.models.Tower;

import java.util.ArrayList;
import java.util.List;

/**
 * Static class to hold all available towers for placement, either from the
 * start screen or from the shop.
 */
public class AvailableTowerManager {
    private static final List<Tower> towers = new ArrayList<>();
    private static final String[] resourceTypeMap = {"Wood", "Stone", "Fruit", "Upgrade 1", "Upgrade 2"};

    /**
     * List of available towers to buy.
     */
    private static final Tower[] towersToBuy = {
            new Tower(0, 1, 2,1,1),
            new Tower(1, 1, 1, 1, 2),
            new Tower(2, 1, 1, 1, 3),
            new Tower(3, 0, -2, 1, 4),
            new Tower(4, 0, -2, 1, 5)};

    /**
     * Returns a list of towers available to purchase.
     * @return array of Towers
     */
    public static Tower[] getTowersToBuy() {
            return towersToBuy;
    }

    /**
     * Returns the number of towers in the inventory.
     * @return number of towers
     */
    public static int numberOfTowers() {
        return towers.size();
    }


    /**
     * Adds a Tower to the available towers for placement.
     * @param tower Tower element to add
     */
    public static void addAvailableTower(Tower tower) {
        towers.add(tower);
    }

    /**
     * Clears the list of available towers
     */
    public static void clearAvailableTowers() {towers.clear();}

    /**
     * Gets the next available empty slot in the setup screen loadout.
     * @return index of next available slot
     */
    public static int getNextAvailableIndex() {
        if (towers.size() == 3) { return -1;}
        return towers.size();
    }

    /**
     * Removes a tower with a specified resource type from the list of available towers.
     * Returns true if tower removed, false if no tower of specified type available.
     *
     * @param towerType Type of resource type to search for
     * @return Whether a tower was removed
     */
    public static boolean removeTowerOfType(int towerType) {
        for (Tower tower : towers) {
            if (tower.getResourceType() == towerType) {
                towers.remove(tower);
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the number of towers of a specified resource type available for placement.
     * @param towerType Resource type to search for
     * @return Number of towers of specified type available for placement
     */
    public static int numberOfTowers(int towerType) {
        int towersOfType = 0;
        for (Tower tower : towers) {
            if (tower.getResourceType() == towerType) {
                towersOfType +=1;
            }
        }
        return towersOfType;
    }

    /**
     * Gets the string associated with an integer resource type code
     * @param intId Integer representation of resource
     * @return String representation of resource
     */
    public static String getResourceTypeString(int intId) {
        return resourceTypeMap[intId];
    }

}
