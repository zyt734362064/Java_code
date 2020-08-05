package com.Test0805;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-05
 */
public class ThreadDemo5 {
    public static void main(String[] args) {
        Thread t= new Thread(() -> {
            System.out.println("我是一个新线程3");
        });
        t.start();
    }
}
