package net.ictcampus.fangis;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Controller extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primarystage) {
        GameFieldGUI gui = new GameFieldGUI(primarystage);
        gui.buildWelcomeScene();
    }
}
