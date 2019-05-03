package net.ictcampus.fangis;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameObject extends Rectangle {

    /**
     * Constructor for the Game Objects
     *
     * @param x     X Position
     * @param y     Y Position
     * @param w     Width
     * @param h     Height
     * @param color Color
     */
    public GameObject(int x, int y, int w, int h, Color color) {
        super(w, h, color);
        setX(x);
        setY(y);
    }


}
