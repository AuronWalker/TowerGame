package seng201.team25.gui;

import seng201.team25.services.WindowManager;

/**
 * FXML controller for the home screen.
 */
public class HomeScreenController {
    final WindowManager windowManager;

    /**
     * FXML: Constructor.
     * @param windowManager global window manager
     */
    public HomeScreenController(WindowManager windowManager) {
        this.windowManager = windowManager;
    }

    /**
     * FXML: Proceed to setup when Start button pressed.
     */
    public void startGamePressed() {
        windowManager.toSetupScreen();
    }

}
