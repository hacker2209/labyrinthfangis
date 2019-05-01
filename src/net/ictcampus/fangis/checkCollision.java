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
    private ScoreJDBCDao db;

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
                        checkGameObjectCollision();

                    }
                };
                animationTimer.start();

            }
        });
    }

    private void checkGameObjectCollision() {
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

            //Koordinaten des Spielers vernünftig abspeichern
            int xesc = (int) con.escaper.getTranslateX();
            int yesc = (int) con.escaper.getTranslateY();
            int xcat = (int) con.catcher.getTranslateX();
            int ycat = (int) con.catcher.getTranslateY();

            //Listen mit x und y Werten des Objekts machen
            List<Integer> xwerte = makeRange(obenlinksx, obenrechtsx);
            List<Integer> ywerte = makeRange(obenlinksy, untenlinksy);

            if ((xwerte.contains(xesc)) && ywerte.contains(yesc)) {
                System.out.println("Oh jetzt hat der Catcher ein Object berührt");
                if (xesc <= obenlinksx + 15 && ywerte.contains(yesc)) {
                    con.catcher.moveDownStatus = false;
                } else if (xesc >= untenlinksx - 15 && ywerte.contains(yesc)) {
                    con.catcher.moveUpStatus = false;
                } else if (yesc <= obenlinksy + 15 && xwerte.contains(xesc)) {
                    con.catcher.moveRightStatus = false;
                } else if (yesc >= untenrechtsy - 15 && xwerte.contains(xesc)) {
                    con.catcher.moveLeftStatus = false;
                }
            }
            if ((xwerte.contains(xcat)) && ywerte.contains(ycat)) {
                System.out.println("Oh jetzt hat der Escaper ein Object berührt");
                if (xcat <= obenlinksx + 15 && ywerte.contains(ycat)) {
                    con.escaper.moveDownStatus = false;
                } else if (xcat >= untenlinksx - 15 && ywerte.contains(ycat)) {
                    con.escaper.moveUpStatus = false;
                } else if (ycat <= obenlinksy + 15 && xwerte.contains(xcat)) {
                    con.escaper.moveRightStatus = false;
                } else if (ycat >= untenrechtsy - 15 && xwerte.contains(xcat)) {
                    con.escaper.moveLeftStatus = false;
                }
            }

        }
    }

    private List<Integer> makeRange(int min, int max) {
        List<Integer> range = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            range.add(i);
        }
        return range;
    }


    private void terminate() {
        db = new ScoreJDBCDao();
        gui.gameTimer.stopTimer();
        Time score = Time.valueOf("24:" + gui.gameTimer.getScoreTime());
        //System.out.println("Zeit: "+score);
        db.insertScore(con.catcher.getPlayerName(), score, 1);
        //System.out.println("Name: "+con.catcher.getPlayerName());
        con.escaper.catched();
        con.ani.stop();
        animationTimer.stop();
        gui.buildGameOverScreen();
    }
}
