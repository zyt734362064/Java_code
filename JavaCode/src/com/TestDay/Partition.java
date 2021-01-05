package com.TestDay;

/**
 * Create with IntelliJ IDEA
 * Description:链表分割
 * 新建两个链表，小的放到左侧，大的放到右侧
 * User:Zyt
 * Date:2021-01-05
 */
import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode cur = pHead;
        ListNode aHead = new ListNode(-1);
        ListNode bHead = new ListNode(-1);
        ListNode atmp = aHead;
        ListNode btmp = bHead;

        while (cur != null ){
            if (cur.val < x){
                atmp.next = new ListNode(cur.val);
                atmp = atmp.next;
            }else {
                btmp.next = new ListNode(cur.val);
                btmp = btmp.next;
            }
            cur = cur.next;
        }
        cur = aHead;
        while (cur.next != null && cur.next.val != -1 ){
            cur = cur.next;
        }
        cur.next = bHead.next;
        return aHead.next;
    }
}