package com.Test0728;

/**
 * Create with IntelliJ IDEA
 * Description:单链表
 * User:Zyt
 * Date:2020-07-28
 */
class Node {
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}


public class MyLinkedList {
    public Node head;   //保存单链表的头节点的引用
    // 1、无头单向非循环链表实现

        //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;

    }


        //尾插法
        public void addLast(int data){
            Node node = new Node(data);
            Node cur = this.head;
            if (cur == null){
                this.head = node;
                return;
            }
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
        //任意位置插入,第一个数据节点为0号下标
        public void addIndex(int index, int data){

            if (index == 0){
                addFirst(data);
                return;
            }
            if (index == size()){
                addLast(data);
                return;
            }
            Node node = new Node(data);
            Node cur = searchIndex(index);

            node.next = cur.next;
            cur.next = node;

        }
        //找到 index - 1 位置的节点并返回
        private Node searchIndex(int index){
            if (index < 0 || index > size()){
                throw new RuntimeException("index位置不合法！");
            }
            Node cur = this.head;
            while (index - 1 != 0){
                cur = cur.next;
                index--;
            }
            return cur;
        }
         //查找是否包含关键字key是否在单链表当中
        public boolean contains(int key){
            Node cur = this.head;
            while (cur != null){
                if (cur.data == key){
                    return true;
                }
                cur = cur.next;
            }
            return false;
        }
        //删除第一次出现关键字为key的节点
        public void remove(int key){
            if (this.head == null){
                return;
            }
            if (this.head.data == key){
                this.head = this.head.next;
                return;
            }
            Node prev = searchPrev(key);
            if (prev == null){
                System.out.println("没有这个节点！");
                return;
            }
            prev.next = prev.next.next;
        }
        //找到要删除的节点的前驱节点
        private  Node searchPrev(int key){
            Node prev = this.head;
            while (prev.next != null){
                if (prev.next.data == key){
                    return prev;
                }
                prev = prev.next;
            }
            return null;
        }

        //删除所有值为key的节点
        public void removeAllKey(int key){

        }
        //得到单链表的长度
        public int size(){
            int size = 0;
            Node cur = this.head;
            while (cur != null){
                size++;
                cur = cur.next;
            }
            return size;
        }

        public void display(){
            Node cur = this.head;
            while (cur != null){
                System.out.print(cur.data + " ");
                cur = cur.next;
            }
        }

        public void clear(){

        }


}
