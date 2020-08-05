package com.Test0805;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-04
 */
public class ThreadDemo2 {
    static class  Mythread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello ，I am a thread!");
            while (true){

            }
        }
    }

    /**
     * 创建线程需要使用 Thread 类，来创建一个 Thread 实例
     * 另一方面还需要给这个线程指定要执行哪些指令、代码
     * 指定指令的方式有很多种，此处直接继承 Thread 类
     * 重写 Thread 类中的 run 方法
     * 【注意】放 Thread 对象被创建出来的时候，内核中并没有随之产生一个线程（PCB）
     * 需要调用 start 方法
     * @param args
     */
    public static void main(String[] args) {
        Thread t = new Mythread();
        //执行这个 start 方法才是真正创建出了一个线程
        //此时内核中才随之出现了一个 PCB ，这个 PCB 就会让 CPU 来执行该线程的代码
        t.start();
        while (true){

        }
    }
}
