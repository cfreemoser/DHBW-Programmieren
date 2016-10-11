package de.dhbwka.java.klausurn.initStuff;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cfreemoser on 10.10.16.
 */

public class Timer {
    private static Timer ourInstance = new Timer();
    private static long INTERVAL = 100;
    ExecutorService service = Executors.newSingleThreadExecutor();
    List<TickAble> ables = new ArrayList<>();
    private Timer() {
        service.execute(new TimerThread());
    }

    public static Timer getInstance() {
        return ourInstance;
    }

    public void addTimer(TickAble notifyMe) {
        ables.add(notifyMe);
    }

    public void setInterval(long interval) {
        INTERVAL = interval;
    }

    public interface TickAble {
        /**
         * This method is called every 100ms
         */
        void tick();
    }

    private class TimerThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(INTERVAL);
                    ables.forEach(TickAble::tick);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
