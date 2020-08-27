package com.Test0827;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-27
 */

 class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }}
public class RemoveRepeatNode {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        ListNode cur = head;
        ListNode tmp = newHead;
        while (cur.next != null){
            while (cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
                cur = cur.next;
            tmp.next = cur;
            tmp = tmp.next;
            cur = cur.next;
        }
        tmp.next = null;
        return newHead;
    }
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode bs = null;
        ListNode be = bs;
        ListNode as = null;
        ListNode ae = as;
        ListNode cur = head;
        while (cur != null){
            if (cur.val < x){
                if (bs == null){
                  bs = be = cur;
                }else {
                    be.next = cur;
                    be = be.next;
                }

            }else {
                if (as == null){
                    as = ae = cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if (bs == null){
            ae.next = null;
            return as;
        }else {
            be.next = as;
            if (as != null){
                ae = null;
                return bs;
            }
            return bs;
        }
    }
}
