package com.Test0811;

/**
 * Create with IntelliJ IDEA
 * Description:删除重复的节点
 * User:Zyt
 * Date:2020-08-11
 */


public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode newHead = new ListNode(1, null);
        ListNode tmp = newHead;
        ListNode cur = pHead;
        while (cur != null) {
            //避免出现空指针异常多做一次判断 cur.next != null
            //当 cur 的 值和 cur.next 值相等时，cur 往后走
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                //还需要多走一步才能让第一个重复的节点也删除掉
                cur = cur.next;
            }else {
                //对于不重复的节点加入到 newHead 中，并且让 cur 继续往后面遍历
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        //如果剩下头节点，那么头节点的 next 应为 null
        // 所以要将 tmp 的 next 强行置位空
        tmp.next = null;
        //最后返回新头节点的 next 即可
        return newHead.next;
    }
}