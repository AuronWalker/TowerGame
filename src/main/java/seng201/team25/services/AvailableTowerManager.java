package seng201.team25.services;

import seng201.team25.models.Tower;

import java.util.ArrayList;
import java.util.List;

// Static method to hold all available towers for placement, either from the start screen
// or from the shop. Call getAvailableTowers(int Type) to get the # of a tower of a certain
// type available.

public class AvailableTowerManager {
    private static List<Tower> towers = new ArrayList<>();
    private final String[] resourceTypeMap = {"Wood", "Stone", "Fruit", "Vertical Upgrade", "Horizontal Upgrade"};

    public void addAvailableTower(Tower tower) {
        towers.add(tower);
    }

    public int getNextAvailableIndex() {
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

    public String getResourceTypeString(int intId) {
        return resourceTypeMap[intId];
    }

}
