package com.Test0918;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-23
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run(){
               synchronized (locker){
                   while (true){
                       try {
                           System.out.println("wait 开始");
                           locker.wait();
                           System.out.println("wait 结束");
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run(){
                Scanner scanner = new Scanner(System.in);
                System.out.println("输入一个整数，继续执行 notify:");
                int num = scanner.nextInt();

                synchronized (locker) {
                    System.out.println("notify 开始");
                    locker.notify();
                    System.out.println("notify 结束");
                }
            }
        };
        t2.start();
    }
}
