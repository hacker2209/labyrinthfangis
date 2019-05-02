package net.ictcampus.fangis;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import net.ictcampus.db.ScoreJDBCDao;

import java.util.List;

public class GameGui {

    //Instancevariabels for all Scenes
    protected Controller con;
    protected Stage primarystage;
    protected Scene setNameScene, explainScene, welcomeScene, gameScene, gameOverScene;
    protected BorderPane welcomePane;
    protected GridPane setNameScenePane, explainScenePane, gameRasterPane, gameOverPane, scoreDataPane;
    protected Pane gameFieldPane;
    protected ScrollPane scorePane;

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
    protected GameTimer gameTimer;

    //Instancevariabels for gameOver
    protected Label gameOverText, gameOverTitle;
    protected Button gameQuitButton, gameAgainButton;

    public GameGui(Stage primarystage, Button playButton, Button nextButton, Button abrButton, Button gameStart, Box keyboardNode, Button gameQuitButton,Button gameAgainButton, Controller con) {
        this.primarystage = primarystage;
        this.playButton = playButton;
        this.nextButton = nextButton;
        this.abrButton = abrButton;
        this.gameStart = gameStart;
        this.keyboardNode = keyboardNode;
        this.gameQuitButton = gameQuitButton;
        this.con = con;
        this.gameAgainButton = gameAgainButton;
    }

    public void buildWelcomeScreen() {
        welcomePane = new BorderPane();
        welcomeScene = new Scene(welcomePane, 300, 160);
        //Create Nodes for welcomeScene
        welcomeText = new Label("Welcome to our Labyrinth-Fanigs Game!\nThis is a simple Game\nmade by zauggmo and Technat314");
        gameTitle = new Label("Labyrinth-Fangis");

        //Put Nodes on PaneT
        welcomePane.setTop(gameTitle);
        welcomePane.setBottom(playButton);
        welcomePane.setCenter(welcomeText);
        //Add some Style to welcomeScene
        welcomeScene.getStylesheets().add(getClass().getResource("css/welcomeScene.css").toExternalForm());
        gameTitle.getStyleClass().add("gameTitle");
        playButton.getStyleClass().add("playButton");
        welcomePane.getStyleClass().add("pane");
        welcomeText.getStyleClass().add("text");
        //Show welcomeScene
        primarystage.setTitle("Labyrinthfangis");
        Image icon = new Image(getClass().getResourceAsStream("img/maze.png"));
        primarystage.getIcons().add(icon);
        primarystage.setScene(welcomeScene);
        primarystage.show();
    }


    //    public void buildWelcomeScene() {
//    }
    public void buildExplainScreen() {
        explainScenePane = new GridPane();
        explainScene = new Scene(explainScenePane, 500, 300);
        //Initialize Nodes for Grid
        catchername = new Label(txtPlayer1.getText());
        escapername = new Label(txtPlayer2.getText());
        explainTitle = new Label("How it Works...");
        catcherExplanation = new Label("- Aim: catch him in 3 min \n- Controls: WASD \n- Throw Bananas: r");
        escaperExplanation = new Label("- Aim: escape while 3 min \n- Controls: Arrow-Keys \n- Throw Bananas: NumPad 0");
        GridPane.setColumnSpan(explainTitle, 2);
        //Put Nodes on Grid
        explainScenePane.add(explainTitle, 0, 0);
        explainScenePane.add(catchername, 0, 1);
        explainScenePane.add(escapername, 1, 1);
        explainScenePane.add(catcherExplanation, 0, 2);
        explainScenePane.add(escaperExplanation, 1, 2);
        explainScenePane.add(gameStart, 0, 3);
        GridPane.setColumnSpan(gameStart, 2);
        //Some styling for Grid
        explainScenePane.getStylesheets().add(getClass().getResource("css/explainScene.css").toExternalForm());
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
        setNameScene.getStylesheets().add(getClass().getResource("css/setNameScene.css").toExternalForm());
        lblName.getStyleClass().add("nameTitle");
        setNameScenePane.getStyleClass().add("pane");
        nextButton.getStyleClass().add("button");
        lblPlayer1.getStyleClass().add("player");
        lblPlayer2.getStyleClass().add("player");
        lblErrorMessage.getStyleClass().add("error");
        setNameScenePane.setVgap(10);
        setNameScenePane.setHgap(30);
        //Put Nodes into Grid
        setNameScenePane.add(lblName, 0, 0);
        setNameScenePane.setColumnSpan(lblName, 2);
        setNameScenePane.add(nextButton, 0, 3);
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


        gameScene = new Scene(gameRasterPane, 1000, 630);
        gameFieldPane.setMaxWidth(1000.0);
        gameFieldPane.setMinHeight(600.0);
        //Initialize Nodes for Grid
        lblTimer = new Label();
        //Grid Styling
        gameScene.getStylesheets().add(getClass().getResource("css/gameField.css").toExternalForm());
        gameFieldPane.getStyleClass().add("field");
        lblTimer.getStyleClass().add("timer");
        gameRasterPane.getStyleClass().add("grid");

        //Put Nodes on Raster
        gameRasterPane.add(gameFieldPane, 0, 0);
//        gameRasterPane.add(abrButton,0,1);
        gameRasterPane.add(lblTimer, 0, 1);
        //-------------Put nodes on Field
        gameFieldPane.getChildren().add(keyboardNode);
        //Make Players
        catcher = new Player(20, 20, txtPlayer1.getText(), "catcher", Color.RED, 5, 5, 15, 15, 45, 270);
        escaper = new Player(((int) gameFieldPane.getMaxWidth() - 100), 20, txtPlayer2.getText(), "escaper", Color.BLUE, 5, 5, 15, 15, 45, 270);
        con.setPlayers(catcher, escaper);
        gameFieldPane.getChildren().add(escaper);
        gameFieldPane.getChildren().add(catcher);
        //Show Scene
        primarystage.setScene(gameScene);
        gameTimer = new GameTimer();
        gameTimer.countStart(this);
        primarystage.show();
    }

    public void buildGameOverScreen() {
        int row = 0;
        gameOverPane = new GridPane();
        scoreDataPane = new GridPane();
        scorePane = new ScrollPane();
        gameOverScene = new Scene(gameOverPane, 320, 250);
        //Create Nodes for welcomeScene
        gameOverText = new Label("Tatata, the Game is over, \nthe Catcher won!");
        gameOverTitle = new Label("GameOver");
        ScoreJDBCDao db = new ScoreJDBCDao();
        //db.insertScore("a", Time.valueOf("01:01:20"),2);
        List<String> max = db.maxScore();
        for (String i : max) {
            lblScore = new Label();
            switch (row) {
                case 0:
                    lblScore.setTextFill(Color.web("#ffd700"));
                    break;
                case 1:
                    lblScore.setTextFill(Color.web("#C0C0C0"));
                    break;
                case 2:
                    lblScore.setTextFill(Color.web("#CD7F32"));
                    break;
            }
            lblScore.setText(row + 1 + ". Place: " + i);
            scoreDataPane.add(lblScore, 0, row);
            row++;
        }
        scorePane.setContent(scoreDataPane);
        //Put Nodes on PaneT
        gameOverPane.add(gameOverTitle, 0, 0);
        //gameOverPane.setBottom(gameQuitButton);
        gameOverPane.add(gameOverText, 0, 1);
        gameOverPane.add(scorePane, 0, 2);
        gameOverPane.add(gameQuitButton, 0, 3);
        gameOverPane.add(gameAgainButton,1,3);
        //Add some Style to welcomeScene
        gameOverScene.getStylesheets().add(getClass().getResource("css/gameOverScene.css").toExternalForm());
        gameOverTitle.getStyleClass().add("gameOverTitle");
        gameQuitButton.getStyleClass().add("gameQuitButton");
        gameAgainButton.getStyleClass().add("gameQuitButton");
        gameOverPane.getStyleClass().add("pane");
        gameOverText.getStyleClass().add("gameOvertext");
        lblScore.getStyleClass().add("scoreText");
        lblScore.setStyle("-fx-font-family: Courier New, Courier, monospace;");
        gameOverPane.setVgap(10);
        scorePane.setMinHeight(100);
        gameOverPane.setColumnSpan(scorePane,2);
        //Show welcomeScene
        primarystage.setScene(gameOverScene);
        primarystage.show();
    }

    public void throwBanana(double x, double y) {
        Image image = new Image(getClass().getResourceAsStream("img/banana.png"));
        ImageView banana = new ImageView(image);
        banana.setFitHeight(30);
        banana.setFitWidth(30);
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

