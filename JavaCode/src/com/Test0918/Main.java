package com.Test0918;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-18
 */
public class Main {
    static class Counter {
        public  int count = 0;
         public void increase(){
            ++count;
        }


        public static void main(String[] args) throws InterruptedException {
            Counter  counter = new Counter();
            Thread t1 = new Thread(){
                @Override
                public void run(){
                   for (int i = 0 ;i < 50000; i++){
                       counter.increase();
                   }
                }
            };
            t1.start();
            Thread t2 = new Thread(){
                @Override
                public void run(){
                    for (int i = 0 ;i < 50000; i++){
                        counter.increase();
                    }
                }
            };
            t2.start();
            t1.join();
            t2.join();
            System.out.println(counter.count);
        }

    }
}
