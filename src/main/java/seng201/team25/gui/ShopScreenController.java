package seng201.team25.gui;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import seng201.team25.models.Tower;
import seng201.team25.services.AvailableTowerManager;
import seng201.team25.services.GoldManager;
import seng201.team25.services.WindowManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShopScreenController {
    WindowManager windowManager;
    @FXML
    ImageView imgTower0;
    @FXML
    ImageView imgTowerSelected;
    @FXML
    Label lblTowerName;

    @FXML
    Label txtStatus;
    @FXML
    Label lblBalance;
    @FXML
    Label lblResources;
    @FXML
    Label lblReloadSpeed;
    @FXML
    Label lblLevel;
    @FXML
    Label lblCost;

    private int recurrentPurchaseCounter = 1;


    // Tower data
    private final Tower[] towersToBuy = AvailableTowerManager.getTowersToBuy();
    private Tower selectedTower = towersToBuy[0];
    private ImageView selectedTowerElement;


    public void initialize() {
        GoldManager.setGold(100);
        lblBalance.setText(String.valueOf(GoldManager.getGoldBalance()));
        selectedTowerElement = imgTower0;

    }

    public ShopScreenController(WindowManager windowManager) {
        this.windowManager = windowManager;
    }

    public void continuePressed() {
        windowManager.toGameScreen();
    }
    public void backPressed() {
        windowManager.toSetupScreen();
    }

    public void towerSelected(Event event) {
        txtStatus.setVisible(false);
        ImageView pressedTower = (ImageView) event.getSource();
        if ( pressedTower == selectedTowerElement ) { return; }

        // Get Resource ID, Tower model and resource string for selected tower
        int selectedTowerResourceID = Integer.parseInt(pressedTower.getId().substring(pressedTower.getId().length() - 1));
        selectedTower = Arrays.stream(towersToBuy)
                .filter(tower -> (tower.getResourceType() == selectedTowerResourceID))
                .findFirst()
                .orElse(null);

        String resourceString = AvailableTowerManager.getResourceTypeString(selectedTowerResourceID);
        lblTowerName.setText(String.format("%s Tower", resourceString));

        pressedTower.setOpacity(1);

        selectedTowerElement.setOpacity(0.4);
        selectedTowerElement = pressedTower;

        imgTowerSelected.setImage(selectedTowerElement.getImage());
        lblResources.setText(String.valueOf(selectedTower.getResourceAmount()));
        lblReloadSpeed.setText(String.valueOf(selectedTower.getReloadSpeed()));
        lblLevel.setText(String.valueOf(selectedTower.getLevel()));
        lblCost.setText(String.valueOf(selectedTower.getCost()));

    }

    public void buySelectedTower() {

        int newGoldBalance = GoldManager.decreaseGoldBalance(selectedTower.getCost());
        if (newGoldBalance == -1) {
            txtStatus.setText("Insufficient Gold!");
            txtStatus.setVisible(true);
        } else {
            lblBalance.setText(String.valueOf(GoldManager.getGoldBalance()));
            String resourceString = AvailableTowerManager.getResourceTypeString(selectedTower.getResourceType());
            if ( txtStatus.isVisible() ) {
                recurrentPurchaseCounter += 1;
                txtStatus.setText(String.format("Purchased %d %s towers!", recurrentPurchaseCounter, resourceString));
            } else {
                recurrentPurchaseCounter = 1;
                txtStatus.setText(String.format("Purchased 1 %s tower!", resourceString));
            }

            txtStatus.setVisible(true);
            AvailableTowerManager.addAvailableTower(new Tower(selectedTower.getResourceType()));
        }
    }

}
