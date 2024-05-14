package seng201.team25.gui;

import seng201.team25.services.WindowManager;

public class HomeScreenController {
    WindowManager windowManager;

    public HomeScreenController(WindowManager windowManager) {
        this.windowManager = windowManager;
    }
    public void startGamePressed() {
        windowManager.toSetupScreen();
    }
    public void btnQuitPressed() {
        System.out.println("Start pressed");
    }
}
