package com.Test1021;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-10-21
 */
public class QuickSort {
    public static void quickSort(int[] arr){
        quickSortHelper(arr,0,arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int left, int right) {
        if (left >= right){
            return;
        }
        int index = partititon(arr,left,right);
        quickSortHelper(arr,0,index - 1);
        quickSortHelper(arr,index + 1,right);
    }

    private static int partititon(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int baseValue = arr[right];
        while (i < j){
            while (i < j && arr[i] <= baseValue){
                i++;
            }
            while (i < j && arr[j] >= baseValue){
                j--;
            }
            if (i < j ){
                swap(arr,i,j);
            }
        }
        swap(arr,i,right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8};
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
