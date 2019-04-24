package net.ictcampus.fangis;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.KeyEvent;

public class Controller extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primarystage) {
        GameFieldGUI gui = new GameFieldGUI(primarystage, this);
        gui.buildWelcomeScene();

        AnimationTimer ani = new AnimationTimer(){

            @Override
            public void handle(long arg0) {

            }
        };
        ani.start();
    }
    //Handels all events


}
