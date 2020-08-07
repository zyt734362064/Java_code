package com.Test0807;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-07
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 10; i++) {

                }
            }
        };
        System.out.println("线程启动前: " + t.getState());
        t.start();
        while (t.isAlive()){
            System.out.println("线程启动中: " + t.getState());
        }
        System.out.println("线程结束后: " + t.getState());
    }
}
