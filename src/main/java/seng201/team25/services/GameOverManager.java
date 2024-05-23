package seng201.team25.services;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import seng201.team25.gui.MainGameController;

/**
 * Handles win and lose screens at the end of the game, and resetting the game if the player requests another round.
 */
public class GameOverManager {
    private static boolean gameOver = false;
    /**
    * Displays the text and buttons for game over screen.
    * @param anchorPane Anchor pane to attach text to.
    * @param mainGameController Main game controller to call a function that displays game over buttons.
    **/
    public static void gameOverScreen(AnchorPane anchorPane, MainGameController mainGameController){

        mainGameController.displayButtons();
        Label gameOverText = new Label();
        Label gameOverSpice = new Label();
        
        gameOverText.setText("Game Over :(");
        gameOverSpice.setText("You have to be the worst at this game " + PlayerManager.getPlayerName()+ ".");

        gameOverText.setLayoutX(850);
        gameOverText.setLayoutY(320);
        gameOverSpice.setLayoutX(850);
        gameOverSpice.setLayoutY(390);

        gameOverText.setFont(Font.font(50));
        gameOverText.setTextFill(Color.BLACK);
        gameOverSpice.setFont(Font.font(20));
        gameOverSpice.setTextFill(Color.BLACK);
        gameOverText.setStyle("-fx-font-weight: bold");
        anchorPane.getChildren().add(gameOverText);
        anchorPane.getChildren().add(gameOverSpice);
    }

    /**
     * Displays the text and buttons when the user wins the game.
     * @param anchorPane Anchor pane to attach text to
     * @param mainGameController global mainGameController object
     */
    public static void winScreen(AnchorPane anchorPane, MainGameController mainGameController){
        mainGameController.displayButtons();
        Label winText = new Label();
        Label winSpice = new Label();
        
        winText.setText("You Win :)");
        winSpice.setText(PlayerManager.getPlayerName()+ " is out here framing W's");

        winText.setLayoutX(850);
        winText.setLayoutY(320);
        winSpice.setLayoutX(850);
        winSpice.setLayoutY(390);

        winText.setFont(Font.font(50));
        winText.setTextFill(Color.BLACK);
        winSpice.setFont(Font.font(20));
        winSpice.setTextFill(Color.BLACK);
        winText.setStyle("-fx-font-weight: bold");
        anchorPane.getChildren().add(winText);
        anchorPane.getChildren().add(winSpice);
    }

    public static boolean isGameOver() {
        return gameOver;
    }

    public static void setGameOver(boolean _gameOver) {
        gameOver = _gameOver;
    }
}
