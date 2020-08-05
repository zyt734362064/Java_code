package com.Test0805;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-05
 */
public class ThreadDemo9 {
    public static void main(String[] args) {
        Thread t = new Thread("X线程"){
            @Override
            public void run(){
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //run 方法的执行过程中代表着系统内线程的生命周期
                //run 方法执行中，内核的线程就存在
                //run 方法执行完毕，内核中的线程就随之销毁
                System.out.println("线程要结束了");
            }
        };

        System.out.println(t.getName());

        System.out.println(t.getPriority());
        System.out.println(t.isDaemon());
        System.out.println(t.getId());
        //这三个属性会随着线程的执行过程而发生改变
        System.out.println(t.getState());
        System.out.println(t.isAlive());
        System.out.println(t.isInterrupted());
        t.start();
        while (t.isAlive()){
            System.out.println("X线程正在运行！");
            System.out.println(t.getState());
            System.out.println(t.isInterrupted());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
