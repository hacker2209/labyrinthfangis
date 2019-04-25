package net.ictcampus.fangis;

import javafx.animation.AnimationTimer;

public class anithreads extends Thread {

    //Instancevariabels
    private AnimationTimer anicatcher, aniescaper;

    public void run() {
        anicatcher = new AnimationTimer() {
            @Override
            public void handle(long now) {

            }
        };
    }

}
