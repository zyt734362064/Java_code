package com.Test0831;

import java.util.Stack;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-31
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        int ret = stack.pop();
        System.out.println(ret);
        ret = stack.pop();
        System.out.println(ret);
        ret = stack.pop();
        System.out.println(ret);
        ret = stack.pop();
        System.out.println(ret);
        //当栈内所有的数据都已经出栈以后，我们再调用此方法
        ret = stack.pop();
        System.out.println(ret);
    }
}
