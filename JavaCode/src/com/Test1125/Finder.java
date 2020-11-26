package com.Test1125;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-11-25
 */
public class Finder {
    public int findKth(int[] a, int n, int K) {
        findKthHelper(a,0,n - 1);
        return a[K - 1];
    }

    private void findKthHelper(int[] a, int left, int right) {
        if (left > right){
            return;
        }
        int index = partition(a,left,right);
        findKthHelper(a,0,index - 1);
        findKthHelper(a,index + 1,right);
    }

    private int partition(int[] a, int left, int right) {
        int base = a[right];
        int i = left;
        int j = right;
        while (i < j){
            while (i < j && a[i] >= base){
                i++;
            }
            while (i < j && a[i] <= base){
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

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,10,6,7};
        Finder finder = new Finder();
        System.out.println(finder.findKth(a, 8, 3));
    }
}
