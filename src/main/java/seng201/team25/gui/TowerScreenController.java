package seng201.team25.gui;

import seng201.team25.services.MenuManager;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class TowerScreenController {
    MenuManager menuManager;

    @FXML
    ImageView imgTower1;
    @FXML
    ImageView imgTowerSelected;
    ImageView selectedTower;

    public void initialize() {
        selectedTower = imgTower1;
    }


    public TowerScreenController(MenuManager menuManager) {
        this.menuManager = menuManager;
    }

    public void continuePressed() {
        menuManager.toTowerScreen();
    }
    public void backPressed() {
        menuManager.toSetupScreen();
    }

    public void towerSelected(Event event) {
        ImageView pressedTower = (ImageView) event.getSource();
        if ( pressedTower == selectedTower ) { return; }
        pressedTower.setOpacity(1);

        selectedTower.setOpacity(0.4);
        selectedTower = pressedTower;

        imgTowerSelected.setImage(selectedTower.getImage());
    }

    public void addSelectedToLoadout() {

    }

}
