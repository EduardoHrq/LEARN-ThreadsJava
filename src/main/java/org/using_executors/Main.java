package org.using_executors;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {

        ExecutorService executor = null;


        try {

            executor = Executors.newSingleThreadExecutor();

            executor.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                System.out.println(STR."\{Thread.currentThread().getName()} single thread");
            });
            executor.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                System.out.println(STR."\{Thread.currentThread().getName()} single thread");
            });
            executor.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                System.out.println(STR."\{Thread.currentThread().getName()} single thread");
            });


        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (executor != null) {
                executor.shutdown();
            }
        }

        // Fixed threads
//        try {
//
//
//            executor = Executors.newFixedThreadPool(5);
//
//            var runnableForFixed = new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(STR."\{Thread.currentThread().getName()} fixed thread");
//                }
//            };
//
////            for (int i = 0; i < 5; i++) {
////                executor.execute(runnableForFixed);
////            }
//            for (int i = 0; i < 5; i++) {
//                executor.submit(runnableForFixed);
//            }
//
//
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            if (executor != null) {
//                executor.shutdown();
//            }
//        }

//        try {
//            executor = Executors.newCachedThreadPool();
//
//            var runnableForCached = new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(STR."\{Thread.currentThread().getName()} cached thread");
//                }
//            };
//
//            var callableForCached = new Callable<String>() {
//                @Override
//                public String call() throws Exception {
//                    System.out.println(LocalTime.now());
//                    return STR."\{Thread.currentThread().getName()} call in cached thread";
//                }
//            };
//
//            List<Callable<String>> tasks = new ArrayList<>();
//            for (int i = 0; i < 10; i++) {
////                executor.submit(runnableForCached);
//                tasks.add(callableForCached);
//            }
//
//            List<Future<String>> result = executor.invokeAll(tasks);
//
//            for (Future<String> future : result) {
//                System.out.println(future.get());
//            }
//
//            System.out.println(LocalTime.now());
//
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            if (executor != null) {
//                executor.shutdown();
//            }
//        }

        try {
            executor = Executors.newVirtualThreadPerTaskExecutor();

            var callableForVirtualThread = new Callable<String>() {
                @Override
                public String call() {
                    try {
                    Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "virtual thread";
                }
            };


            var resultado1 = executor.submit(callableForVirtualThread);
            var resultado2 = executor.submit(callableForVirtualThread);
            var resultado3 = executor.submit(callableForVirtualThread);

            System.out.println(resultado1.get());
            System.out.println(resultado2.get());
            System.out.println(resultado3.get());


        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (executor != null) {
                executor.shutdown();
            }
        }




    }

}
