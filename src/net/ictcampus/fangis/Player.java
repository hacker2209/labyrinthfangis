package net.ictcampus.fangis;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class Player extends Arc {
    final String playerName;
    private String playerRoll;

    //Constructor for Playerclass
    public Player(int x, int y, String playerName, String playerRoll, Color color, double CenterX, double CenterY, double RadiusX, double RadiusY, double StartAngle, double ArcLenght) {
        //For Rectangle
        super(CenterX, CenterY, RadiusX, RadiusY, StartAngle, ArcLenght);
        super.setType(ArcType.ROUND);
        //Instancevariabels
        this.playerName = playerName;
        this.playerRoll = playerRoll;
        //Put Player on position
        setTranslateX(x);
        setTranslateY(y);

    }

    //Spieler bewegen
    public void moveLeft() {
        setTranslateX(getTranslateX() - 5);
    }
    public void moveRight() {
        setTranslateX(getTranslateX() + 5);
    }
    public void moveUp() {
        setTranslateY(getTranslateY() - 5);
    }
    public void moveDown() {
        setTranslateY(getTranslateY() + 5);
    }



    //------------------------------ Getter & Setter --------------------------------------------

    public String getPlayerName() {
        return playerName;
    }
    public String getPlayerRoll() {
        return playerRoll;
    }
    public void setPlayerRoll(String playerRoll) {
        this.playerRoll = playerRoll;
    }






}
