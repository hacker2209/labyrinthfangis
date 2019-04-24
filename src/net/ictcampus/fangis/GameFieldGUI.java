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
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameFieldGUI implements EventHandler<ActionEvent> {

    //Instancevariabels for all Scenes
    Stage primarystage;
    private Scene setNameScene, explainScene, welcomeScene, gameScene;
    private BorderPane welcomeScenePane;
    private GridPane setNameScenePane, explainScenePane, gameRasterPane, gameFieldPane;


    //Instancevariabels for explainScene
    private Label explainTitle, catcherExplanation, escaperExplanation, catchername, escapername;
    private Button gameStart;

    //Instancevariables for welcomeScene
    private Label welcomeText, gameTitle;
    private Button playButton;

    //Instancevariabels for setNameScene
    private Button nextButton;
    private Label lblName, lblPlayer1, lblPlayer2, lblErrorMessage, lblNothing;
    private TextField txtPlayer1, txtPlayer2;

    //Instancevariabels for gameField
    private Label lblScore, lblTimer;
    private Button abrButton;

    //Konstruktor
    public GameFieldGUI(Stage primarystage) {
        this.primarystage = primarystage;
    }

    public void buildWelcomeScene() {

        welcomeScenePane = new BorderPane();
        welcomeScene = new Scene(welcomeScenePane, 300, 160);

        //Create Nodes for welcomeScene
        welcomeText = new Label("Welcome to our Labyrinth-Fanigs Game!\nThis is a simple Game\nmade by zauggmo and Technat314");
        gameTitle = new Label("Labyrinth-Fangis");
        playButton = new Button("Play");

        //Define Buttonaction
        playButton.setOnAction(this);

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
    /**
     * Wechselt zur SetNameScene
     */
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
        gameFieldPane = new GridPane();
        gameScene = new Scene(gameRasterPane, 1000,600);

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

        //Put Nodes on Field

        //Show Scene
        primarystage.setScene(gameScene);
        primarystage.show();
    }


    //Hanlde Methode für Buttonactions
    @Override
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
