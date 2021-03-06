package net.ictcampus.fangis;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class gameObejctGenerator {

    private List<Integer> widths = new ArrayList();
    private List<Integer> heights = new ArrayList();
    protected List<GameObject> obstacles = new ArrayList();
    private Random rand = new Random();
    private int[] dims;
    private Controller con;

    public gameObejctGenerator(Controller con) {
        this.con = con;
    }


    /**
     * Generates random Objects
     *
     * @param anzahl number of GameObjects
     */
    public void createObstacles(int anzahl) {
        fillDimensions();
        //Create Objects
        for (int i = 0; i < anzahl; i++) {
            int[] obdims = getRandomdimensions();
            int x = randomXPosition();
            int y = randomYPosition();
            GameObject obstacle = new GameObject(x, y, obdims[0], obdims[1], Color.BLACK);
            obstacles.add(obstacle);
        }
    }

    /**
     * Generates the random X Position
     *
     * @return Random X Position
     */
    public int randomXPosition() {
        boolean status = false;
        int width = (1000 - Collections.max(widths));
        int x = rand.nextInt(width);

        //Get Position of Players
        int xcat = (int) con.catcher.getTranslateX();
        int xesc = (int) con.catcher.getTranslateX();
        //Make Range with +/- 10
        List<Integer> xcatrange = forLoopRange((xcat - 10), 20);
        List<Integer> xescrange = forLoopRange((xesc - 10), 20);

        while (!status) {
            x = rand.nextInt(width);
            //Check if my y is in one of this ranges
            if (!xcatrange.contains(x) && !xescrange.contains(x)) {
                status = true;
            }
        }
        return x;
    }

    /**
     * Generates the random Y Position
     *
     * @return Random Y Position
     */
    public int randomYPosition() {
        boolean status = false;
        int height = (600 - Collections.max(heights));
        int y = rand.nextInt(height);
        //Get Position of Players
        int ycat = (int) con.catcher.getTranslateY();
        int yesc = (int) con.catcher.getTranslateY();
        //Make Range with +/- 10
        List<Integer> ycatrange = forLoopRange((ycat - 10), 20);
        List<Integer> yescrange = forLoopRange((yesc - 10), 20);
        while (!status) {
            y = rand.nextInt(height);
            //Check if my y is in one of this ranges
            if (!ycatrange.contains(y) && !yescrange.contains(y)) {
                status = true;
            }
        }
        return y;
    }

    /**
     * Fills a List with width and height
     */
    public void fillDimensions() {
        widths.add(100);
        widths.add(80);
        widths.add(50);
        widths.add(20);
        heights.add(20);
        heights.add(40);
        heights.add(80);
        heights.add(35);
    }

    /**
     * Takes a random Width and Height out of a list
     *
     * @return Random Width and Height
     */
    public int[] getRandomdimensions() {
        dims = new int[2];
        dims[0] = widths.get(rand.nextInt(widths.size()));
        dims[1] = heights.get(rand.nextInt(widths.size()));
        return dims;
    }

    /**
     * List of Ranges with a Limit
     *
     * @param from  Range start
     * @param limit Range limit
     * @return generated Range
     */
    private List<Integer> forLoopRange(int from, int limit) {
        List<Integer> numbers = new ArrayList<>(limit);
        for (int to = from + limit; from < to; ++from) {
            numbers.add(from);
        }
        return numbers;
    }
}
