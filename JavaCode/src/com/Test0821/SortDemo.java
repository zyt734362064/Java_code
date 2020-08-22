package com.Test0821;

import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-22
 */
public class SortDemo {
    public static void quickSort(int[] array){
        quickSortHelper(array,0,array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right){
            return;
        }
        int index = partition(array,left,right);
        quickSortHelper(array,left,index - 1);
        quickSortHelper(array,index + 1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int base = array[right];
        int i = left;
        int j = right;
        while (i < j){
            while (i < j && array[i] <= array[right]){
                i++;
            }
            while (i < j && array[j] >= array[right]){
                j--;
            }
            if (i < j){
                swap(array,i,j);
            }
        }
        swap(array,i,right);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
