package org.threadSincronized;

import static java.lang.StringTemplate.STR;

public class Counter implements Runnable {

    private int counter = 0;

    @Override
    public void run() {
        counter++;
        System.out.println(STR."\{Thread.currentThread().getName()}: \{counter}");
    }
}
