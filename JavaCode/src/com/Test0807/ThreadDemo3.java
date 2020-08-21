package com.Test0807;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-07
 */
public class ThreadDemo3 {
    static class Counter {
        public int count = 0;
        synchronized public void increase(){
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 50000; i++) {
                    counter.increase();
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 50000; i++) {
                    counter.increase();
                }
            }
        };
        t2.start();
        t1.join();
        t2.join();
        //两个线程各自自增 50000 次，预期结果应该是 100000
        System.out.println(counter.count);
    }
}
