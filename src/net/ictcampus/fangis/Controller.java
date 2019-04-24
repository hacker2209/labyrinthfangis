package net.ictcampus.fangis;

import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Controller extends Application {

    GameFieldGUI gui = new GameFieldGUI();

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primarystage) {
//        this.primarystage = primarystage;
        gui.buildWelcomeScene();
    }
}
