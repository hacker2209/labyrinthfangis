package net.ictcampus.fangis;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Controller extends Application implements EventHandler<ActionEvent> {

    //Instancevariabels
    private Button playButton, nextButton, abrButton, gameStart, gameQuitButton;
    protected Box keyboardNode = new Box();
    protected Player catcher, escaper;
    private GameGui gui;
    protected AnimationTimer ani;
    protected GameTimer  gameTimer;
    private checkCollision coli;
    private Keyhandler keyhandler;
    private gameObejctGenerator gobi;

    public static void main(String[] args) {
        launch(args);
    }

    //Real Main logic, looks for Buttonactions, has AnimatorTimer for Game...
    @Override
    public void start(Stage primaryStage) throws Exception {
        playButton = new Button("Play");
        gameStart = new Button("Let's Go!");
        nextButton = new Button("Next");
        abrButton = new Button("Abbrechen");
        gameQuitButton = new Button("Quit");
        try {
            gui = new GameGui(primaryStage, playButton, nextButton, abrButton, gameStart, keyboardNode,gameQuitButton,  this);
            gui.buildWelcomeScreen();
            playButton.setOnAction(this);
            nextButton.setOnAction(this);
            gameStart.setOnAction(this);
            gameQuitButton.setOnAction(this);
            gobi = new gameObejctGenerator(gui);
            keyhandler = new Keyhandler(gui, this);
            coli = new checkCollision(this, gui);
            gobi.createObstacle(10);
//            System.out.println(gobi.randomXPosition());
//            System.out.println(gobi.obstacles);
            // need to attach KeyEvent caller to a Node of some sort.
            // How about an invisible Box?
            keyboardNode.setFocusTraversable(true);
            keyboardNode.requestFocus();

            //Make Thread for Collisioncheck
            ani = new AnimationTimer(){
                @Override
                public void handle(long now) {
//                    keyboardNode.setOnKeyReleased(e -> keyhandler.releasehandle(e));
                    keyboardNode.setOnKeyPressed(e -> keyhandler.handle(e));
                    // UPDATE
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Players are created by GameGui hwo gives them back to the Controller with this method
    protected void setPlayers(Player catcher, Player escaper) {
        this.catcher = catcher;
        this.escaper = escaper;
    }

    //Handle method for Buttonactions
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

            ani.start();
            coli.start();
//            coli.gugus();
        }
        else if (event.getSource() == gameQuitButton) {
            gui.primarystage.close();
        }
    }


}
