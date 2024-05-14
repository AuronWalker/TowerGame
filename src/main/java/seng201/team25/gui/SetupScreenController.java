package seng201.team25.gui;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import seng201.team25.services.PlayerManager;
import seng201.team25.services.WindowManager;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class SetupScreenController {
    WindowManager windowManager;
    PlayerManager playerManager = new PlayerManager();

    @FXML
    private Label lblEasy;
    @FXML
    private Label lblNormal;
    @FXML
    private Label lblHard;
    @FXML
    private TextField txtName;
    @FXML
    private Slider sldRounds;
    @FXML
    private Label lblSliderPosition;
    private Label selectedDifficulty;

    private List<Label> difficultyLabels = new ArrayList<>();

    public SetupScreenController(WindowManager windowManager) {
        this.windowManager = windowManager;
    }

    public void initialize() {
        this.selectedDifficulty = lblEasy;
        difficultyLabels.addAll(List.of(lblEasy, lblNormal, lblHard));
    }

    public void difficultyPressed(Event event) {
        Label pressedDifficulty = (Label) event.getSource();
        if ( pressedDifficulty == selectedDifficulty ) { return; }
        pressedDifficulty.setOpacity(1);
        selectedDifficulty.setOpacity(0.4);
        this.selectedDifficulty = pressedDifficulty;
    }

    public void continuePressed() {
        // check name conditions here
        playerManager.storeValues(txtName.getText(), (int) sldRounds.getValue(), difficultyLabels.indexOf(selectedDifficulty));
        windowManager.toTowerScreen();
    }

    public void backPressed() {
        windowManager.toHomeScreen();
    }

    public void sliderChanged() {
        lblSliderPosition.setText(String.valueOf(((int) sldRounds.getValue())));
    }

}
