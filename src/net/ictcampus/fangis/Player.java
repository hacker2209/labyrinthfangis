package net.ictcampus.fangis;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class Player extends Arc {
    final String playerName;
    private String playerRoll;
    protected boolean catched = false;
    protected boolean moveUpStatus = true;
    protected boolean moveDownStatus = true;
    protected boolean moveLeftStatus = true;
    protected boolean moveRightStatus = true;

    //Constructor for Playerclass
    public Player(int x, int y, String playerName, String playerRoll, Color color, double CenterX, double CenterY, double RadiusX, double RadiusY, double StartAngle, double ArcLenght) {
        //For Rectangle
        super(CenterX, CenterY, RadiusX, RadiusY, StartAngle, ArcLenght);
        super.setType(ArcType.ROUND);
        super.setFill(color);
        //Instancevariabels
        this.playerName = playerName;
        this.playerRoll = playerRoll;
        //Put Player on position
        setTranslateX(x);
        setTranslateY(y);

    }

    public void catched() {
        catched = true;
    }

    //Spieler bewegen
    public void moveLeft() {
        if (moveLeftStatus) {
            if (playerRoll.equals("catcher")) {
                setTranslateX(getTranslateX() - 15);
            } else {
                setTranslateX(getTranslateX() - 14);
            }
        }
    }
    public void moveRight() {
        if (moveRightStatus) {
            if (playerRoll.equals("catcher")) {
                setTranslateX(getTranslateX() + 14);
            } else {
                setTranslateX(getTranslateX() + 15);
            }
        }
    }
    public void moveUp() {
        if (moveUpStatus) {
            if (playerRoll.equals("catcher")) {
                setTranslateY(getTranslateY() - 14);
            } else {
                setTranslateY(getTranslateY() - 15);
            }
        }
    }
    public void moveDown() {
        if (moveDownStatus) {
            if (playerRoll.equals("catcher")) {
                setTranslateY(getTranslateY() + 15);
            } else {
                setTranslateY(getTranslateY() + 14);
            }
        }
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
