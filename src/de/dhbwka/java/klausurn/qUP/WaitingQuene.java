package de.dhbwka.java.klausurn.qUP;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by cem on 12.10.16.
 */
public class WaitingQuene {
    private int number = 1;

    private ArrayList<QueueObserver> list = new ArrayList<>();
    private Queue<Integer> queue = new ArrayDeque<>(60000);
    private List<Call> calls = new ArrayList<>();
    private Call lastCall = null;


    public void addQueneObserver(QueueObserver ob) {
        list.add(ob);
    }

    public void updateObservers() {
        list.forEach(QueueObserver::updateView);
    }

    public Call getNextCall(DeskApp app) {
        if (queue.isEmpty()) return null;
        else {
            Call myCall = new Call(queue.poll(), app);
            calls.add(myCall);
            lastCall = myCall;
            updateObservers();
            return myCall;

        }
    }

    public void confirmCall(Call call) {
        calls.remove(call);
    }

    public Call getLastCall() {
        return lastCall;
    }

    public List<Call> getCurrentCalls() {
        return calls;
    }

    public int waitingClients() {
        return queue.size();
    }

    public int getNextQueneNumber() {
        int current = number++;
        queue.add(current);
        updateObservers();
        return current;
    }
}
