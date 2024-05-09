package seng201.team25.services;

import seng201.team25.models.Tower;

import java.util.ArrayList;
import java.util.List;

public class TowerManager {
    List<Tower> towers = new ArrayList<>();
    public TowerManager() {
        // dummy tower stats - replace these with more meaningful values later
        // Commented out cause change tower class and was giving me silly little errors
        // towers.addAll(List.of(
        //         new Tower(1,"Resource 1", 1, 1,10,"Tower 1"),
        //         new Tower(2,"Resource 2", 2, 2,20,"Tower 2"),
        //         new Tower(3,"Resource 3", 3, 3,30,"Tower 3"),
        //         new Tower(4,"Resource 4", 4, 4,40,"Tower 4"),
        //         new Tower(5,"Resource 5", 5, 5,50,"Tower 5"),
        //         new Tower(6,"Resource 6", 6, 6,60,"Tower 6")
        // ));
    }

    public Tower getTowerAtIndex(int index) { // try and catch? nah.
        return towers.get(index);
    }
}
