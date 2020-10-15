package com.Test0923;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-23
 */
public class ThreadDemo1 {
    static class Singleton {
        private Singleton() {

        }
        private static Singleton instance = new Singleton();
        public static Singleton getInstance(){
            return instance;
        }
    }
}
