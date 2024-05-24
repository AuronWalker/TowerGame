package seng201.team25.gui;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import seng201.team25.services.NameVerifier;
import seng201.team25.services.PlayerManager;
import seng201.team25.services.WindowManager;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

/**
 * FXML Controller for the setup screen stage.
 */

public class SetupScreenController {
    final WindowManager windowManager;

    @FXML private Label lblEasy;
    @FXML private Label lblNormal;
    @FXML private Label lblHard;
    @FXML private TextField txtName;
    @FXML private Slider sldRounds;
    @FXML private Label lblSliderPosition;
    @FXML private Label lblValidName;
    private Label selectedDifficulty;
    private final List<Label> difficultyLabels = new ArrayList<>();


    /**
     * Constructor to set the private windowManager when SetupScreen is created
     * @param windowManager FXWindow controller object
     */
    public SetupScreenController(WindowManager windowManager) {
        this.windowManager = windowManager;
    }


    /**
     * FXML: Initialize the object, called by JavaFX on UI load
     */
    public void initialize() {
        this.selectedDifficulty = lblEasy;
        difficultyLabels.addAll(List.of(lblEasy, lblNormal, lblHard));
    }


    /**
     * FXML: Update the display when a new difficulty is selected.
     * @param event button press event
     */
    public void difficultyPressed(Event event) {
        Label pressedDifficulty = (Label) event.getSource();
        if ( pressedDifficulty == selectedDifficulty ) { return; }
        pressedDifficulty.setOpacity(1);
        selectedDifficulty.setOpacity(0.4);
        this.selectedDifficulty = pressedDifficulty;
    }


    /**
     * FXML: Verify name validity and continue when "Continue" button pressed.
     */
    public void continuePressed() {
            // Check name is longer than 2 characters
            if (NameVerifier.verifyName(txtName.getText()) == 1) {
                PlayerManager.storeValues(txtName.getText(), difficultyLabels.indexOf(selectedDifficulty), (int) sldRounds.getValue());
                windowManager.toTowerScreen();
            } else if (NameVerifier.verifyName(txtName.getText()) == -1) {
                lblValidName.setText("Name cannot include special characters");
                lblValidName.setVisible(true);
            } else {
                lblValidName.setText("Name must be between 3 and 15 characters");
                lblValidName.setVisible(true);
            }
    }


    /**
     * FXML: Returns to previous screen when back button pressed
     */
    public void backPressed() {
        windowManager.toHomeScreen();
    }


    /**
     * FXML: Update the slider position label when the slider changes state.
     */
    public void sliderChanged() {
        lblSliderPosition.setText(String.valueOf(((int) sldRounds.getValue())));
    }


    /**
     * FXML: Hide the invalid name text when the user changes their name.
     */
    public void txtChanged() {
        lblValidName.setVisible(false);
    }
}
