package de.dhbwka.java.klausurn.defaultStuff;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cem on 10.10.16.
 */

public class Timer {
    private static Timer ourInstance = new Timer();
    ExecutorService service = Executors.newSingleThreadExecutor();
    List<TickAble> ables = new ArrayList<>();

    private Timer() {
        service.execute(new TimerThread());
    }

    public static Timer getInstance() {
        return ourInstance;
    }

    public void addTimer(TickAble able) {
        ables.add(able);
    }

    public interface TickAble {
        void tick();
    }

    public class TimerThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    ables.forEach(TickAble::tick);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
