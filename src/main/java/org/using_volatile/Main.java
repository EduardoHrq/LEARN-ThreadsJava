package org.using_volatile;

public class Main {
    public static void main(String[] args) {
        Race race = new Race();
        Thread runner1 = new Thread(new Runner("runner 1", race), "runner-1");
        Thread runner2 = new Thread(new Runner("runner 2", race), "runner-2");

        System.out.println("start");

        runner1.start();
        runner2.start();

    }
}
