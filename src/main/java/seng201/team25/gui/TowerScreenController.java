package seng201.team25.gui;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import seng201.team25.models.Tower;
import seng201.team25.services.AvailableTowerManager;
import seng201.team25.services.GoldManager;
import seng201.team25.services.WindowManager;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Controls the initial tower loadout selection screen.
 */

public class TowerScreenController {
    final WindowManager windowManager;
    @FXML ImageView imgTower0;
    @FXML ImageView imgTowerSelected;
    @FXML Label lblTowerName;

    @FXML ImageView imgLoadedTower0;
    @FXML ImageView imgLoadedTower1;
    @FXML ImageView imgLoadedTower2;

    @FXML Label lblLoadedTower0;
    @FXML Label lblLoadedTower1;
    @FXML Label lblLoadedTower2;

    @FXML Label lblStartGame;
    @FXML Label lblResources;
    @FXML Label lblReloadSpeed;


    private final Tower[] towersToBuy = AvailableTowerManager.getTowersToBuy();

    private ImageView selectedTowerElement;
    private int selectedTowerResourceID;

    private final List<ImageView> loadedTowerImages = new ArrayList<>();
    private final List<Label> loadedTowerLabels = new ArrayList<>();
    Image referenceTowerImage;

    /**
     * FXML: Initialize the object, called by JavaFX on UI load
     */
    public void initialize() {
        selectedTowerElement = imgTower0;
        selectedTowerResourceID = Integer.parseInt(imgTower0.getId().substring(imgTower0.getId().length() - 1));
        loadedTowerImages.addAll(List.of(imgLoadedTower0, imgLoadedTower1, imgLoadedTower2));
        loadedTowerLabels.addAll(List.of(lblLoadedTower0, lblLoadedTower1, lblLoadedTower2));

        referenceTowerImage = imgLoadedTower0.getImage();
        AvailableTowerManager.clearAvailableTowers();
    }


    /**
     * Constructor to set the private windowManager when TowerScreen is created
     * @param windowManager FXWindow controller object
     */
    public TowerScreenController(WindowManager windowManager) {
        this.windowManager = windowManager;
    }

    /**
     * FXML: Proceeds to the next screen when continue button pressed
     */
    public void continuePressed() {
        if ( AvailableTowerManager.getNextAvailableIndex() == -1 ) {
            windowManager.toGameScreen();
            GoldManager.setGold(0);
        }
    }

    /**
     * FXML: Returns to previous screen when back button pressed
     */
    public void backPressed() {
        windowManager.toSetupScreen();
    }

    /**
     * FXML: Updates the preview information when a new tower is selected
     * @param event event identifier
     */
    public void towerSelected(Event event) {
        // Get the object ID of the selected tower, stop here if selected tower unchanged
        ImageView pressedTower = (ImageView) event.getSource();
        if ( pressedTower == selectedTowerElement ) { return; }

        // Get Resource ID then Resource String from selected tower, set this on-screen
        this.selectedTowerResourceID = Integer.parseInt(pressedTower.getId().substring(pressedTower.getId().length() - 1));
        String resourceString = AvailableTowerManager.getResourceTypeString(selectedTowerResourceID);
        lblTowerName.setText(resourceString);

        // Set the opacity to 1 to show tower is selected, update the image, deselect the last tower
        pressedTower.setOpacity(1);
        imgTowerSelected.setImage(pressedTower.getImage());
        selectedTowerElement.setOpacity(0.4);
        selectedTowerElement = pressedTower;

        // Get statistics for the selected tower
        int selectedTowerResourceID = Integer.parseInt(pressedTower.getId().substring(pressedTower.getId().length() - 1));
        Tower selectedTower = Arrays.stream(towersToBuy)
                .filter(tower -> (tower.getResourceType() == selectedTowerResourceID))
                .findFirst()
                .orElse(null);

        // Write the statistics for the selected tower to the tower preview section of the UI
        lblTowerName.setText(resourceString);
        assert selectedTower != null;
        if ( selectedTower.getReloadSpeed() < 0 ) {
            lblResources.setText("N/A");
            lblReloadSpeed.setText("x" + -1 * selectedTower.getReloadSpeed());
        } else {
            lblResources.setText(String.valueOf(selectedTower.getResourceAmount()));
            lblReloadSpeed.setText(String.valueOf(selectedTower.getReloadSpeed()));
        }
    }

    /**
     * FXML: Add selected tower to loadout when "Add" button pressed
     */
    public void addSelectedToLoadout() {
        int nextIndex = AvailableTowerManager.getNextAvailableIndex();
        if (nextIndex != -1) {
            AvailableTowerManager.addAvailableTower(new Tower(selectedTowerResourceID));
            loadedTowerImages.get(nextIndex).setImage(imgTowerSelected.getImage());
            loadedTowerImages.get(nextIndex).setOpacity(1);
            String resourceString = AvailableTowerManager.getResourceTypeString(selectedTowerResourceID);
            loadedTowerLabels.get(nextIndex).setText(resourceString);

            // Enable the continue button if inventory full
            if (AvailableTowerManager.getNextAvailableIndex() == -1) lblStartGame.setOpacity(1);
        }
    }

    /**
     * FXML: Reset the loadout when "Reset" button pressed
     */
    public void resetLoadout() {
        lblStartGame.setOpacity(0.4);
        AvailableTowerManager.clearAvailableTowers();
        for (ImageView towerImage : loadedTowerImages) {
            towerImage.setImage(referenceTowerImage);
            towerImage.setOpacity(0.4);
        }
        for (Label towerLabel : loadedTowerLabels) {
            towerLabel.setText("Not Selected");
        }

    }
}
