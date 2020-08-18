package com.Test0818;

import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-18
 */
public class InsertSort {
    public static void insertSort(int[] array){
        for (int bound = 1;bound  < array.length;bound++){
            int cur = bound - 1;
            int v = array[bound];
            while (cur >= 0){
                if (array[cur] > v){
                    array[cur + 1] = array[cur];
                }else {
                    break;
                }
                cur--;
            }
            array[cur + 1] = v;
        }

    }


    public static void shellSort(int[] array){
        int gap = array.length / 2;
        while (gap > 1){
            insertSortGap(array,gap);
            gap = gap / 2;
        }
        insertSortGap(array,1);
    }

    private static void insertSortGap(int[] array, int gap) {
        for (int bound = gap;bound < array.length;bound++){
            int cur = bound - gap;
            int v = array[bound];
            while (cur >= 0){
                if (array[cur] > v){
                    array[cur + gap] = array[cur];
                }else {
                    break;
                }
                cur -= gap;
            }
            array[cur + gap] = v;
        }
    }

    public static void main(String[] args) {
        int arr[] = {3,10,2,93,6,9,8};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
