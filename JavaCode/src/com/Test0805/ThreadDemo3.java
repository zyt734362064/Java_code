package com.Test0805;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-05
 */

public class ThreadDemo3 {
    /**
     * 显式创建一个类，实现 Runnable接口，然后把这个 Runnable 的实例关联到 Thread 上
     * Runnable 本质上就是描述了一段要执行的任务代码是什么
     * @param
     */
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("我是一个新线程");
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
