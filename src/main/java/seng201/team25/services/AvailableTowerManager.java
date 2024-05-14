package seng201.team25.services;

import seng201.team25.models.Tower;

import java.util.ArrayList;
import java.util.List;

// Static method to hold all available towers for placement, either from the start screen
// or from the shop. Call getAvailableTowers(int Type) to get the # of a tower of a certain
// type available.

public class AvailableTowerManager {
    private static List<Tower> towers = new ArrayList<>();
    private static final String[] resourceTypeMap = {"Wood", "Stone", "Fruit", "Vertical Upgrade", "Horizontal Upgrade"};

    // Towers available in the shop
    private static final Tower[] towersToBuy = {
            new Tower(0, 1, 2,1,1),
            new Tower(1, 1, 1, 1, 2),
            new Tower(2, 1, 1, 1, 3),
            new Tower(3, 1, 1, 1, 4),
            new Tower(4, 0, -1, -1, 5),
            new Tower(5, 0, -1, -1, 6)};


    public static Tower[] getTowersToBuy() {
            return towersToBuy;
    }

    public static void addAvailableTower(Tower tower) {
        towers.add(tower);
    }
    public static void clearAvailableTowers() {towers.clear();}

    public static int getNextAvailableIndex() {
        if (towers.size() == 3) { return -1;}
        return towers.size();
    }


    public boolean removeTowerOfType(int towerType) {
        for (Tower tower : towers) {
            if (tower.getResourceType() == towerType) {
                towers.remove(tower);
                return true;
            }
        }
        return false;
    }

    public int getTowersOfType(int towerType) {
        int towersOfType = 0;
        for (Tower tower : towers) {
            if (tower.getResourceType() == towerType) {
                towersOfType ++;
            }
        }
        return towersOfType;
    }

    public static String getResourceTypeString(int intId) {
        return resourceTypeMap[intId];
    }

}
