package com.Test0821;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-21
 */
public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        if (fast == null|| fast.next == null){
            return null;
        }
        slow = head;
        while (slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
