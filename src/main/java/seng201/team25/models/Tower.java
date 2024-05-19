package seng201.team25.models;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Point2D;

public class Tower {
    private int level = 1;

    //0 = wood, 1 = stone, 2 = fruit, 3 = vertical, 4 = horizontal
    private int resourceType;
    private int resourceAmount = 1;
    private int reloadSpeed = 4;
    private int currentReloadSpeed = reloadSpeed;
    private int cost = 5;

    public ImageView currentTile;
    public ImageView currentDisplay;
    private boolean directionLeft;
    private Point2D position;
    private String name ="";

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


    // Constructor used for starter towers with no stats
    public Tower(int newResourceType) {
        this.resourceType = newResourceType;
    }

    // Constructor used for towers placed on the map
    public Tower(int newResourceType, ImageView emptyTile, ImageView displayTile, boolean direction) {
        this.resourceType = newResourceType;
        this.currentDisplay = displayTile;
        this.currentTile = emptyTile;
        this.directionLeft = direction;
        position = new Point2D(0, emptyTile.getLayoutY());
        System.out.println(position);
    }

    // Constructor used for towers listed in the shop
    public Tower(int newResourceType, int newStartingResources, int newReloadSpeed, int newLevel, int newCost) {
        this.resourceType = newResourceType;
        this.resourceAmount = newStartingResources;
        this.reloadSpeed = newReloadSpeed;
        this.level = newLevel;
        this.cost = newCost;
    }

    public Point2D getPosition(){
        return position;
    }

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

    public void increaseLevel() {
        this.level++;
        this.reloadSpeed++;
        this.resourceAmount++;
    }

    public void decreaseLevel() {
        this.level--;
        this.reloadSpeed--;
        this.resourceAmount--;
    }

    public int getLevel() {
        return level;
    }

    public void increaseReloadSpeed() { this.reloadSpeed ++; }
    public int getReloadSpeed() {
        return reloadSpeed;
    }

    public int getCurrentReloadSpeed() {
        System.out.println(currentReloadSpeed);
        return currentReloadSpeed;
        
    }

    public void lowerCurrentReloadSpeed() {
        currentReloadSpeed -= 1;
    }

    public void resetCurrentReloadSpeed(){
        currentReloadSpeed = reloadSpeed;
    }

    public String getName() {
        return name;
    }

   public int getCost() {
        return cost;
    }
    public int getResourceAmount() {
        return resourceAmount;
    }
    public void setResourceAmount(int amount) {
        this.resourceAmount = amount;
    }

    public int getResourceType() {
        return resourceType;
    }
}