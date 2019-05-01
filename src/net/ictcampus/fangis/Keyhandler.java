package net.ictcampus.fangis;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
     * @param e Event listener
     */
    @Override
    public void handle(KeyEvent e) {
        switch (e.getCode()) {
            case UP:
//                th00 = new aniThreads("up", gui);
//                th00.start();
                gui.escaper.moveUp();
                latestkey = UP;
                break;
            case DOWN:
//                th01 = new aniThreads("down", gui);
//                th01.start();
                gui.escaper.moveDown();
                latestkey = DOWN;
                break;
            case LEFT:
//                th02 = new aniThreads("left", gui);
//                th02.start();
                gui.escaper.moveLeft();
                latestkey = LEFT;
                break;
            case RIGHT:
//                th03 = new aniThreads("right", gui);
//                th03.start();
                gui.escaper.moveRight();
                latestkey = RIGHT;
                break;
            case W:
//                th04 = new aniThreads("w", gui);
//                th04.start();
                gui.catcher.moveUp();
                latestkey = W;
                break;
            case A:
//                th05 = new aniThreads("a", gui);
//                th05.start();
                gui.catcher.moveLeft();
                latestkey = A;
                break;
            case D:
//                th06 = new aniThreads("d", gui);
//                th06.start();
                gui.catcher.moveRight();
                latestkey = D;
                break;
            case S:
//                th07 = new aniThreads("s", gui);
//                th07.start();
                gui.catcher.moveDown();
                latestkey = S;
                break;
            case B:
                con.ani.stop();
                gui.buildWelcomeScreen();
                latestkey = B;
                break;
            case R:
                gui.throwBanana(gui.catcher.getTranslateX()-gui.catcher.getRadiusX()*3,gui.catcher.getTranslateY());
                latestkey = R;
                break;
            case NUMPAD0:
                gui.throwBanana(gui.escaper.getTranslateX()-gui.escaper.getRadiusX()*3,gui.escaper.getTranslateY());
                latestkey = NUMPAD0;
                break;
            default:
                break;
        }
    }
}
