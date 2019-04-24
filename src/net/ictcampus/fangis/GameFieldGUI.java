package net.ictcampus.fangis;

import javafx.animation.Animation;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFieldGUI implements EventHandler<ActionEvent>, KeyListener {

    //Instancevariabels for all Scenes
    Stage primarystage;
    Controller con;
    Scene setNameScene, explainScene, welcomeScene, gameScene;
    BorderPane welcomeScenePane;
    GridPane setNameScenePane, explainScenePane, gameRasterPane;
    Pane gameFieldPane;


    //Instancevariabels for explainScene
    Label explainTitle, catcherExplanation, escaperExplanation, catchername, escapername;
    Button gameStart;

    //Instancevariables for welcomeScene
    Label welcomeText, gameTitle;
    Button playButton;

    //Instancevariabels for setNameScene
    Button nextButton;
    Label lblName, lblPlayer1, lblPlayer2, lblErrorMessage, lblNothing;
    TextField txtPlayer1, txtPlayer2;

    //Instancevariabels for gameField
    Label lblScore, lblTimer;
    Button abrButton;

    //Konstruktor
    public GameFieldGUI(Stage primarystage, Controller con) {
        this.primarystage = primarystage;
        this.con = con;
    }

    public void buildWelcomeScene() {

        welcomeScenePane = new BorderPane();
        welcomeScene = new Scene(welcomeScenePane, 300, 160);

        //Create Nodes for welcomeScene
        welcomeText = new Label("Welcome to our Labyrinth-Fanigs Game!\nThis is a simple Game\nmade by zauggmo and Technat314");
        gameTitle = new Label("Labyrinth-Fangis");
        playButton = new Button("Play");

        //Define Buttonaction
        playButton.setOnAction(e -> con.handle(e));

        //Put Nodes on PaneT
        welcomeScenePane.setTop(gameTitle);
        welcomeScenePane.setBottom(playButton);
        welcomeScenePane.setCenter(welcomeText);

        //Add some Style to welcomeScene
        welcomeScene.getStylesheets().add(getClass().getResource("welcomeScene.css").toExternalForm());
        gameTitle.getStyleClass().add("gameTitle");
        playButton.getStyleClass().add("playButton");
        welcomeScenePane.getStyleClass().add("pane");
        welcomeText.getStyleClass().add("text");

        //Show welcomeScene
        primarystage.setScene(welcomeScene);
        primarystage.show();
    }
    public void buildExplainScene() {

        explainScenePane = new GridPane();
        explainScene = new Scene(explainScenePane, 400, 300);


        //Initialize Nodes for Grid
        gameStart = new Button("Let's Go!");
        catchername  = new Label(txtPlayer1.getText());
        escapername = new Label(txtPlayer2.getText());
        explainTitle = new Label("How it Works...");
        catcherExplanation = new Label("- Your aim is\n to catch\nthe other by touching him\n- Controll with WASD \n- Throw Bananas with r");
        escaperExplanation =  new Label("- Your aim is\n to escape  \n- Controll with Arrow-Keys \n- Throw Bananas with 1");
        GridPane.setColumnSpan(explainTitle,2);

        //Put Nodes on Grid
        explainScenePane.add(explainTitle, 0,0);
        explainScenePane.add(catchername, 0, 1);
        explainScenePane.add(escapername, 1, 1);
        explainScenePane.add(catcherExplanation, 0, 2);
        explainScenePane.add(escaperExplanation, 1,2);
        explainScenePane.add(gameStart, 0,3);
        GridPane.setColumnSpan(gameStart, 2);

        //Some styling for Grid
        explainScenePane.getStylesheets().add(getClass().getResource("explainScene.css").toExternalForm());
        explainTitle.getStyleClass().add("explainTitle");
        explainScenePane.getStyleClass().add("pane");
        catcherExplanation.getStyleClass().add("explan");
        escaperExplanation.getStyleClass().add("explan");
        catchername.getStyleClass().add("name");
        escapername.getStyleClass().add("name");
        gameStart.getStyleClass().add("start");
        explainScenePane.setVgap(30);
        explainScenePane.setHgap(30);

        //Define Button Actions
        gameStart.setOnAction(this);

        //Show explainScene
        primarystage.setScene(explainScene);
        primarystage.show();
    }

    public void buildSetNameScene() {

        setNameScenePane = new GridPane();
        setNameScene = new Scene(setNameScenePane, 300, 200);

        //Initialize Nodes for Grid
        nextButton = new Button("Next");
        lblName = new Label("Set your Names");
        lblPlayer1 = new Label("Player 1: ");
        lblPlayer2 = new Label("Player 2: ");
        txtPlayer1 = new TextField();
        txtPlayer2 = new TextField();
        lblErrorMessage = new Label("No valid Names!");
        lblNothing = new Label();

        //Action for next Button
        nextButton.setOnAction(this);

        //Grid styling
        setNameScene.getStylesheets().add(getClass().getResource("setNameScene.css").toExternalForm());
        lblName.getStyleClass().add("nameTitle");
        setNameScenePane.getStyleClass().add("pane");
        nextButton.getStyleClass().add("button");
        lblPlayer1.getStyleClass().add("player");
        lblPlayer2.getStyleClass().add("player");
        lblErrorMessage.getStyleClass().add("error");
        setNameScenePane.setVgap(10);
        setNameScenePane.setHgap(30);

        //Put Nodes into Grid
        setNameScenePane.add(lblName, 0,0);
        setNameScenePane.setColumnSpan(lblName, 2);
        setNameScenePane.add(nextButton,0,3);
        setNameScenePane.setColumnSpan(nextButton, 2);
        setNameScenePane.add(lblPlayer1, 0, 1);
        setNameScenePane.add(txtPlayer1, 1, 1);
        setNameScenePane.add(lblPlayer2, 0, 2);
        setNameScenePane.add(txtPlayer2, 1, 2);

        //Define Button Action
        nextButton.setOnAction(this);

        //Show Scene
        primarystage.setScene(setNameScene);
        primarystage.show();
    }
    public void buildGameField() {
        gameRasterPane = new GridPane();
        gameFieldPane = new Pane();
        gameScene = new Scene(gameRasterPane, 1000,600);
        gameFieldPane.setMaxWidth(1000.0);
        gameFieldPane.setMinHeight(400.0);


//         need to attach KeyEvent caller to a Node of some sort.
//         How about an invisible Box?
        final Box keyboardNode = new Box();
        keyboardNode.setFocusTraversable(true);
        keyboardNode.requestFocus();
        keyboardNode.setOnKeyPressed(this);
        gameFieldPane.getChildren().add(keyboardNode);

        //Initialize Nodes for Grid
        lblScore = new Label("The Score");
        lblTimer = new Label("3:00");
        abrButton = new Button("Abbrechen");


        //Grid Styling
        setNameScene.getStylesheets().add(getClass().getResource("gameField.css").toExternalForm());

        //Put Nodes on Raster
        gameRasterPane.add(gameFieldPane,0,0);
        gameRasterPane.add(abrButton,0,1);
        gameRasterPane.add(lblScore,1,1);
        gameRasterPane.add(lblTimer, 2,1);

        //Make Players
        Player catcher = new Player(0,0,40,40,lblPlayer1.getText(),"catcher", Color.RED);
        Player escaper = new Player(((int)gameFieldPane.getMaxWidth() - 40), 0,40,40,lblPlayer2.getText(), "escaper", Color.BLUE);
        gameFieldPane.getChildren().add(escaper);
        gameFieldPane.getChildren().add(catcher);


        //Put Nodes on Field

        //Show Scene
        primarystage.setScene(gameScene);
        primarystage.show();
    }

    //Hanlde Methode für Buttonactions
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

    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_B:
                animator.stop();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    //------------------------------------------ Getter & Setter ----------------------------------------
    //------------------------------------------ Getter & Setter ----------------------------------------
    //------------------------------------------ Getter & Setter ----------------------------------------
    //------------------------------------------ Getter & Setter ----------------------------------------
    //------------------------------------------ Getter & Setter ----------------------------------------
    //------------------------------------------ Getter & Setter ----------------------------------------
    //------------------------------------------ Getter & Setter ----------------------------------------
    public Stage getPrimarystage() {
        return primarystage;
    }

    public Scene getSetNameScene() {
        return setNameScene;
    }

    public Scene getExplainScene() {
        return explainScene;
    }

    public Scene getWelcomeScene() {
        return welcomeScene;
    }

    public Scene getGameScene() {
        return gameScene;
    }

    public BorderPane getWelcomeScenePane() {
        return welcomeScenePane;
    }

    public GridPane getSetNameScenePane() {
        return setNameScenePane;
    }

    public GridPane getExplainScenePane() {
        return explainScenePane;
    }

    public GridPane getGameRasterPane() {
        return gameRasterPane;
    }

    public Pane getGameFieldPane() {
        return gameFieldPane;
    }

    public Label getExplainTitle() {
        return explainTitle;
    }

    public Label getCatcherExplanation() {
        return catcherExplanation;
    }

    public Label getEscaperExplanation() {
        return escaperExplanation;
    }

    public Label getCatchername() {
        return catchername;
    }

    public Label getEscapername() {
        return escapername;
    }

    public Button getGameStart() {
        return gameStart;
    }

    public Label getWelcomeText() {
        return welcomeText;
    }

    public Label getGameTitle() {
        return gameTitle;
    }

    public Button getPlayButton() {
        return playButton;
    }

    public Button getNextButton() {
        return nextButton;
    }

    public Label getLblName() {
        return lblName;
    }

    public Label getLblPlayer1() {
        return lblPlayer1;
    }

    public Label getLblPlayer2() {
        return lblPlayer2;
    }

    public Label getLblErrorMessage() {
        return lblErrorMessage;
    }

    public Label getLblNothing() {
        return lblNothing;
    }

    public TextField getTxtPlayer1() {
        return txtPlayer1;
    }

    public TextField getTxtPlayer2() {
        return txtPlayer2;
    }

    public Label getLblScore() {
        return lblScore;
    }

    public Label getLblTimer() {
        return lblTimer;
    }

    public Button getAbrButton() {
        return abrButton;
    }


}
