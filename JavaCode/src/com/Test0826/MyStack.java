package com.Test0826;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-26
 */
public class MyStack {
    //管理一些 int 元素
    private int[] array = new int[100];
    private int size = 0;

    //入栈
    public void push(int x){
        array[size] = x;
        size++;
    }
    //出栈
    public int pop(){
        int ret = array[size - 1];
        size--;
        return ret;
    }
    //取队首元素
    public int peek(){
        return array[size - 1];
    }
}
