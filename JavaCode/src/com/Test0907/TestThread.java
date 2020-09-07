package com.Test0907;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-07
 */
public class TestThread {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Thread1");
        }
        static class MyRunnable implements Runnable{
            @Override
            public void run() {
                System.out.println("Thread3");
            }
        }
    }
    public static void main(String[] args) {
        Thread t2 = new Thread(){
            @Override
            public void run() {
                System.out.println("thread2");
            }
        };
        Thread t1 = new MyThread();
        t1.start();
        t2.start();

        Thread t3 = new Thread(new MyThread.MyRunnable());
        t3.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread4");
            }
        };
        Thread t4 = new Thread(runnable);
        t4.start();

        Thread t5 = new Thread(()->{
            System.out.println("Thread5");
        });
        t5.start();
    }
}
