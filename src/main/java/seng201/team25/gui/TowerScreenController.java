package seng201.team25.gui;

import javafx.scene.control.Label;
import seng201.team25.services.AvailableTowerManager;
import seng201.team25.services.MenuManager;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class TowerScreenController {
    MenuManager menuManager;

    @FXML
    ImageView imgTower0;
    @FXML
    ImageView imgTowerSelected;
    @FXML
    Label lblTowerName;
    ImageView selectedTower;


    AvailableTowerManager towerManager = new AvailableTowerManager();

    public void initialize() {
        selectedTower = imgTower0;

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

        // Get Resource ID then Resource String from selected tower
        int selectedResourceId = Integer.parseInt(pressedTower.getId().substring(pressedTower.getId().length() - 1));
        String resourceString = towerManager.getResourceTypeString(selectedResourceId);
        lblTowerName.setText(String.format("%s Tower", resourceString));

        pressedTower.setOpacity(1);

        selectedTower.setOpacity(0.4);
        selectedTower = pressedTower;

        imgTowerSelected.setImage(selectedTower.getImage());
    }

    public void addSelectedToLoadout() {

    }

}
