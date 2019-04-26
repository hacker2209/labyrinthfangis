package net.ictcampus.fangis;

import javafx.application.Platform;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
    private long timeLeftMilliseconds = 180000;  // 3min
    GameGui gui;
//    TimerTask task = new TimerTask() {
//        @Override
//        public void countStart() {
//            while (timeLeftMilliseconds >= 0) {
//                int minute = (int) (timeLeftMilliseconds / 1000) / 60;
//                int second = (int) (timeLeftMilliseconds / 1000) % 60;
//                Platform.runLater(new Runnable() {
//                    @Override
//                    public void countStart() {
//                        gui.lblTimer.setText(minute + ":" + second);
//                    }
//                });
//                timeLeftMilliseconds--;
//            }
//        }
//    };


    public void countStart(GameGui gui) {
        this.gui=gui;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (timeLeftMilliseconds > 0) {
                        showTimer();
                        timeLeftMilliseconds -= 1000;
                        System.out.println(timeLeftMilliseconds);
                    } else {
                        gui.buildGameOverScreen();
                        gui.gameOverText.setText("Looks like the escaper has Won");
                        timer.cancel();
                    }
                });

            }
        }, 0,1000);
    }

    public void showTimer() {
        int minute = (int) (timeLeftMilliseconds / 1000) / 60;
        int second = (int) (timeLeftMilliseconds / 1000) % 60;
        gui.lblTimer.setText(minute + ":" + second);
        System.out.println(minute + ":" + second);
        //System.out.println(timeLeftMilliseconds);
    }

}
