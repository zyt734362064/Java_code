package com.Test0821;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-21
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run(){
                Scanner sc = new Scanner(System.in);
                System.out.println("请输入一个整数");
                synchronized (locker1.getClass()) {
                    //如果用户不输入，锁救护一直阻塞在 nextInt 中
                    int num = sc.nextInt();
                    System.out.println("num = " + num);
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run(){
               while (true){
                   synchronized (locker2.getClass()){
                       System.out.println("线程2获取到锁");
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }
            }
        };
        t2.start();
    }
}
