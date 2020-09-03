package com.Test0902;

import java.util.Stack;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-02
 */
public class MyQueue {

    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();


    public void push(int x){
        //先把 B 中的元素转入 A 中
        while (!B.isEmpty()){
            int tmp = B.pop();
            A.push(tmp);
        }
        //再把新元素入 A
        A.push(x);
    }

    public Integer pop(){
        if (empty()){
            return null;
        }
        while (!A.isEmpty()){
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.pop();
    }

    public Integer peek(){
        if (empty()){
            return null;
        }
        while (!A.isEmpty()){
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.peek();
    }

    public boolean empty(){
        return A.isEmpty() && B.isEmpty();
    }
}
