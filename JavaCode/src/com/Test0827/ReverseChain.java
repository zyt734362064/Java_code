package com.Test0827;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-27
 */
public class ReverseChain {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n){
            return head;
        }
        ListNode curPrev = null;
        ListNode cur = head;
        int i =1;
        while (i < m){
            if (cur == null){
                break;
            }
            curPrev = cur;
            cur = cur.next;
            i++;
        }
        ListNode prev1 = curPrev;
        ListNode prev2 = cur;
        ListNode curNext = cur;
        while (i <= n && cur != null){
            curNext = cur.next;
            cur.next = curPrev;
            curPrev = cur;
            cur = curNext;
            i++;
        }
        if (m == 1){
            prev2.next = cur;
            return curPrev;
        }
        prev2.next = cur;
        prev1.next = curPrev;
        return head;
    }
}
