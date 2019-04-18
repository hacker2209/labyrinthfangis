package net.ictcampus.fangis;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameFieldGUI extends Application implements EventHandler<ActionEvent> {

    //Instancevariabels for all Scenes
    private Stage primarystage;
    private Scene setNameScene, explainScene, welcomeScene;
    private BorderPane welcomeScenePane;
    private GridPane setNameScenePane, explainScenePane;

    //Instancevariabels for explainScene
    private Label explainTitle, catcherExplanation, escaperExplanation;
    private Button gameStart;


    //Instancevariables for welcomeScene
    private Label welcomeText, gameTitle;
    private Button playButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //initialize Instancevariabels
        this.primarystage = primaryStage;
        welcomeScenePane = new BorderPane();
        setNameScenePane = new GridPane();
        explainScenePane = new GridPane();
        welcomeScene = new Scene(welcomeScenePane, 300,150);
        explainScene = new Scene(explainScenePane);
        setNameScene = new Scene(setNameScenePane);

        primaryStage.setTitle("Testtile");
        primaryStage.setScene(explainScene);
        primaryStage.show();
    }
    public void buildWelcomeScene() {
        //Create Nodes for welcomeScene
        welcomeText = new Label("Welcome to our Labyrinth-Fanigs Game. This is a simple \nGame made by zauggmo and Technat314");
        gameTitle = new Label("Labyrinth-Fangis");
        playButton = new Button("Play");

        //Define Buttonaction
        playButton.setOnAction(this);

        //Put Nodes on Pane
        welcomeScenePane.setTop(gameTitle);
        welcomeScenePane.setBottom(playButton);
        welcomeScenePane.setCenter(welcomeText);

        //Add some Style to welcomeScene
        welcomeScene.getStylesheets().add(getClass().getResource("welcomeScene.css").toExternalForm());
        gameTitle.getStyleClass().add("gameTitle");
        primaryStage.setScene(welcomeScene);
        primaryStage.show();
    }

    public void buildExplainScene() {

        //Initialize Nodes for Grid
        gameStart = new Button("Let's Go!");
        explainTitle = new Label("How it Works...");
        catcherExplanation = new Label("-Your aim is it catch the other Player by simply touching him \n- Controll with WASD \n-Throw Bananas with r");
        escaperExplanation =  new Label("-Your aim is it to escape from the catcher until the Timer is done \n- Controll with Arrow-Keys \n- Throw Bananas with 1");

        //Put Nodes on Grid
        explainScenePane.add(explainTitle, 0,0);
        GridPane.setColumnSpan(explainTitle, 2);
        explainScenePane.add(catcherExplanation, 0, 1);
        explainScenePane.add(escaperExplanation, 1,1);
        explainScenePane.add(gameStart, 0,2);
        GridPane.addColumnSpan(gameStart, 2);

        //Some styling for Grid
        explainScenePane.getStylesheets().add(getClass().getResource("explainScene.css").toExternalForm());
        explainTitle.getStyleClass().add("explainTitle");


    }

    //Hanlde Methode für Buttonactions
    @Override
    public void handle(ActionEvent event) {
        //To Do
    }
}
