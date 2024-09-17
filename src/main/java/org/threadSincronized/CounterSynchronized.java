package org.threadSincronized;

public class CounterSynchronized implements Runnable {

    private int counter = 0;

    @Override
    public void run() {
        synchronized (this) {
            counter++;
            System.out.println(STR."\{Thread.currentThread().getName()}: \{counter}");
        }
    }
}
