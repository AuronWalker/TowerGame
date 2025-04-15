package seng201.team25.models;
import java.util.List;
import java.util.Objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Point2D;

/**
 * Model to store statistics, image references and other details about towers.
 */
public class Tower {
    private int level = 1;

    //0 = wood, 1 = stone, 2 = fruit, 3 = vertical, 4 = horizontal
    private final int resourceType;
    private int resourceAmount = 1;
    private int reloadSpeed = 3;
    private int currentReloadSpeed = reloadSpeed;
    private int cost = 0;

    private boolean directionLeft;
    private Point2D position;

    private final Image treeLeftDisplay = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/displayTiles/treeLeft.png")));
    private final Image treeRightDisplay = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/displayTiles/treeRight.png")));
    private final Image stoneLeftDisplay = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/displayTiles/stoneLeft.png")));
    private final Image stoneRightDisplay = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/displayTiles/stoneRight.png")));
    private final Image fruitLeftDisplay = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/displayTiles/fruitLeft.png")));
    private final Image fruitRightDisplay = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/displayTiles/fruitRight.png")));
    private final Image verticalLevelRightDisplay = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/displayTiles/verticalLevelRight.png")));
    private final Image verticalLevelLeftDisplay = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/displayTiles/verticalLevelLeft.png")));
    private final Image horizontalLevelRightDisplay = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/displayTiles/horizontalLevelRight.png")));
    private final Image horizontalLevelLeftDisplay = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/displayTiles/horizontalLevelLeft.png")));

    private final Image towerRightSprite = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/mainTiles/towerSprite.png")));
    private final Image towerLeftSprite = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/mainTiles/towerSpriteLeft.png")));

    /**
     * Constructor used for starter towers with no stats.
     *
     * @param newResourceType the type of resource this tower is set to
     **/
    public Tower(int newResourceType) {
        this.resourceType = newResourceType;
    }

    /**
     * Constructor used for towers placed on the map
     *
     * @param newResourceType the type of resource this tower is set to
     * @param emptyTile       the imageview containing the sprite of the tower
     * @param direction       the boolean that determines the way the image is facing
     **/
    public Tower(int newResourceType, ImageView emptyTile, boolean direction) {
        this.resourceType = newResourceType;
        this.directionLeft = direction;
        position = new Point2D(0, emptyTile.getLayoutY());
        cost = resourceType + 1;
    }

    /**
     * Constructor used for towers listed in the shop
     *
     * @param newResourceType      the type of resource this tower is set to
     * @param newStartingResources the amount of resource it fills per reload count
     * @param newReloadSpeed       the rate at which the tower fills carts
     * @param newLevel             the starting level of the tower
     * @param newCost              the tower cost
     **/
    public Tower(int newResourceType, int newStartingResources, int newReloadSpeed, int newLevel, int newCost) {
        this.resourceType = newResourceType;
        this.resourceAmount = newStartingResources;
        this.reloadSpeed = newReloadSpeed;
        this.level = newLevel;
        this.cost = newCost;
    }

    /**
     * Returns a towers x and y position.
     *
     * @return Position of the tower
     **/
    public Point2D getPosition() {
        return position;
    }

    /**
     * Returns a List with the tower sprite and display sprite depending on resource type and direction.
     *
     * @return List of sprites
     **/
    public List<Image> getTileImage() {
        if (resourceType == 0) {
            if (directionLeft) return List.of(towerLeftSprite, treeLeftDisplay);
            else return List.of(towerRightSprite, treeRightDisplay);
        } else if (resourceType == 1) {
            if (directionLeft) return List.of(towerLeftSprite, stoneLeftDisplay);
            else return List.of(towerRightSprite, stoneRightDisplay);
        } else if (resourceType == 2) {
            if (directionLeft) return List.of(towerLeftSprite, fruitLeftDisplay);
            else return List.of(towerRightSprite, fruitRightDisplay);
        } else if (resourceType == 3) {
            if (directionLeft) return List.of(towerLeftSprite, verticalLevelLeftDisplay);
            else return List.of(towerRightSprite, verticalLevelRightDisplay);
        } else {
            if (directionLeft) return List.of(towerLeftSprite, horizontalLevelLeftDisplay);
            else return List.of(towerRightSprite, horizontalLevelRightDisplay);
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
     * Returns a tower's level.
     * @return level of the tower
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
    public void resetCurrentReloadSpeed() {
        currentReloadSpeed = reloadSpeed;
    }

    /**
     * Returns towers cost.
     * Used to get sell value
     *
     * @return sell price
     **/
    public int getCost() {
        return cost;
    }

    /**
     * Returns how much the tower will fill the cart per increment.
     * Used so the cart knows how much to fill up by.
     *
     * @return number of resources
     **/
    public int getResourceAmount() {
        return resourceAmount;
    }

    /**
     * Returns what resource a tower provides
     *
     * @return integer representation of resource type
     **/
    public int getResourceType() {
        return resourceType;
    }

}