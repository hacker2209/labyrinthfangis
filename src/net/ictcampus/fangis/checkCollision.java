package net.ictcampus.fangis;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Group;

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
                        int caty = (int) con.catcher.getTranslateY();
                        int catx = (int) con.catcher.getTranslateX();
                        int escy = (int) con.escaper.getTranslateY();
                        int escx = (int) con.escaper.getTranslateX();
                        //gui.lblTimer.setText("Catcher Y: " + caty + "Catcher X: " + catx + "Escaper Y: " + escy + "Escaper X: " + escx);
                        if (con.catcher.getBoundsInParent().intersects(con.escaper.getBoundsInParent()))  {
                            terminate();
                        }
                        else if (con.escaper.getTranslateX() < 0 || con.escaper.getTranslateY()>0) {


                        }
                        else if(con.escaper.getTranslateX() < 0 || con.escaper.getTranslateY()>0){

                        }
                    }
                };
                animationTimer.start();

            }
        });
    }



    private void terminate() {
        con.escaper.catched();
        con.ani.stop();
        animationTimer.stop();
        gui.buildGameOverScreen();

    }
}
