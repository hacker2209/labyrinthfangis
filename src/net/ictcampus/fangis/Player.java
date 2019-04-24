package net.ictcampus.fangis;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends Rectangle {
    final String playerName;
    private String playerRoll;

    //Constructor for Playerclass
    public Player(int x, int y, int w, int h, String playerName, String playerRoll, Color color) {
        //For Rectangle
        super(w, h, color);

        //Instancevariabels
        this.playerName = playerName;
        this.playerRoll = playerRoll;

        //Put Player on position
        setTranslateX(x);
        setTranslateY(y);

    }

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

    }


    //------------------------------ Getter & Setter --------------------------------------------

