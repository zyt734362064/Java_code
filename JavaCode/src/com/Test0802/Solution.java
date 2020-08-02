package com.Test0802;

/**
 * Create with IntelliJ IDEA
 * Description:反转链表
 * User:Zyt
 * Date:2020-08-02
 */
 class ListNode {
   int val;
   ListNode next;
   ListNode(int x) {
       val = x;
   }
}


public class Solution {
    /**
     * 翻转链表
     */
     public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode curNext = cur;
        ListNode newHead = head;
        while (cur != null){
            curNext = cur.next;
            if (curNext == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;

        }
        return newHead;
    }

    /**
     * 链表的中间节点
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

