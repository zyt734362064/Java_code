package com.Test0811;

/**
 * Create with IntelliJ IDEA
 * Description:链表中倒数第 K 个节点
 * User:Zyt
 * Date:2020-08-11
 */
class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val =  val;
        this.next = null;
    }
}

public class TestDemo1 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if ( k < 0 ){
            System.out.println("k 不合法");
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (k - 1 > 0){
            if (fast.next != null){
                fast = fast.next;
                k--;
            }
            System.out.println("没有这个节点");
            return null;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public int size(ListNode head){
        ListNode cur = head;
        int size = 0;
        while (cur != null){
            cur = cur.next;
            size++;
        }
        return size;
    }

}
