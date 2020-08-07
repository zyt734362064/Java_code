package com.Test0807;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-07
 */



public class ThreadDemo1 {
    /*static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("线程1");
        }
    }
static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("线程3");
        }
    }*/

    public static void main(String[] args) {
        /*for (Thread.State state : Thread.State.values()){
            System.out.println(state);
        }
        Thread t1 = new MyThread();
        t1.start();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("线程2");
            }
        };
        t1.start();
        Thread t = new Thread(new MyRunnable());
        t.start();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程4");
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();*/
        Thread t5 = new Thread( ()-> {
            System.out.println("线程5");
        });
        t5.start();
    }
}
