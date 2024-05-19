package seng201.team25.services;

import javafx.scene.Scene;
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

    public static void GameOverScreen(AnchorPane anchorPane){
        Label gameOverText = new Label();
        Button restartButton = new Button();
        Button quitButton = new Button();

        restartButton.setOnAction(event -> {
            
        });

        quitButton.setOnAction(event -> {
            Stage stage = (Stage) restartButton.getScene().getWindow();
            stage.close();
        });
        
        restartButton.setText("Restart");
        gameOverText.setText("Game Over :(");
        quitButton.setText("Quit");

        gameOverText.setLayoutX(850);
        gameOverText.setLayoutY(320);
        restartButton.setLayoutX(850);
        restartButton.setLayoutY(450);
        quitButton.setLayoutX(1100);
        quitButton.setLayoutY(450);

        gameOverText.setFont(Font.font(50));
        gameOverText.setTextFill(Color.BLACK);
        gameOverText.setStyle("-fx-font-weight: bold");
        anchorPane.getChildren().add(gameOverText);
        anchorPane.getChildren().add(restartButton);
        anchorPane.getChildren().add(quitButton);
    }
}
