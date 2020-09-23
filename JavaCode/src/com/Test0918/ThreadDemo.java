package com.Test0918;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-20
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object){
            System.out.println("等待前");
            object.wait();
            System.out.println("等待后");
        }
    }
}
