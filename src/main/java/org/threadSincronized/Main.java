package org.threadSincronized;

public class Main {

    public static void main(String[] args) {

        Counter task = new Counter();

        Thread thread = new Thread(task, "CounterWithoutSynchronized-1");
        Thread thread1 = new Thread(task, "CounterWithoutSynchronized-2");
        Thread thread2 = new Thread(task, "CounterWithoutSynchronized-3");

        thread.start();
        thread1.start();
        thread2.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000); // para espera a execucao acima terminar
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("\n");

                CounterSynchronized task2 = new CounterSynchronized();

                Thread thread3 = new Thread(task2, "CounterSynchronized-1");
                Thread thread4 = new Thread(task2, "CounterSynchronized-2");
                Thread thread5 = new Thread(task2, "CounterSynchronized-3");

                thread3.start();
                thread4.start();
                thread5.start();
            }
        }.start();



    }
}
