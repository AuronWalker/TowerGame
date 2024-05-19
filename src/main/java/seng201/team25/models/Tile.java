package seng201.team25.models;

import javafx.scene.image.ImageView;

public class Tile {
    private ImageView tile;
    private int resource;
    private Tower tileTower = null;

    public Tile(ImageView _tile, int _resource){
        tile = _tile;
        resource = _resource;
    }

    public int getResource(){
        return resource;
    }

    public void setTower(Tower newTower){
        tileTower = newTower;
    }

    public boolean hasTower(){
        if(tileTower == null) return false;
        else return true;
    }

    public Tower getTower(){
        return tileTower;
    }
}
