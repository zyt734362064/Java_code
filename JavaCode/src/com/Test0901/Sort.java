package com.Test0901;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-01
 */
public class Sort {

    public void insertSort(int[] array){
        for (int bound = 1;bound < array.length;bound++){
            int v = array[bound];
            int cur = bound - 1;
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
    public void shellSort(int[] array){
        int gap = array.length / 2;
        while (gap > 1){
            insertSortGap(array,gap);
            gap = gap / 2;
        }
        insertSortGap(array,1);
    }

    private void insertSortGap(int[] array, int gap) {
        for (int bound = gap;bound < array.length;bound++){
            int v =array[bound];
            int cur = bound - gap;
            while (cur >= 0){
                if (array[cur] > v){
                    array[cur + gap] = array[cur];
                }else {
                    break;
                }
                cur -= gap;
            }
            array[cur +gap] = v;
        }
    }

    public void quickSort(int[] array){
        quickSortHelper(array,0,array.length - 1);
    }

    private void quickSortHelper(int[] array, int left, int right) {
        if (left >= right){
            return;
        }
        int index = partition(array,left,right);
        quickSortHelper(array,left,index -1);
        quickSortHelper(array,index + 1,right);
    }

    private int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j){
            while (i < j && array[i] <= baseValue){
                i++;
            }
            while (i < j && array[j] >= baseValue){
                j--;
            }
            if (i < j){
                swap(array,i,j);
            }
        }
        swap(array,i,right);
        return i;

    }


    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        Sort sort = new Sort();
        System.out.println(Arrays.toString(array));
        sort.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
