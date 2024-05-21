package seng201.team25.services;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import seng201.team25.gui.MainGameController;

public class GameOverManager {
    public static boolean gameOver = false;

    /**
    * Displays the text and buttons for game over screen.
    * @param anchorPane anchor pane to attach text to.
    * @param mg main game controller to call a function that displays game over buttons.
    **/
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
