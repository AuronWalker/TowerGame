package seng201.team25.gui;

import seng201.team25.services.WindowManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Wrapper for each FXML scene loaded by the game.
 */
public class FXWrapper {
    @FXML
    private Pane pane;
    private Stage stage;

    /**
     * Initialise the stage and WindowManager.
     * @param stage blank Stage object to load FXML data to
     */
    public void init(Stage stage) {
        this.stage = stage;
        new WindowManager(this::launchHomeScreen, this::launchSetupScreen, this::launchTowerScreen, this::launchGameScreen, this::clearPane);
    }

    /**
     * Launch the home screen.
     * @param windowManager global WindowManager
     */
    public void launchHomeScreen(WindowManager windowManager) {
        try {
            FXMLLoader setupLoader = new FXMLLoader(getClass().getResource("/fxml/home_screen.fxml"));
            // provide a custom Controller with parameters
            setupLoader.setControllerFactory(param -> new HomeScreenController(windowManager));
            Parent setupParent  = setupLoader.load();
            pane.getChildren().add(setupParent);
            stage.setTitle("Tower Game");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Launch the setup screen.
     * @param windowManager global WindowManager
     */
    public void launchSetupScreen(WindowManager windowManager) {
        try {
            FXMLLoader setupLoader = new FXMLLoader(getClass().getResource("/fxml/setup_screen.fxml"));
            // provide a custom Controller with parameters
            setupLoader.setControllerFactory(param -> new SetupScreenController(windowManager));
            Parent setupParent  = setupLoader.load();
            pane.getChildren().add(setupParent);
            stage.setTitle("Tower Game");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Launch the tower screen.
     * @param windowManager global WindowManager
     */
    public void launchTowerScreen(WindowManager windowManager) {
        try {
            FXMLLoader setupLoader = new FXMLLoader(getClass().getResource("/fxml/tower_selector.fxml"));
            // provide a custom Controller with parameters
            setupLoader.setControllerFactory(param -> new TowerScreenController(windowManager));
            Parent setupParent  = setupLoader.load();
            pane.getChildren().add(setupParent);
            stage.setTitle("Tower Game");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Launch the game screen.
     * @param windowManager global WindowManager
     */
    public void launchGameScreen(WindowManager windowManager) {
        try {
            FXMLLoader setupLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
            // provide a custom Controller with parameters
            setupLoader.setControllerFactory(param -> new MainGameController(windowManager));
            Parent setupParent  = setupLoader.load();
            pane.getChildren().add(setupParent);
            stage.setTitle("Tower Game");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Clear the screen before loading a new FXML scene.
     */
    public void clearPane() {
        pane.getChildren().removeAll(pane.getChildren());
    }

}
