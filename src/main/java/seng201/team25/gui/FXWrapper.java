package seng201.team25.gui;

import seng201.team25.services.WindowManager;
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
        new WindowManager(this::launchHomeScreen, this::launchSetupScreen, this::launchTowerScreen, this::launchGameScreen, this::launchShopScreen, this::clearPane);
    }

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

    public void launchGameScreen(WindowManager windowManager) {
        try {
            FXMLLoader setupLoader = new FXMLLoader(getClass().getResource("/fxml/new_main.fxml"));
            // provide a custom Controller with parameters
            setupLoader.setControllerFactory(param -> new MainGameController(windowManager));
            Parent setupParent  = setupLoader.load();
            pane.getChildren().add(setupParent);
            stage.setTitle("Tower Game");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void launchShopScreen(WindowManager windowManager) {
        try {
            FXMLLoader setupLoader = new FXMLLoader(getClass().getResource("/fxml/shop.fxml"));
            // provide a custom Controller with parameters
            setupLoader.setControllerFactory(param -> new ShopScreenController(windowManager));
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
