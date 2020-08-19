package com.Test0819;

import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-19
 */
public class TestSort4 {
    public static void quickSort(int[] array) {
        quickSortHelper(array,0,array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {

        if (left >= right){
            return;
        }
        int index = patition(array,left,right);
        quickSortHelper(array,0,index - 1);
        quickSortHelper(array,index + 1,right);

    }

    private static int patition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[right];
        while (i < j){
            while (i < j && array[i] <= base){
                i++;
            }
            while (i < j && array[j] >= base){
                j--;
            }
            swap(array,i,j);
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
        int[] arr = {9,5,2,7,3,6,8,4};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
