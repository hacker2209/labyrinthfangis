package net.ictcampus.fangis;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;

public class checkCollision extends Thread {

    private Controller con;
    private GameGui gui;
    private boolean done = false;
    private AnimationTimer animationTimer;

    public checkCollision(Controller con, GameGui gui) {
        this.con = con;
        this.gui = gui;
    }

    public void run() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                animationTimer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        if (con.catcher.getBoundsInParent().intersects(con.escaper.getBoundsInParent()))  {
                            terminate();
                        }
                        else if (con.escaper.getTranslateX() <= 10) {
                            con.escaper.moveLeftStatus = false;
                        }
                        else if(con.escaper.getTranslateX() >= 5){
                            con.escaper.moveLeftStatus = true;
                        }
                        else if (con.escaper.getTranslateX() >= gui.gameFieldPane.getMaxWidth() - 10) {
                            con.escaper.moveLeftStatus = false;
                        }
                        else if(con.escaper.getTranslateX() >= 5){
                            con.escaper.moveLeftStatus = true;
                        }

                    }
                };
                animationTimer.start();

            }
        });
    }



    private void terminate() {
        con.gameTimer.stopTimer();
        con.escaper.catched();
        con.ani.stop();
        animationTimer.stop();
        gui.buildGameOverScreen();

    }
}
