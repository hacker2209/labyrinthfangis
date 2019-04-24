package net.ictcampus.fangis;

import javafx.application.Application;
import javafx.stage.Stage;

public class Controller extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primarystage) {
        GameFieldGUI gui = new GameFieldGUI(primarystage);
        gui.buildWelcomeScene();
    }
}
