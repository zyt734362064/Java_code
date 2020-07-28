package com.Test0728;


/**
 * Create with IntelliJ IDEA
 * Description:单链表
 * User:Zyt
 * Date:2020-07-18
 */
public class TestDemo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(10);
        myLinkedList.addFirst(11);
        myLinkedList.addFirst(12);
        myLinkedList.addFirst(13);
        myLinkedList.addLast(20);
        myLinkedList.display();
        System.out.println();
        /*System.out.println("是否存在12这个值：");
        System.out.println(myLinkedList.contains(12));
        System.out.println("是否存在15这个值：");
        System.out.println(myLinkedList.contains(15));
        System.out.println("单链表的长度为：");
        System.out.println(myLinkedList.size());
        myLinkedList.addIndex(10,88);*/
        myLinkedList.remove(20);
        myLinkedList.display();
    }
}
