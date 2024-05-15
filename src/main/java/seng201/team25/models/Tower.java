package seng201.team25.models;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Point2D;

public class Tower {
    private int level = 1;

    //0 = wood, 1 = stone, 2 = fruit
    private int resourceType;
    private int resourceAmount = 5;
    private int reloadSpeed = 1;
    private int cost = 5;

    public ImageView currentTile;
    public ImageView currentDisplay;
    private boolean directionLeft;
    private Point2D position;

    private final Image treeLeftDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/treeLeft.png"));
    private final Image treeRightDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/treeRight.png"));
    private Image stoneLeftDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/stoneLeft.png"));
    private Image stoneRightDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/stoneRight.png"));
    private final Image towerRightSprite = new Image(getClass().getResourceAsStream("/assets/mainTiles/towerSprite.png"));
    private Image towerLeftSprite = new Image(getClass().getResourceAsStream("/assets/mainTiles/towerSpriteLeft.png"));


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

    //didn't work as intended
    // private void setTile(){
    //     if(resourceType == 1){
    //         if(directionLeft) setImageview(towerLeftSprite, treeLeftDisply);
    //         else setImageview(towerRightSprite, treeRightDisply);
    //     }
    // }

    // private void setImageview(Image tileImage, Image displayImage){
    //     currentTile.setImage(tileImage);
    //     currentDisplay.setImage(displayImage);
    // }

    public List<Image> getTileImage(){
        if(resourceType == 0){
            if(directionLeft) return List.of(towerLeftSprite, treeLeftDisply);
            else return List.of(towerRightSprite, treeRightDisply);
        }else if(resourceType == 1){
            if(directionLeft) return List.of(towerLeftSprite, stoneLeftDisply);
            else return List.of(towerRightSprite, stoneRightDisply);
        }else{
            return List.of(towerLeftSprite, treeLeftDisply);
        }
    }

    public void increaseLevel() {
        this.level ++;
    }

    public int getLevel() {
        return level;
    }

    public void increaseReloadSpeed() { this.reloadSpeed ++; }
    public int getReloadSpeed() {
        return reloadSpeed;
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