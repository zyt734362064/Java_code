package com.Test0811;

/**
 * Create with IntelliJ IDEA
 * Description:
 * 1、定义两个线段的开始和结束
 * bes be as ae = null
 * 2、定义一个 cur 遍历原来的单链表
 * 3、如果 cur.data < x 放到第一个线段
 * 如果相反就放到第二个线段 尾插法放入
 * 4、当 cur 为空的时候，原来的单链表就遍历完了
 *
 * 注意：
 * 1、第一个段没有数据返回 as
 * 2、be 和 as 要进行拼接be.next = as
 * User:Zyt
 * Date:2020-08-11
 */
import java.util.*;

public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if (pHead == null){
            return null;
        }
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = pHead;
        while (cur != null ){
            if (cur.val < x){
                //第一次插入
                if (bs == null){
                    bs = be = cur;
                }else {
                    be.next = cur;
                    be = be.next;
                }

            }else {
                //第一次插入
                if (as == null){
                    as = ae = cur;
                }else{
                    ae.next = cur;
                    ae = ae.next;
                }

            }
            cur = cur.next;
        }
        //判断bs 等于 null,返回 as
        if (bs == null){
            ae.next = null;
            return as;
        }
        //如果 bs 不为空需要拼接
        be.next = as;
        //如果 ae 不为 null ae.next == null
        if (ae != null){
            ae.next = null;
        }
        return bs;
    }
}