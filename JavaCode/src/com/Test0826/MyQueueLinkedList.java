package com.Test0826;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-26
 */
public class MyQueueLinkedList {
    //Node 这个类叫内部类，定义在某个方法或者类中的类
    //static 效果是：创建 Node 的实例不依赖 MyQueueByLinkedList 这个类的实例
    static class Node{
        public int val;
        Node next = null;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node head = null;
    private Node tail = null;

    //入队列
    public void offer(int val){
        Node newNode = new Node(val);
        if (head ==  null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
    }

    //出队列
    public Integer poll(){
        if (head == null){
            return null;
        }
        int ret = head.val;
        head = head.next;
        if (head == null){
            tail = null;
        }
        return ret;
    }

    //取队首元素
    public int peek(){
        return head.val;
    }
}
