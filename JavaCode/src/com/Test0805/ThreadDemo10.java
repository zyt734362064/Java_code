package com.Test0805;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-05
 */
public class ThreadDemo10 {
    private static boolean isQuit = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){

            @Override
            public void run(){
               while (!isQuit){
                   System.out.println("正在转账，请勿打扰!");
                   try {
                       Thread.sleep(500);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
                System.out.println("转账操作已被终止！");
            }
        };
        t.start();
        Thread.sleep(5000);
        //此时老板来电话了：对方是内鬼，赶快终止交易！
        System.out.println("对方是内鬼，赶快终止交易！");
        isQuit = true;
    }
}
