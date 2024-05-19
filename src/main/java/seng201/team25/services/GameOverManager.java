package seng201.team25.services;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import seng201.team25.gui.MainGameController;

public class GameOverManager {
    public static boolean gameOver = false;

    // Added to allow calling of new windows (i.e shop) from the main game
    // would use windowManager.toShopWindow(), although not yet implemented
    public static WindowManager windowManager;

    public static void GameOverScreen(AnchorPane anchorPane, MainGameController mg){
        Label gameOverText = new Label();
        mg.displayButtons();
        gameOverText.setText("Game Over :(");

        gameOverText.setLayoutX(850);
        gameOverText.setLayoutY(320);

        gameOverText.setFont(Font.font(50));
        gameOverText.setTextFill(Color.BLACK);
        gameOverText.setStyle("-fx-font-weight: bold");
        anchorPane.getChildren().add(gameOverText);
    }
}
