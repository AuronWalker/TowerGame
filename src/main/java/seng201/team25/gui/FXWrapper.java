package seng201.team25.gui;

import seng201.team25.services.MenuManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class FXWrapper {
    @FXML
    private Pane pane;
    private Stage stage;

    public void init(Stage stage) {
        this.stage = stage;
        new MenuManager(this::launchHomeScreen, this::launchSetupScreen, this::launchTowerScreen, this::clearPane);
    }

    public void launchHomeScreen(MenuManager menuManager) {
        try {
            FXMLLoader setupLoader = new FXMLLoader(getClass().getResource("/fxml/home_screen.fxml"));
            // provide a custom Controller with parameters
            setupLoader.setControllerFactory(param -> new HomeScreenController(menuManager));
            Parent setupParent  = setupLoader.load();
            pane.getChildren().add(setupParent);
            stage.setTitle("Tower Game");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void launchSetupScreen(MenuManager menuManager) {
        try {
            FXMLLoader setupLoader = new FXMLLoader(getClass().getResource("/fxml/setup_screen.fxml"));
            // provide a custom Controller with parameters
            setupLoader.setControllerFactory(param -> new SetupScreenController(menuManager));
            Parent setupParent  = setupLoader.load();
            pane.getChildren().add(setupParent);
            stage.setTitle("Tower Game");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void launchTowerScreen(MenuManager menuManager) {
        try {
            FXMLLoader setupLoader = new FXMLLoader(getClass().getResource("/fxml/tower_selector.fxml"));
            // provide a custom Controller with parameters
            setupLoader.setControllerFactory(param -> new TowerScreenController(menuManager));
            Parent setupParent  = setupLoader.load();
            pane.getChildren().add(setupParent);
            stage.setTitle("Tower Game");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearPane() {
        pane.getChildren().removeAll(pane.getChildren());
    }

}
