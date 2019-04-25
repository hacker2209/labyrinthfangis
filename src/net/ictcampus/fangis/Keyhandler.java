package net.ictcampus.fangis;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import javax.xml.transform.sax.SAXSource;
import java.security.Key;

public class Keyhandler implements EventHandler<KeyEvent> {
    public GameGui gui;
    private Controller con;

    public Keyhandler(GameGui gui, Controller con) {
        this.gui = gui;
        this.con = con;
    }

    @Override
    public void handle(KeyEvent e) {
        switch (e.getCode()) {
            case UP:
                gui.escaper.moveUp();
                break;
            case DOWN:
                gui.escaper.moveDown();
                break;
            case LEFT:
                gui.escaper.moveLeft();
                break;
            case RIGHT:
                gui.escaper.moveRight();
                break;
            case W:
                gui.catcher.moveUp();
                break;
            case A:
                gui.catcher.moveLeft();
                break;
            case D:
                gui.catcher.moveRight();
                break;
            case S:
                gui.catcher.moveDown();
                break;
            case B:
                con.anicatcher.stop();
                con.aniescaper.stop();
                gui.buildWelcomeScreen();
        }
    }
}