package seng201.team25.gui;

import seng201.team25.services.WindowManager;

/**
 * FXML controller for the home screen. Simply
 */
public class HomeScreenController {
    WindowManager windowManager;

    public HomeScreenController(WindowManager windowManager) {
        this.windowManager = windowManager;
    }
    public void startGamePressed() {
        windowManager.toSetupScreen();
    }

}
