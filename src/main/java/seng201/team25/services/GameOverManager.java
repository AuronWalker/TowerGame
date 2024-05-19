package seng201.team25.services;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameOverManager {
    public static boolean gameOver = false;

    // Added to allow calling of new windows (i.e shop) from the main game
    // would use windowManager.toShopWindow(), although not yet implemented

    public static Button quitButton;
    public static Button restartButton;
    public static WindowManager windowManager;

    public static void GameOverScreen(AnchorPane anchorPane){
        Label gameOverText = new Label();

        restartButton.setVisible(true);
        quitButton.setVisible(true);

        restartButton.setOnAction(event -> {
            anchorPane.getChildren().remove(quitButton);
            anchorPane.getChildren().remove(restartButton);
            windowManager.toGameScreen();
        });

        quitButton.setOnAction(event -> {
            Stage stage = (Stage) restartButton.getScene().getWindow();
            stage.close();
        });

        gameOverText.setText("Game Over :(");

        gameOverText.setLayoutX(850);
        gameOverText.setLayoutY(320);

        gameOverText.setFont(Font.font(50));
        gameOverText.setTextFill(Color.BLACK);
        gameOverText.setStyle("-fx-font-weight: bold");

        anchorPane.getChildren().add(restartButton);
        anchorPane.getChildren().add(quitButton);
        anchorPane.getChildren().add(gameOverText);
    }
}
