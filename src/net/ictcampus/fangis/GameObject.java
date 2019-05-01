package net.ictcampus.fangis;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class GameObject extends Rectangle{

    /**
     * Constructor for the Game Objects
     * @param x X Position
     * @param y Y Position
     * @param w Width
     * @param h Height
     * @param color Color
     */
    public GameObject(int x, int y,int w, int h, Color color) {
        super(w,h,color);
        setX(x);
        setY(y);
      //  setTranslateX(x);
        //setTranslateY(y);
    }


}
