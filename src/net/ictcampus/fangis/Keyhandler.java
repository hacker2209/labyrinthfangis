package net.ictcampus.fangis;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.*;

public class Keyhandler implements EventHandler<KeyEvent> {
    public GameGui gui;
    private Controller con;
    private aniThreads th00, th01, th02, th03, th04, th05, th06, th07;
    protected KeyCode latestkey;

    public Keyhandler(GameGui gui, Controller con) {
        this.gui = gui;
        this.con = con;
    }

    public void releasehandle(KeyEvent e) {
        switch (e.getCode()) {
            case UP:
                th00.terminate();
                break;
            case DOWN:
                th01.terminate();
                break;
            case LEFT:
                th02.terminate();
                break;
            case RIGHT:
                th03.terminate();
                break;
            case W:
                th04.terminate();
                break;
            case A:
                th05.terminate();
                break;
            case D:
                th06.terminate();
                break;
            case S:
                th07.terminate();
                break;
            default:
                break;

        }
    }

    /**
     * Listener for Key presses to steer the Players
     *
     * @param e Event listener
     */
    @Override
    public void handle(KeyEvent e) {
        switch (e.getCode()) {
            case UP:
//                th00 = new aniThreads("up", gui);
//                th00.start();
//                if (checkIfFieldIsFree("escaper")) {
                    gui.escaper.moveUp();
                    latestkey = UP;
//                }
                break;
            case DOWN:
//                th01 = new aniThreads("down", gui);
//                th01.start();
//                if (checkIfFieldIsFree("escaper")) {
                    gui.escaper.moveDown();
                    latestkey = DOWN;
//                }
                break;
            case LEFT:
//                th02 = new aniThreads("left", gui);
//                th02.start();
//                if (checkIfFieldIsFree("escaper")) {
                    gui.escaper.moveLeft();
                    latestkey = LEFT;
//                }
                break;
            case RIGHT:
//                th03 = new aniThreads("right", gui);
//                th03.start();
//                if (checkIfFieldIsFree("escaper")) {
                    gui.escaper.moveRight();
                    latestkey = RIGHT;
//                }
                break;
            case W:
//                th04 = new aniThreads("w", gui);
//                th04.start();
//                if (checkIfFieldIsFree("catcher")) {
                    gui.catcher.moveUp();
                    latestkey = W;
//                }
                break;
            case A:
//                th05 = new aniThreads("a", gui);
//                th05.start();
//                if (checkIfFieldIsFree("catcher")) {
                    gui.catcher.moveLeft();
                    latestkey = A;
//                }
                break;
            case D:
//                th06 = new aniThreads("d", gui);
//                th06.start();
//                if (checkIfFieldIsFree("catcher")) {
                    gui.catcher.moveRight();
                    latestkey = D;
//                }
                break;
            case S:
//                th07 = new aniThreads("s", gui);
//                th07.start();
//                if (checkIfFieldIsFree("catcher")) {
                    gui.catcher.moveDown();
                    latestkey = S;
//                }
                break;
            case B:
                con.ani.stop();
                gui.buildWelcomeScreen();
                latestkey = B;
                break;
            case R:
                gui.throwBanana(gui.catcher.getTranslateX() - gui.catcher.getRadiusX() * 3, gui.catcher.getTranslateY());
                latestkey = R;
                break;
            case NUMPAD0:
                gui.throwBanana(gui.escaper.getTranslateX() - gui.escaper.getRadiusX() * 3, gui.escaper.getTranslateY());
                latestkey = NUMPAD0;
                break;
            default:
                break;
        }
    }

    private boolean checkIfFieldIsFree(String player) {
        boolean permisson = false;
        for (GameObject obj : con.gobi.obstacles) {
            //Eckpunkte für x und y Koordinaten holen
            int obenlinksx = (int) obj.getX() - 10;
            int obenrechtsx = (int) obj.getX() + (int) obj.getWidth() + 10;
            int obenlinksy = (int) obj.getY() - 10;
            int untenlinksy = (int) obj.getY() + (int) obj.getHeight() + 10;
            int obenrechtsy = (int) obj.getY();
            int untenlinksx = (int) obj.getX();
            int untenrechtsx = (int) obj.getX() + (int) obj.getWidth();
            int untenrechtsy = (int) obj.getY() + (int) obj.getHeight();

            //Koordinaten des Spielers vernünftig abspeichern
            int xesc = (int) con.escaper.getTranslateX();
            int yesc = (int) con.escaper.getTranslateY();
            int xcat = (int) con.catcher.getTranslateX();
            int ycat = (int) con.catcher.getTranslateY();

            //Listen mit x und y Werten des Objekts machen
            List<Integer> xwerte = makeRange(obenlinksx, obenrechtsx);
            List<Integer> ywerte = makeRange(obenlinksy, untenlinksy);

            //Decide which Player ask for MovePermisson
            if (player.equals("catcher")) {
                if ((xwerte.contains(xcat)) && ywerte.contains(ycat)) {
                    System.out.println("Oh jetzt hat der Catcher ein Object berührt");

//                if (xesc <= obenlinksx + 15 && ywerte.contains(yesc)) {
//                    con.catcher.moveDownStatus = false;
//                } else if (xesc >= untenlinksx - 15 && ywerte.contains(yesc)) {
//                    con.catcher.moveUpStatus = false;
//                } else if (yesc <= obenlinksy + 15 && xwerte.contains(xesc)) {
//                    con.catcher.moveRightStatus = false;
//                } else if (yesc >= untenrechtsy - 15 && xwerte.contains(xesc)) {
//                    con.catcher.moveLeftStatus = false;
//                }
                permisson = false;
                } else {
                    permisson = true;
                }
            }

            if (player.equals("escaper")) {
                if ((xwerte.contains(xcat)) && ywerte.contains(ycat)) {
                    System.out.println("Oh jetzt hat der Escaper ein Object berührt");

//                if (xcat <= obenlinksx + 15 && ywerte.contains(ycat)) {
//                    con.escaper.moveDownStatus = false;
//                } else if (xcat >= untenlinksx - 15 && ywerte.contains(ycat)) {
//                    con.escaper.moveUpStatus = false;
//                } else if (ycat <= obenlinksy + 15 && xwerte.contains(xcat)) {
//                    con.escaper.moveRightStatus = false;
//                } else if (ycat >= untenrechtsy - 15 && xwerte.contains(xcat)) {
//                    con.escaper.moveLeftStatus = false;
//                }
                    permisson = false;
                } else {
                    permisson = true;
                }
            }
        }
        return permisson;
    }

    private List<Integer> makeRange(int min, int max) {
        List<Integer> range = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            range.add(i);
        }
        return range;
    }
}
