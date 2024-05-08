package seng201.team25.gui;

import seng201.team25.services.MenuManager;

public class HomeScreenController {
    MenuManager menuManager;

    public HomeScreenController(MenuManager menuManager) {
        this.menuManager = menuManager;
    }
    public void startGamePressed() {
        menuManager.toSetupScreen();
    }
    public void btnQuitPressed() {
        System.out.println("Start pressed");
    }
}
