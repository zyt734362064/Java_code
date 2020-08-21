package com.Test0821;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-21
 */
public class ThreadDemo {
    static class Test{
        public void method(){
            synchronized(this){
                System.out.println("嘻嘻");
            }
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.method();
    }
}
