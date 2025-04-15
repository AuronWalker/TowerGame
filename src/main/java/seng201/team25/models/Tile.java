package seng201.team25.models;
import seng201.team25.services.GoldManager;

/**
 * Stores information about tiles placed on the board.
 */
public class Tile {
    private Tower tileTower = null;

    /**
    * Sets the tower on tile null until it is set here.
    * @param newTower the tower on the tile.
    **/
    public void setTower(Tower newTower){
        tileTower = newTower;
    }

    /**
    * Sells tower on tile for the amount of money the tower costs.
    **/
    public void sellTower(){
        GoldManager.increaseGoldBalance(tileTower.getCost() - 1);
        tileTower = null;
    }

    /**
    * Used to know if there is a tower on the tile or not.
    * Returns false if there is no tower and true if there is.
     * @return boolean representation of whether the tile is empty
    **/
    public boolean hasTower(){
        return tileTower != null;
    }

    /**
     * Returns the tower element on this tile
     * @return Tower element
    **/
    public Tower getTower(){
        return tileTower;
    }
}
