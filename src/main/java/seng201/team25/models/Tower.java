package seng201.team25.models;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tower {
    private int level;
    //0 = wood, 1 = stone, 2 = fruit
    private int resourceType;
    private int resourceAmount;
    private int reloadSpeed;
    private int cost;
    private String name;

    public ImageView currentTile;
    public ImageView currentDisplay;
    private boolean directionLeft;

    private Image treeLeftDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/treeLeft.png"));
    private Image treeRightDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/treeRight.png"));
    private Image stoneLeftDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/stoneLeft.png"));
    private Image stoneRightDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/stoneRight.png"));
    private Image towerRightSprite = new Image(getClass().getResourceAsStream("/assets/mainTiles/towerSprite.png"));
    private Image towerLeftSprite = new Image(getClass().getResourceAsStream("/assets/mainTiles/towerSpriteLeft.png"));

    public Tower(int newLevel, int newResourceType, int newResourceAmount, int newReloadSpeed, int newCost, String newName, ImageView emptyTile, ImageView displayTile, boolean direction) {
        this.level = newLevel;
        this.resourceAmount = newResourceAmount;
        this.resourceType = newResourceType;
        this.reloadSpeed = newReloadSpeed;
        this.cost = newCost;
        this.name = newName;
        this.currentDisplay = displayTile;
        this.currentTile = emptyTile;
        this.directionLeft = direction;
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

    public void setResourceAmount(int amount) {
        this.resourceAmount = amount;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public int getReloadSpeed() {
        return reloadSpeed;
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

    public int getResourceType() {
        return resourceType;
    }

}