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
    @FXML
    private Label lblValidName;
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

            if (txtName.getText().length() > 2 && txtName.getText().length() < 16) {
                if (txtName.getText().matches("[A-Za-z0-9]+")) {
                    PlayerManager.storeValues(txtName.getText(), difficultyLabels.indexOf(selectedDifficulty), (int) sldRounds.getValue());
                    windowManager.toTowerScreen();
                } else {
                    lblValidName.setText("Name cannot include special characters");
                    lblValidName.setVisible(true);
                }
            } else {
                lblValidName.setText("Name must be between 3 and 15 characters");
                lblValidName.setVisible(true);
            }
    }

    public void backPressed() {
        windowManager.toHomeScreen();
    }

    public void sliderChanged() {
        lblSliderPosition.setText(String.valueOf(((int) sldRounds.getValue())));
    }

    public void txtChanged() {
        lblValidName.setVisible(false);
    }



}
