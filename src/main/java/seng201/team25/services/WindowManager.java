package seng201.team25.services;

import java.util.function.Consumer;

public class WindowManager {
    private final Consumer<WindowManager> homeScreenLauncher;
    private final Consumer<WindowManager> setupScreenLauncher;
    private final Consumer<WindowManager> towerScreenLauncher;
    private final Consumer<WindowManager> gameScreenLauncher;
    private final Consumer<WindowManager> shopScreenLauncher;

    private final Runnable clearScreen;



    public WindowManager(Consumer<WindowManager> homeScreenLauncher, Consumer<WindowManager> setupScreenLauncher, Consumer<WindowManager> towerScreenLauncher, Consumer<WindowManager> gameScreenLauncher, Consumer<WindowManager> shopScreenLauncher, Runnable clearScreen) {
        this.homeScreenLauncher = homeScreenLauncher;
        this.setupScreenLauncher = setupScreenLauncher;
        this.towerScreenLauncher = towerScreenLauncher;
        this.gameScreenLauncher = gameScreenLauncher;
        this.shopScreenLauncher = shopScreenLauncher;
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
    public void launchGameScreen() {
        gameScreenLauncher.accept(this);
    }
    public void launchShopScreen() {
        shopScreenLauncher.accept(this);
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

    public void toGameScreen() {
        clearScreen.run();
        launchGameScreen();
    }

    public void toShopScreen() {
        clearScreen.run();
        launchShopScreen();
    }


}
