package seng201.team25.gui;

import seng201.team25.services.WindowManager;

public class SetupScreenController {
    WindowManager windowManager;

    public SetupScreenController(WindowManager windowManager) {
        this.windowManager = windowManager;
    }

    public void continuePressed() {
        windowManager.toTowerScreen();
    }
    public void backPressed() {
        windowManager.toHomeScreen();
    }

    public void difficultyPressed() {

    }

}
