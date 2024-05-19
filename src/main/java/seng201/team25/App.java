package seng201.team25;

import seng201.team25.gui.FXWindow;

/**
 * This class is now redundant, but kept for easy testing of MainGameController
 */
public class App {

    /**
     * Entry point which runs the javaFX application
     * Due to how JavaFX works we must call MainWindow.launchWrapper() from here,
     * trying to run MainWindow itself will cause an error
     * @param args program arguments from command line
     */
    public static void main(String[] args) {
        FXWindow.launchWrapper(args);
    }
}
