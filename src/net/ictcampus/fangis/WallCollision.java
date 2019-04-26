package net.ictcampus.fangis;

import javafx.application.Platform;

public class WallCollision extends Thread {
    GameGui gui;
    Controller con;

    public WallCollision(Controller con, GameGui gui) {
        this.con = con;
        this.gui = gui;
    }

    @Override
    public void run() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (con.escaper.getTranslateX() < 0 || con.escaper.getTranslateY()>0) {


                }
                else if(con.escaper.getTranslateX() < 0 || con.escaper.getTranslateY()>0){

                }

            }
        });
    }
}
