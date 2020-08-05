package com.Test0805;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-05
 */
public class ThreadDemo7  {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("我是一个新线程");
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();
        //t.run();
        t.start();
    }
}
