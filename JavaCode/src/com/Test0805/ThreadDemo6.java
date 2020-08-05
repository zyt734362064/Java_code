package com.Test0805;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-05
 */
public class ThreadDemo6 {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("我是一个线程");
        }
    }
    static class MyThread2 implements Runnable{
        @Override
        public void run() {
            System.out.println("我是一个线程3");
        }
    }

    public static void main(String[] args) {
        /*Thread t = new MyThread();
        t.start();
        Thread t = new Thread(){
            @Override
            public void run(){
                System.out.println("我是一个线程2");
            }
        };
        t.start();
        Thread t3 = new Thread(new MyThread2());
        t3.start();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是线程4");
            }
        };
        Thread t4 = new Thread(runnable);
        t4.start();*/
        Thread t5 = new Thread(() ->{
            System.out.println("我是线程5");
        });
        t5.start();
    }
}
