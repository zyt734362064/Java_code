package com.Test0821;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-21
 */
public class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
        // write code here
        if (A == null){
            return false;
        }
        if (A.next == null){
            return true;
        }
        ListNode fast = A;
        ListNode slow = A;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        ListNode curNext = cur;
        while (cur != null){
            curNext = curNext.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while (A != slow && A.next != slow){
            if (A.val != slow.val){
                return false;
            }
            A = A.next;
            slow = slow.next;
        }
        return true;
    }
}
