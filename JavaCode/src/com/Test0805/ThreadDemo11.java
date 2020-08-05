package com.Test0805;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-05
 */
public class ThreadDemo11 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run(){
                //此处直接使用线程内部的标记位来判定
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println("正在转账，请勿打扰！");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("转账已被终止！");
            }
        };
        t.start();

        Thread.sleep(5000);
        System.out.println("对方是内鬼，赶快终止交易！");
        t.interrupt();
    }
}
