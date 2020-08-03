package com.Test0803;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-03
 */
public class TestDemo2 {
    public static void main(String[] args) {
        // StringBuffer 是线程安全的，StringBuilder 不是
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello");
        stringBuffer.append("hello");
        stringBuffer.append("hello");
    }
}
