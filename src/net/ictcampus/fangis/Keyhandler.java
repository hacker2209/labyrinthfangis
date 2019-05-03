package net.ictcampus.fangis;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class Keyhandler implements EventHandler<KeyEvent> {
    public GameGui gui;
    private Controller con;
    protected KeyCode latestkey;

    public Keyhandler(GameGui gui, Controller con) {
        this.gui = gui;
        this.con = con;
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
                gui.escaper.moveUp();
                if (!checkIfFieldIsFree("escaper")) {
                    gui.escaper.setTranslateY(gui.escaper.getTranslateY() + 20);
                }
                break;
            case DOWN:
                gui.escaper.moveDown();
                if (!checkIfFieldIsFree("escaper")) {
                    gui.escaper.setTranslateY(gui.escaper.getTranslateY() - 20);
                }
                break;
            case LEFT:
                gui.escaper.moveLeft();
                if (!checkIfFieldIsFree("escaper")) {
                    gui.escaper.setTranslateX(gui.escaper.getTranslateX() + 20);
                }
                break;
            case RIGHT:
                gui.escaper.moveRight();
                if (!checkIfFieldIsFree("escaper")) {
                    gui.escaper.setTranslateX(gui.escaper.getTranslateX() - 20);
                }
                break;
            case W:
                gui.catcher.moveUp();
                if (!checkIfFieldIsFree("catcher")) {
                    gui.catcher.setTranslateY(gui.catcher.getTranslateY() + 20);
                }
                break;
            case A:
                gui.catcher.moveLeft();
                if (!checkIfFieldIsFree("catcher")) {
                    gui.catcher.setTranslateX(gui.catcher.getTranslateX() + 20);
                }
                break;
            case D:
                gui.catcher.moveRight();
                if (!checkIfFieldIsFree("catcher")) {
                    gui.catcher.setTranslateX(gui.catcher.getTranslateX() - 20);
                }
                break;
            case S:
                gui.catcher.moveDown();
                if (!checkIfFieldIsFree("catcher")) {
                    gui.catcher.setTranslateY(gui.catcher.getTranslateY() - 20);
                }
                break;
            case B:
                con.ani.stop();
                gui.buildWelcomeScreen();
                break;
            case R:
                gui.throwBanana(gui.catcher.getTranslateX() - gui.catcher.getRadiusX() * 3, gui.catcher.getTranslateY());
                break;
            case NUMPAD0:
                gui.throwBanana(gui.escaper.getTranslateX() - gui.escaper.getRadiusX() * 3, gui.escaper.getTranslateY());
                break;
            default:
                break;
        }
    }

    private boolean checkIfFieldIsFree(String player) {
        //Koordinaten des Spielers vernünftig abspeichern
        int xesc = (int) con.escaper.getTranslateX();
        int yesc = (int) con.escaper.getTranslateY();
        int xcat = (int) con.catcher.getTranslateX();
        int ycat = (int) con.catcher.getTranslateY();
        boolean permisson = true;
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


            //Listen mit x und y Werten des Objekts machen
            List<Integer> xwerte = makeRange(obenlinksx, obenrechtsx);
            List<Integer> ywerte = makeRange(obenlinksy, untenlinksy);

            //Decide which Player ask for MovePermisson
            if (player.equals("catcher")) {
                if ((xwerte.contains(xcat)) && ywerte.contains(ycat)) {
                    System.out.println("Oh jetzt hat der Catcher ein Object berührt");
                    permisson = false;
                }
            }

            if (player.equals("escaper")) {
                if ((xwerte.contains(xesc)) && ywerte.contains(yesc)) {
                    System.out.println("Oh jetzt hat der Escaper ein Object berührt");
                    permisson = false;
                }
            }
        }

        if (!gui.bananas.isEmpty()) {
            for (Label bani : gui.bananas) {
                //Eckpunkte für x und y Koordinaten holen

                if (player.equals("catcher")) {
                    if (bani.getBoundsInParent().intersects(gui.catcher.getBoundsInParent())) {
                        permisson = false;
                    }
                }

                if (player.equals("escaper")) {
                    if (bani.getBoundsInParent().intersects(gui.escaper.getBoundsInParent())) {
                        permisson = false;
                    }
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
