package seng201.team25.gui;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import seng201.team25.models.Tower;
import seng201.team25.services.AvailableTowerManager;
import seng201.team25.services.MenuManager;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TowerScreenController {
    MenuManager menuManager;

    @FXML
    ImageView imgTower0;
    @FXML
    ImageView imgTowerSelected;
    @FXML
    Label lblTowerName;

    @FXML
    ImageView imgSelectedTower0;
    @FXML
    ImageView imgSelectedTower1;
    @FXML
    ImageView imgSelectedTower2;

    @FXML
    Label lblSelectedTower0;
    @FXML
    Label lblSelectedTower1;
    @FXML
    Label lblSelectedTower2;


    private ImageView selectedTowerElement;
    private int selectedTowerResourceID;

    private List<ImageView> selectedTowerImages = new ArrayList<>();
    private List<Label> selectedTowerLabels = new ArrayList<>();



    AvailableTowerManager towerManager = new AvailableTowerManager();

    public void initialize() {
        selectedTowerElement = imgTower0;
        selectedTowerResourceID = Integer.parseInt(imgTower0.getId().substring(imgTower0.getId().length() - 1));
        selectedTowerImages.addAll(List.of(imgSelectedTower0, imgSelectedTower1, imgSelectedTower2));
        selectedTowerLabels.addAll(List.of(lblSelectedTower0, lblSelectedTower1, lblSelectedTower2));
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
        if ( pressedTower == selectedTowerElement ) { return; }

        // Get Resource ID then Resource String from selected tower
        this.selectedTowerResourceID = Integer.parseInt(pressedTower.getId().substring(pressedTower.getId().length() - 1));
        String resourceString = towerManager.getResourceTypeString(selectedTowerResourceID);
        lblTowerName.setText(String.format("%s Tower", resourceString));

        pressedTower.setOpacity(1);

        selectedTowerElement.setOpacity(0.4);
        selectedTowerElement = pressedTower;

        imgTowerSelected.setImage(selectedTowerElement.getImage());
    }

    public void addSelectedToLoadout() {
        int nextIndex = towerManager.getNextAvailableIndex();
        if (nextIndex != -1) {
            towerManager.addAvailableTower(new Tower(selectedTowerResourceID));
            selectedTowerImages.get(nextIndex).setImage(imgTowerSelected.getImage());
            selectedTowerImages.get(nextIndex).setOpacity(1);
            String resourceString = towerManager.getResourceTypeString(selectedTowerResourceID);
            selectedTowerLabels.get(nextIndex).setText(String.format("%s Tower", resourceString));

        }
    }
    public void removeSelectedFromLoadout() {


    }

}
