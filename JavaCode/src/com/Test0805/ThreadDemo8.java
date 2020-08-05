package com.Test0805;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-05
 */
public class ThreadDemo8 {
    public static void main(String[] args) {
        Thread t = new Thread("这是一个线程的名字，可以很长"){
            @Override
            public void run(){
               while (true){

               }
            }
        };
        t.start();
    }
}
