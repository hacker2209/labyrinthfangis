package net.ictcampus.fangis;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class GameObject extends Rectangle{

    public GameObject(int width, int height, Color color) {
        super(width, height, color);

    }

    public void  randomPosition{
        Random rand = new Random();
        int x = rand.nextInt(900);
        int y = rand.nextInt(500);
        setTranslateX(x);
        setTranslateY(y);
    }


}
