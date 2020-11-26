package com.Test1126;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-11-26
 */
public class Main4 {
    public int count(int[] A, int n) {
        // write code here
        if (A == null || n == 0){
            return 0;
        }
        return order(A,0,n -1 );
    }

    private int order(int[] a, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (right - left + 1) / 2;
        return order(a,left,mid) + order(a,mid + 1,right) + newOrder(a,left,mid,right);
    }

    private int newOrder(int[] a, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        return 0;
    }
}
