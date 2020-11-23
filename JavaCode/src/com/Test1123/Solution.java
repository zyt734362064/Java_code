package com.Test1123;

import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-11-23
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode curNext = null;
        while (cur  != null){
            curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }
}
