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
    }
    //Handels all events
    public void handle(ActionEvent event) {
        if (event.getSource() == playButton) {
            buildSetNameScene();
        }
        else if (event.getSource() == nextButton) {
            if (!txtPlayer1.getText().equals("") && !txtPlayer2.getText().equals("")) {
                buildExplainScene();
            }
            else {
                if (lblErrorMessage.getScene() == null) {
                    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.1), lblErrorMessage);
                    fadeTransition.setFromValue(1.0);
                    fadeTransition.setToValue(0.0);
                    fadeTransition.setCycleCount(Animation.INDEFINITE);
                    fadeTransition.play();
                    setNameScenePane.add(lblErrorMessage, 0,4);
                    GridPane.setColumnSpan(lblErrorMessage, 2);
                }
                else {
                    setNameScenePane.getChildren().remove(lblErrorMessage);
                    setNameScenePane.add(lblErrorMessage, 0,4);
                    GridPane.setColumnSpan(lblErrorMessage, 2);
                }

            }
        }
        else if (event.getSource() == gameStart) {
            buildGameField();
        }
    }

}
