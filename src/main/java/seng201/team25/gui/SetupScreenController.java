package seng201.team25.gui;

import seng201.team25.services.MenuManager;

public class SetupScreenController {
    MenuManager menuManager;

    public SetupScreenController(MenuManager menuManager) {
        this.menuManager = menuManager;
    }

    public void continuePressed() {
        menuManager.toTowerScreen();
    }
    public void backPressed() {
        menuManager.toHomeScreen();
    }

    public void difficultyPressed() {

    }

}
