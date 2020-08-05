package com.Test0805;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-05
 */
public class ThreadDemo4 {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Runnable runnable =  new Runnable() {
            @Override
            public void run() {
                System.out.println("我是一个新线程2！");
            }
        };
        Thread t= new Thread(runnable);
        t.start();
    }
}
