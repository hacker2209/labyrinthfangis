package net.ictcampus.fangis;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import net.ictcampus.db.ScoreJDBCDao;

import java.sql.Time;

import java.util.ArrayList;
import java.util.List;

public class checkCollision extends Thread {

    private Controller con;
    private GameGui gui;
    private boolean done = false;
    private AnimationTimer animationTimer;
//    private ScoreJDBCDao db;

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
                        /**
                         * Check Player Coliision
                         */
                        if (con.catcher.getBoundsInParent().intersects(con.escaper.getBoundsInParent())) {
                            terminate();
                        }
                        /**
                         * Check if Player is near the Wall and look that he cannont break out of the wall
                         */
                        if (con.escaper.getTranslateX() <= 15) {
                            con.escaper.moveLeftStatus = false;
                            System.out.println("Escaper hat gerade Linke Wand verlassen wollen");
                        } else if (con.escaper.getTranslateX() >= 5) {
                            con.escaper.moveLeftStatus = true;
                        }
                        if (con.escaper.getTranslateX() >= (int) gui.gameFieldPane.getMaxWidth() - 20) {
                            con.escaper.moveRightStatus = false;
                            System.out.println("Escaper hat gerade Rechte Wand verlassen wollen");
                        } else if (con.escaper.getTranslateX() <= (int) gui.gameFieldPane.getMaxWidth() - 10) {
                            con.escaper.moveRightStatus = true;
                        }
                        if (con.escaper.getTranslateY() >= (int) gui.gameFieldPane.getMinHeight() - 20) {
                            con.escaper.moveDownStatus = false;
                            System.out.println("Escaper hat gerade untere Wand verlassen wollen");
                        } else if (con.escaper.getTranslateY() <= (int) gui.gameFieldPane.getMinHeight() - 10) {
                            con.escaper.moveDownStatus = true;
                        }
                        if (con.escaper.getTranslateY() <= 15) {
                            con.escaper.moveUpStatus = false;
                            System.out.println("Escaper hat gerade Obere Wand verlassen wollen");
                        } else if (con.escaper.getTranslateY() >= 5) {
                            con.escaper.moveUpStatus = true;
                        }

                        //Same for Catcher
                        if (con.catcher.getTranslateX() <= 15) {
                            con.catcher.moveLeftStatus = false;
                            System.out.println("Catcher hat gerade Linke Wand verlassen wollen");
                        } else if (con.catcher.getTranslateX() >= 5) {
                            con.catcher.moveLeftStatus = true;
                        }
                        if (con.catcher.getTranslateX() >= (int) gui.gameFieldPane.getMaxWidth() - 15) {
                            con.catcher.moveRightStatus = false;
                            System.out.println("Catcher hat gerade Rechte Wand verlassen wollen");
                        } else if (con.catcher.getTranslateX() <= (int) gui.gameFieldPane.getMaxWidth() - 10) {
                            con.catcher.moveRightStatus = true;
                        }
                        if (con.catcher.getTranslateY() >= (int) gui.gameFieldPane.getMinHeight() - 20) {
                            con.catcher.moveDownStatus = false;
                            System.out.println("Catcher hat gerade untere Wand verlassen wollen");
                        } else if (con.catcher.getTranslateY() <= (int) gui.gameFieldPane.getMinHeight() - 10) {
                            con.catcher.moveDownStatus = true;
                        }
                        if (con.catcher.getTranslateY() <= 15) {
                            con.catcher.moveUpStatus = false;
                            System.out.println("Catcher hat gerade Obere Wand verlassen wollen");
                        } else if (con.catcher.getTranslateY() >= 5) {
                            con.catcher.moveUpStatus = true;
                        }
                    }
                };
                animationTimer.start();

            }
        });
    }

    private void terminate() {
//        db = new ScoreJDBCDao();
        gui.gameTimer.stopTimer();
        Time score = Time.valueOf("24:" + gui.gameTimer.getScoreTime());
        //System.out.println("Zeit: "+score);
//        db.insertScore(con.catcher.getPlayerName(), score, 1);
        //System.out.println("Name: "+con.catcher.getPlayerName());
        con.escaper.catched();
        con.ani.stop();
        animationTimer.stop();
        gui.buildGameOverScreen();

    }
}
