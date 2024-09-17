package org.threadBasics;

public class Main {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread1.start(); // iniciar a thread

        Thread thread2 = new Thread(new ClassWithRunnable(), "Thread2");
        thread2.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
    }

    static class ClassWithRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

}