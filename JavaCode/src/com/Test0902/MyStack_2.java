package com.Test0902;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-02
 */
class MyStack_2 {
    private Queue<Integer> A = new LinkedList<>();
    private Queue<Integer> B = new LinkedList<>();

    public void push(int x){
        A.offer(x);
    }

    public Integer pop(){
        if (empty()){
            return null;
        }
        while (A.size() > 1){
            Integer front = A.poll();
            B.offer(front);
        }
        int ret = A.poll();
        swapAB();
        return ret;
    }

    private void swapAB() {
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }

    public Integer top(){
        if (empty()){
            return null;
        }
        while (A.size() > 1){
            Integer front = A.poll();
            B.offer(front);
        }
        int ret = A.poll();
        B.offer(ret);
        swapAB();
        return ret;

    }

    public boolean empty(){
        return A.isEmpty() && B.isEmpty();
    }
}
