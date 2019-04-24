package net.ictcampus.fangis;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.KeyListener;

public class Controller extends Application implements EventHandler<ActionEvent> { //KeyListener {

    private Button playButton, nextButton, abrButton, gameStart;

    public static void main(String[] args) {
        launch(args);
    }

    private GameGui gui;
    @Override
    public void start(Stage primaryStage) throws Exception {
        playButton = new Button("Play");
        gameStart = new Button("Let's Go!");
        nextButton = new Button("Next");
        abrButton = new Button("Abbrechen");
        gui = new GameGui(primaryStage, playButton, nextButton, abrButton, gameStart);
        gui.buildWelcomeScreen();
        playButton.setOnAction(this);
        nextButton.setOnAction(this);
        gameStart.setOnAction(this);
    }



    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == playButton) {
            gui.buildSetNameScreen();
        }
        else if (event.getSource() == nextButton) {
            if (!gui.txtPlayer1.getText().equals("") && !gui.txtPlayer2.getText().equals("")) {
                gui.buildExplainScreen();
            }
            else {
                if (gui.lblErrorMessage.getScene() == null) {
                    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.1), gui.lblErrorMessage);
                    fadeTransition.setFromValue(1.0);
                    fadeTransition.setToValue(0.0);
                    fadeTransition.setCycleCount(Animation.INDEFINITE);
                    fadeTransition.play();
                    gui.setNameScenePane.add(gui.lblErrorMessage, 0,4);
                    GridPane.setColumnSpan(gui.lblErrorMessage, 2);
                }
                else {
                   gui.setNameScenePane.getChildren().remove(gui.lblErrorMessage);
                    GridPane.setColumnSpan(gui.lblErrorMessage, 2);
                }

            }
        }
        else if (event.getSource() == gameStart) {
            gui.buildGameFieldScreen();
        }
    }




    //Handels all events

//    //Hanlde Methode für Buttonactions
//    public void handle(ActionEvent event) {
//        if (event.getSource() == playButton) {
//            buildSetNameScene();
//        }
//        else if (event.getSource() == nextButton) {
//            if (!txtPlayer1.getText().equals("") && !txtPlayer2.getText().equals("")) {
//                buildExplainScene();
//            }
//            else {
//                if (lblErrorMessage.getScene() == null) {
//                    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.1), lblErrorMessage);
//                    fadeTransition.setFromValue(1.0);
//                    fadeTransition.setToValue(0.0);
//                    fadeTransition.setCycleCount(Animation.INDEFINITE);
//                    fadeTransition.play();
//                    setNameScenePane.add(lblErrorMessage, 0,4);
//                    GridPane.setColumnSpan(lblErrorMessage, 2);
//                }
//                else {
//                    setNameScenePane.getChildren().remove(lblErrorMessage);
//                    setNameScenePane.add(lblErrorMessage, 0,4);
//                    GridPane.setColumnSpan(lblErrorMessage, 2);
//                }
//
//            }
//        }
//        else if (event.getSource() == gameStart) {
//            buildGameField();
//        }
//    }
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//        switch(e.getKeyCode()) {
//            case KeyEvent.VK_B:
//                animator.stop();
//        }
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
}
