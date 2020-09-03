package com.Test0902;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-02
 */
class MyStack {
    /** Initialize your data structure here. */
    private Queue<Integer> A = new LinkedList<>();
    private Queue<Integer> B = new LinkedList<>();

    /** Push element x onto stack. */
    public void push(int x) {
        A.offer(x);

    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        if (empty()){
            return null;
        }
        while (A.size() > 1){
            Integer front = A.poll();
            B.offer(front);
        }
        //此时 A 就剩下 1 个元素
        int ret = A.poll();
        swapAB();
        return ret;
    }
    private void swapAB(){
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }

    /** Get the top element. */
    public Integer top() {
        if (empty()){
            return null;
        }
        while (A.size() > 1){
            Integer front = A.poll();
            B.offer(front);
        }
        //此时 A 就剩下 1 个元素
        int ret = A.poll();
        //pop  和 top 为以的区别就是这句话
        B.offer(ret);
        swapAB();
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
