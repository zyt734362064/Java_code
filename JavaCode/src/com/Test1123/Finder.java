package com.Test1123;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-11-23
 */
public class Finder {
    public int findKth(int[] a, int n, int K) {
        // write code here
        findKthHelp(a, 0, n - 1);
        return a[K - 1];
    }

    private void findKthHelp(int[] a, int left , int right) {
        if (left >= right){
            return;
        }
        int value = patation(a,left,right);
        findKthHelp(a,0,value - 1);
        findKthHelp(a,value + 1,right);
    }

    private int patation(int[] a, int left, int right) {
        int i = left;
        int j = right;
        int base = a[right];
        while (i < j){
            while (i < j && a[i] >= base){
                i++;
            }
            while (i < j && a[j] >= base){
                j--;
            }
            if (i < j){
                swap(a,i,j);
            }

        }
        swap(a,i,right);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
