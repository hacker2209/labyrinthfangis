package net.ictcampus.fangis;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import javax.xml.transform.sax.SAXSource;
import java.security.Key;

public class Keyhandler implements EventHandler<KeyEvent> {
    public GameGui gui;

    public Keyhandler(GameGui gui) {
        this.gui = gui;
    }

    @Override
    public void handle(KeyEvent e) {
        switch (e.getCode()) {
            case UP:
                gui.escaper.moveUp();
                System.out.println("Up");
                break;
            case DOWN:
                gui.escaper.moveDown();
                System.out.println("Down");
                break;
            case LEFT:
                gui.escaper.moveLeft();
                System.out.println("Left");
                break;
            case RIGHT:
                gui.escaper.moveRight();
                System.out.println("Right");
                break;
        }
    }
}