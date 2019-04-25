package net.ictcampus.fangis;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class aniThreads extends Thread {

    //Instancevariabels
    private AnimationTimer ani;
    private Controller con;
    private GameGui gui;
    private Keyhandler handler;

    public aniThreads(Controller con, GameGui gui) {
        this.con = con;
        this.gui = gui;
    }

    public void run() {
        handler = new Keyhandler(gui ,con);
        ani = new AnimationTimer() {
            @Override
            public void handle(long now) {
                con.keyboardNode.setOnKeyPressed(e -> handler.handle(e));
            }
        };
        ani.start();
    }
}