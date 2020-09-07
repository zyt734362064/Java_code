package com.Test0907;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-07
 */
public class TestThread2 {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("thread 1");
        }

        static class MyRunnable implements Runnable {
            @Override
            public void run() {
                System.out.println("thread 3");
            }
        }

        public static void main(String[] args) {
            Thread t1 = new MyThread();
            t1.start();

            Thread t2 = new Thread() {
                @Override
                public void run() {
                    System.out.println("thread 2");
                }
            };
            t2.start();
            Thread t3 = new Thread(new MyRunnable());
            t3.start();

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread 4");
                }
            };
            Thread t4 = new Thread(runnable);
            t4.start();

            Thread t5 = new Thread(() -> {
                System.out.println("thread 5");
            });
            t5.start();
        }
    }
}
