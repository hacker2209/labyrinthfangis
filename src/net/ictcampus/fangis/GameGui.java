package net.ictcampus.fangis;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class GameGui {

    //Instancevariabels for all Scenes
    protected Controller con;
    protected Stage primarystage;
    protected Scene setNameScene, explainScene, welcomeScene, gameScene;
    protected BorderPane welcomeScenePane;
    protected GridPane setNameScenePane, explainScenePane, gameRasterPane;
    protected Pane gameFieldPane;

    //Instancevariabels for explainScene
    protected Label explainTitle, catcherExplanation, escaperExplanation, catchername, escapername;
    protected Button gameStart;

    //Instancevariables for welcomeScene
    protected Label welcomeText, gameTitle;
    protected Button playButton;

    //Instancevariabels for setNameScene
    protected Button nextButton;
    protected Label lblName, lblPlayer1, lblPlayer2, lblErrorMessage, lblNothing;
    protected TextField txtPlayer1, txtPlayer2;

    //Instancevariabels for gameField
    protected Label lblScore, lblTimer, lblBanana;
    protected Button abrButton;
    protected Box keyboardNode;
    protected Player catcher, escaper;

    public GameGui(Stage primarystage, Button playButton, Button nextButton, Button abrButton, Button gameStart, Box keyboardNode, Controller con) {
        this.primarystage = primarystage;
        this.playButton = playButton;
        this.nextButton = nextButton;
        this.abrButton = abrButton;
        this.gameStart = gameStart;
        this.keyboardNode = keyboardNode;
        this.con = con;
    }

    public void buildWelcomeScreen() {
        welcomeScenePane = new BorderPane();
        welcomeScene = new Scene(welcomeScenePane, 300, 160);
        //Create Nodes for welcomeScene
        welcomeText = new Label("Welcome to our Labyrinth-Fanigs Game!\nThis is a simple Game\nmade by zauggmo and Technat314");
        gameTitle = new Label("Labyrinth-Fangis");

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



    //    public void buildWelcomeScene() {
//    }
    public void buildExplainScreen() {
        explainScenePane = new GridPane();
        explainScene = new Scene(explainScenePane, 400, 300);
        //Initialize Nodes for Grid
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
        //Show explainScene
        primarystage.setScene(explainScene);
        primarystage.show();
    }

    public void buildSetNameScreen() {
        setNameScenePane = new GridPane();
        setNameScene = new Scene(setNameScenePane, 300, 200);
        //Initialize Nodes for Grid
        lblName = new Label("Set your Names");
        lblPlayer1 = new Label("Player 1: ");
        lblPlayer2 = new Label("Player 2: ");
        txtPlayer1 = new TextField();
        txtPlayer2 = new TextField();
        lblErrorMessage = new Label("No valid Names!");
        lblNothing = new Label();
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
        //Show Scene
        primarystage.setScene(setNameScene);
        primarystage.show();
    }

    public void buildGameFieldScreen() {
        gameRasterPane = new GridPane();
        gameFieldPane = new Pane();
        gameScene = new Scene(gameRasterPane, 1000,600);
        gameFieldPane.setMaxWidth(1000.0);
        gameFieldPane.setMinHeight(400.0);
        //Initialize Nodes for Grid
        lblScore = new Label("The Score");
        lblTimer = new Label("3:00");
        //Grid Styling
        setNameScene.getStylesheets().add(getClass().getResource("gameField.css").toExternalForm());
        gameFieldPane.getStyleClass().add("pane");
        //Put Nodes on Raster
        gameRasterPane.add(gameFieldPane,0,0);
//        gameRasterPane.add(abrButton,0,1);
        gameRasterPane.add(lblScore,1,1);
        gameRasterPane.add(lblTimer, 2,1);
        //-------------Put nodes on Field
        gameFieldPane.getChildren().add(keyboardNode);
        //Make Players
        catcher = new Player(10,10, lblPlayer1.getText(),"catcher", Color.RED, 5, 5, 15,15,45,270);
        escaper = new Player(((int)gameFieldPane.getMaxWidth() - 50 ), 10, lblPlayer2.getText(), "escaper", Color.BLUE, 5,5,15,15,45,270);
        con.setPlayers(catcher, escaper);
        gameFieldPane.getChildren().add(escaper);
        gameFieldPane.getChildren().add(catcher);
        //Show Scene
        primarystage.setScene(gameScene);
        primarystage.show();
    }

    public void throwBanana(double x, double y){
        Image image = new Image(getClass().getResourceAsStream("img/banana.png"));
        ImageView banana = new ImageView(image);
        banana.setFitHeight(50);
        banana.setFitWidth(50);
        lblBanana = new Label();
        lblBanana.setGraphic(banana);
        gameFieldPane.getChildren().add(lblBanana);
        lblBanana.getStyleClass().add("banana");
        lblBanana.setMinWidth(10);
        lblBanana.setMinHeight(10);
        lblBanana.setMaxWidth(10);
        lblBanana.setMaxHeight(10);
        lblBanana.setTranslateX(x);
        lblBanana.setTranslateY(y);
    }
}

