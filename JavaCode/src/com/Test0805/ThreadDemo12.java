package com.Test0805;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-05
 */
public class ThreadDemo12 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.interrupted());
                }
            }
        };
        t.start();
        t.interrupt();
    }
}
