package seng201.team25.services;
import java.util.function.Consumer;

/**
 * Used to control movement between game screens using the same JavaFX window.
 */

public class WindowManager {
    private final Consumer<WindowManager> homeScreenLauncher;
    private final Consumer<WindowManager> setupScreenLauncher;
    private final Consumer<WindowManager> towerScreenLauncher;
    private final Consumer<WindowManager> gameScreenLauncher;
    //private final Consumer<WindowManager> shopScreenLauncher;
    private final Runnable clearScreen;

    /**
     *
     * @param homeScreenLauncher Reference to the homeScreenLauncher function of WindowManager
     * @param setupScreenLauncher Reference to the setupScreenLauncher function of WindowManager
     * @param towerScreenLauncher Reference to the towerScreenLauncher function of WindowManager
     * @param gameScreenLauncher Reference to the gameScreenLauncher function of WindowManager
     * @param clearScreen Reference to the clearScreen function of WindowManager
     */
    public WindowManager(Consumer<WindowManager> homeScreenLauncher, Consumer<WindowManager> setupScreenLauncher, Consumer<WindowManager> towerScreenLauncher, Consumer<WindowManager> gameScreenLauncher, Runnable clearScreen) {
        this.homeScreenLauncher = homeScreenLauncher;
        this.setupScreenLauncher = setupScreenLauncher;
        this.towerScreenLauncher = towerScreenLauncher;
        this.gameScreenLauncher = gameScreenLauncher;
        //this.shopScreenLauncher = shopScreenLauncher;
        this.clearScreen = clearScreen;
        launchHomeScreen();
    }

    /**
     * Launches the home screen without clearing.
     * Used when no screen is already loaded.
     */
    public void launchHomeScreen() {
        homeScreenLauncher.accept(this);
    }

    /**
     * Clears the existing screen, then launches the home screen.
     * Used when another screen is already loaded.
     */
    public void toHomeScreen() {
        clearScreen.run();
        homeScreenLauncher.accept(this);
    }

    /**
     * Clears the existing screen, then launches the setup screen.
     */
    public void toSetupScreen() {
        clearScreen.run();
        setupScreenLauncher.accept(this);
    }

    /**
     * Clears the existing screen, then launches the tower selection screen.
     */
    public void toTowerScreen() {
        clearScreen.run();
        towerScreenLauncher.accept(this);
    }

    /**
     * Clears the existing screen, then launches the main game screen.
     */
    public void toGameScreen() {
        clearScreen.run();
        gameScreenLauncher.accept(this);
    }
}
