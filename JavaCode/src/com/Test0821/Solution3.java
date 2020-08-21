package com.Test0821;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-21
 */
public class Solution3 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //求长度
        int len1 = 0;
        int len2 = 0;
        ListNode ps = headA;
        ListNode pl = headB;
        while (ps != null){
            len1++;
            ps = ps.next;
        }
        while (pl != null){
            len2++;
            pl = pl.next;
        }
        int x = 0;
        if (len1 > len2){
            x = len1 - len2;
            pl = headA;
            ps = headB;
        }else {
            x = len2 - len1;
            pl = headB;
            ps = headA;
        }
        while (x > 0){
            pl = pl.next;
            x--;
        }
        while (ps != pl && ps != null && pl != null){
            pl = pl.next;
            ps = ps.next;
        }
        if (pl == ps && pl != null){
            return pl;
        }

        return null;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                tmp.next = l1;
                tmp = tmp.next;
                l1 =l1.next;
            }else {
                tmp.next = l2;
                tmp = tmp.next;
                l2 = l2.next;
            }
        }
        if (l1 == null){
            tmp.next = l2;
        }
        if (l2 == null){
            tmp.next = l1;
        }
        return newHead.next;
    }




}
