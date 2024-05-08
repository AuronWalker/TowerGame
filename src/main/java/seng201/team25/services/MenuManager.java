package seng201.team25.services;

import java.util.function.Consumer;

public class MenuManager {
    private final Consumer<MenuManager> homeScreenLauncher;
    private final Consumer<MenuManager> setupScreenLauncher;
    private final Consumer<MenuManager> towerScreenLauncher;

    private final Runnable clearScreen;


    public MenuManager(Consumer<MenuManager> homeScreenLauncher, Consumer<MenuManager> setupScreenLauncher, Consumer<MenuManager> towerScreenLauncher, Runnable clearScreen) {
        System.out.println("attempting launchhomescreen");
        this.homeScreenLauncher = homeScreenLauncher;
        this.setupScreenLauncher = setupScreenLauncher;
        this.towerScreenLauncher = towerScreenLauncher;
        this.clearScreen = clearScreen;
        launchHomeScreen();
    }

    public void launchHomeScreen() {
        homeScreenLauncher.accept(this);
    }
    public void launchSetupScreen() {
        setupScreenLauncher.accept(this);
    }
    public void launchTowerScreen() {
        towerScreenLauncher.accept(this);
    }

    public void toHomeScreen() {
        clearScreen.run();
        launchHomeScreen();
    }
    public void toSetupScreen() {
        clearScreen.run();
        launchSetupScreen();
    }
    public void toTowerScreen() {
        clearScreen.run();
        launchTowerScreen();
    }
}
