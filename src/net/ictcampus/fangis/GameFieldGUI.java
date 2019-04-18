package net.ictcampus.fangis;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameFieldGUI extends Application implements EventHandler<ActionEvent> {

    //Instancevariabels
    private Stage primarystage;
    private BorderPane welcomeScene;
    private GridPane setNameScene, explainScene;
    private Label welcomeText, gameTitle;
    private Button playButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //initialize Instancevariabels
        this.primarystage = primaryStage;
        welcomeScene = new BorderPane();
        setNameScene = new GridPane();
        explainScene = new GridPane();

        //Create Nodes for welcomeScene
        welcomeText = new Label("Welcome to our Labyrinth-Fanigs Game. This is a simple \nGame made by zauggmo and Technat314");
        gameTitle = new Label("Labyrinth-Fangis");
        playButton = new Button("Play");

        //Define Buttonaction
        playButton.setOnAction(this);

        //Put Nodes on Pane
        welcomeScene.setTop(gameTitle);
        welcomeScene.setBottom(playButton);
        welcomeScene.setCenter(welcomeText);

        //Add some Style to welcomeScene
        welcomeScene.getStylesheets().add(getClass().getResource("welcomeScene.css").toExternalForm());
        gameTitle.getStyleClass().add("gameTitle");
    }

    //Hanlde Methode für Buttonactions
    @Override
    public void handle(ActionEvent event) {
        //To Do
    }
}
