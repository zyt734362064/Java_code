package com.Test0821;

/**
 * Create with IntelliJ IDEA
 * Description:给定一个链表，判断是否有环
 * User:Zyt
 * Date:2020-08-21
 */
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
