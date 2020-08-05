package com.Test0805;

/**
 * Create with IntelliJ IDEA
 * Description:串行和并发的执行效果展示
 * User:Zyt
 * Date:2020-08-05
 */
public class ThreadDemo1 {
    private static long count = 100_0000_0000L;
    public static void main(String[] args) {
        //serial();//串行
        concurrency();//并发
    }

    private static void concurrency() {
        long beg = System.currentTimeMillis();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a++;
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                int b = 0;
                for (long i = 0; i < count; i++) {
                    b++;
                }
            }
        };
        t1.start();
        t2.start();
        try {
            //线程等待，让主线程等待 t1 和 t2 执行结束，然后再继续往下运行
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //t1 t2 和主线程都是并发执行的
        //调用了额t1.start()和 t1.start() 之后，两个线程正在计算过程中
        //此时主线程仍然会继续执行，下面的 end 就随之被计算了
        //正确做法保证 t1 和 t2 都计算完毕再来计算 end 的时间戳
        long end = System.currentTimeMillis();//计算结束时间戳
        System.out.println("time:" + (end - beg) + "ms");
    }

    private static void serial() {
        long beg = System.currentTimeMillis();//计算开始时间戳
        int a = 0;
        for (long i = 0; i < count; i++) {
            a++;
        }
        int b = 0;
        for (long i = 0; i < count ; i++) {
            b++;
        }
        long end = System.currentTimeMillis();//计算结束时间戳
        System.out.println("time:" + (end - beg) + "ms");
    }
}
