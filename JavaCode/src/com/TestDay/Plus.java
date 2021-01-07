package com.TestDay;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2021-01-07
 */
import java.util.*;

public class Plus {
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
       ListNode newHead = new ListNode(-1);
       ListNode cur = newHead;
       int addNext = 0;
       while (a != null || b != null || addNext != 0){
           int aValue = a != null ? a.val : 0;
           int bVaule = b != null ? b.val : 0;
           int sum = aValue + bVaule + addNext;
           addNext = sum % 10;
           int node = sum / 10;
           cur.next = new ListNode(node);
           cur = cur.next;

           a = a != null ? a.next : null;
           b = b != null ? b.next : null;
        }
        return newHead.next;
    }



}
