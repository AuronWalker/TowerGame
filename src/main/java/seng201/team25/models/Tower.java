package seng201.team25.models;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Point2D;

/**
 * Model to store statistics and other details about towers.
 */
public class Tower {
    private int level = 1;

    //0 = wood, 1 = stone, 2 = fruit, 3 = vertical, 4 = horizontal
    private int resourceType;
    private int resourceAmount = 1;
    private int reloadSpeed = 3;
    private int currentReloadSpeed = reloadSpeed;
    private int cost = 0;

    public ImageView currentTile;
    public ImageView currentDisplay;
    private boolean directionLeft;
    private Point2D position;

    private final Image treeLeftDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/treeLeft.png"));
    private final Image treeRightDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/treeRight.png"));
    private final Image stoneLeftDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/stoneLeft.png"));
    private final Image stoneRightDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/stoneRight.png"));
    private final Image fruitLeftDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/fruitLeft.png"));
    private final Image fruitRightDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/fruitRight.png"));
    private final Image verticalLevelRightDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/verticalLevelRight.png"));
    private final Image verticalLevelLeftDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/verticalLevelLeft.png"));
    private final Image horizontalLevelRightDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/horizontalLevelRight.png"));
    private final Image horizontalLevelLeftDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/horizontalLevelLeft.png"));

    private final Image towerRightSprite = new Image(getClass().getResourceAsStream("/assets/mainTiles/towerSprite.png"));
    private final Image towerLeftSprite = new Image(getClass().getResourceAsStream("/assets/mainTiles/towerSpriteLeft.png"));

    /**
    * Constructor used for starter towers with no stats.
    * @param newResourceType the type of resource this tower is set to
    **/
    public Tower(int newResourceType) {
        this.resourceType = newResourceType;
    }

    /**
    * Constructor used for towers placed on the map
    * @param newResourceType the type of resource this tower is set to
    * @param emptyTile the imageview containing the sprite of the tower
    * @param displayTile the imageview displaying the resource of the tower
    * @param direction the boolean that determines the way the image is facing
    **/
    public Tower(int newResourceType, ImageView emptyTile, ImageView displayTile, boolean direction) {
        this.resourceType = newResourceType;
        this.currentDisplay = displayTile;
        this.currentTile = emptyTile;
        this.directionLeft = direction;
        position = new Point2D(0, emptyTile.getLayoutY());
        setCost();
    }

    /**
    * Constructor used for towers listed in the shop
    * @param newResourceType the type of resource this tower is set to
    * @param newStartingResources the amount of resource it fills per reload count
    * @param newReloadSpeed the rate at which the tower fills carts
    * @param newLevel the starting level of the tower
    * @param newCost the tower cost
    **/
    public Tower(int newResourceType, int newStartingResources, int newReloadSpeed, int newLevel, int newCost) {
        this.resourceType = newResourceType;
        this.resourceAmount = newStartingResources;
        this.reloadSpeed = newReloadSpeed;
        this.level = newLevel;
        this.cost = newCost;
    }

    /**
    * Sets cost of tower depending on the resource.
    * Each resource is more expensive as they appear in harder difficulties
    **/
    private void setCost(){
        if(resourceType == 0) cost = 1;
        else if(resourceType == 1) cost = 2;
        else if(resourceType == 2) cost = 3;
        else if(resourceType == 3) cost = 4;
        else if(resourceType == 4) cost = 5;
    }

    /**
    * Returns a towers x and y position.
     * @return Position of the tower
    **/
    public Point2D getPosition(){
        return position;
    }

    /**
    * Returns a List with the tower sprite and display sprite depending on resource type and direction.
     * @return List of sprites
    **/
    public List<Image> getTileImage(){
        if(resourceType == 0){
            if(directionLeft) return List.of(towerLeftSprite, treeLeftDisply);
            else return List.of(towerRightSprite, treeRightDisply);
        }else if(resourceType == 1){
            if(directionLeft) return List.of(towerLeftSprite, stoneLeftDisply);
            else return List.of(towerRightSprite, stoneRightDisply);
        }else if(resourceType == 2){
            if(directionLeft) return List.of(towerLeftSprite, fruitLeftDisply);
            else return List.of(towerRightSprite, fruitRightDisply);
        }else if(resourceType == 3){
            if(directionLeft) return List.of(towerLeftSprite, verticalLevelLeftDisply);
            else return List.of(towerRightSprite, verticalLevelRightDisply);
        }else{
            if(directionLeft) return List.of(towerLeftSprite, horizontalLevelLeftDisply);
            else return List.of(towerRightSprite, horizontalLevelRightDisply);
        }
    }

    /**
    * Makes reload time quicker and increases level, the amount of resources filled per reload cycle.
    **/
    public void increaseLevel() {
        this.level++;
        this.reloadSpeed--;
        this.resourceAmount++;
    }

    /**
    * Makes reload time slower and decrease level, the amount of resources filled per reload cycle.
    **/
    public void decreaseLevel() {
        this.level--;
        this.reloadSpeed++;
        this.resourceAmount--;
    }

    /**
    * Returns a tower's level.
     * @ return level of the tower
    **/
    public int getLevel() {
        return level;
    }

    /**
     * Returns a tower's base reload speed.
     * @return reload speed
    **/
    public int getReloadSpeed() {
        return reloadSpeed;
    }

    /**
     * Returns a tower's current reload speed.
     * @return reload speed
    **/
    public int getCurrentReloadSpeed() {
        return currentReloadSpeed;
    }

    /**
    * Decrements current reload speed by one.
    **/
    public void lowerCurrentReloadSpeed() {
        currentReloadSpeed -= 1;
    }

    /**
    * Resets current speed back to the base reload speed.
    **/
    public void resetCurrentReloadSpeed(){
        currentReloadSpeed = reloadSpeed;
    }

    /**
    * Returns towers cost
    * Used to get sell value
    **/
    public int getCost() {
        return cost;
    }

    /**
    * Returns how much the tower will fill the cart per increment.
    * Used so the cart knows how much to fill up by.
    **/
    public int getResourceAmount() {
        return resourceAmount;
    }

    /**
    * Returns what resource a tower provides
     * @return integer representation of resource type
    **/
    public int getResourceType() {
        return resourceType;
    }
}