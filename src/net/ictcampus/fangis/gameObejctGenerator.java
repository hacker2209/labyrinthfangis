package net.ictcampus.fangis;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class gameObejctGenerator {

    private List<Integer> widths = new ArrayList();
    protected List<GameObject> obstacles = new ArrayList();
    private int height;
    private Random rand = new Random();
    private int[] dims;
    private GameGui gui;

    public gameObejctGenerator(GameGui gui) {
        this.gui = gui;
    }

    //Create random GameObjects
    public void createObstacle(int anzahl) {
        fillDimensions();
        //Create Objects
        for (int i = 0; i < anzahl; i++){
            int[] obdims = getRandomdimensions();
            int x = randomXPosition();
            int y = randomYPosition();
            GameObject obstacle = new GameObject(x,y,obdims[0], obdims[1], Color.GRAY);
            obstacles.add(obstacle);
        }
    }

    public int  randomXPosition(){
        int width = 1000;
        int x = rand.nextInt(width);
        return x;
    }
    public int randomYPosition(){
        int height = 600;
        int y = rand.nextInt(height);
        return y;
    }

    public void fillDimensions() {
        widths.add(100);
        widths.add(80);
        widths.add(50);
        widths.add(20);
        height = 30;
    }

    public int[] getRandomdimensions() {
        dims = new int[2];
        dims[0] = widths.get(rand.nextInt(widths.size()));
        dims[1] = height;
        return dims;
    }
}
