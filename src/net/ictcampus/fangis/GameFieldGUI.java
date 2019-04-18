package net.ictcampus.fangis;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameFieldGUI extends Application implements EventHandler<ActionEvent> {

    //Instancevariabels
    private Stage primarystage;
    private Scene setNameScene, explainScene, welcomeScene;
    private BorderPane welcomeScenePane;
    private GridPane setNameScenePane, explainScenePane;
    private Label welcomeText, gameTitle;
    private Button playButton;
    private Button nextButton;
    private Label lblName;
    private Label lblPlayer1;
    private Label lblPlayer2;
    private TextField txtPlayer1;
    private TextField txtPlayer2;

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
        //primaryStage.show();
        showSetNameScene();

    }

    /**
     * Wechselt zur SetNameScene
     */
    public void showSetNameScene(){
        nextButton = new Button("Next");
        lblName = new Label("Set your Names Players");
        lblPlayer1= new Label("Player 1: ");
        lblPlayer2= new Label("Player 2: ");
        txtPlayer1= new TextField();
        txtPlayer2= new TextField();
        setNameScenePane = new GridPane();
        setNameScenePane.add(lblName,0,0);
        setNameScene = new Scene(setNameScenePane,300,150);
        primarystage.setScene(setNameScene);
        primarystage.show();
    }
    //Hanlde Methode für Buttonactions
    @Override
    public void handle(ActionEvent event) {
        //To Do
        if(event.getSource()==playButton){
            showSetNameScene();
        }
    }
}
