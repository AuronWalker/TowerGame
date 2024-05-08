package seng201.team25.models;

public class Tower {
    private int level;
    private String resourceType;
    private int resourceAmount;
    private int reloadSpeed;
    private int cost;
    private String name;

    public Tower(int newLevel, String newResourceType, int newResourceAmount, int newReloadSpeed, int newCost, String newName) {
        this.level = newLevel;
        this.resourceAmount = newResourceAmount;
        this.resourceType = newResourceType;
        this.reloadSpeed = newReloadSpeed;
        this.cost = newCost;
        this.name = newName;
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

    public String getResourceType() {
        return resourceType;
    }

}