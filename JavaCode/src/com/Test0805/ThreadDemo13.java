package com.Test0805;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-05
 */
public class ThreadDemo13 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 3; i++) {
                    System.out.println("我是线程1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 3; i++) {
                    System.out.println("我是线程2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        t1.join();//join 的效果是等待线程结束，当执行这行代码时，程序就阻塞了，一直阻塞到 t1 结束才会继续
        t2.start();
        t2.join();
        System.out.println("主线程执行完毕了！");
    }

}
