package net.ictcampus.fangis;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class aniThreads extends Thread {

    private String direction;
    private GameGui gui;
    protected boolean done = true;


    public aniThreads(String direction, GameGui gui) {
        this.direction = direction;
        this.gui = gui;

    }

    public void run() {
        while(done) {
            switch (direction) {
                case "up":
                    gui.escaper.moveUp();
                    break;
                case "down":
                    gui.escaper.moveDown();
                    break;
                case "left":
                    gui.escaper.moveLeft();
                    break;
                case "right":
                    gui.escaper.moveRight();
                    break;
                case "a":
                    gui.catcher.moveLeft();
                    break;
                case "s":
                    gui.catcher.moveDown();
                    break;
                case "d":
                    gui.catcher.moveRight();
                    break;
                case "w":
                    gui.catcher.moveUp();
                    break;
                    default:
                        break;
            }
        }
    }

    public void terminate() {
        done = false;
    }
}