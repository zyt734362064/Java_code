package com.Test0820;

import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-20
 */
public class TestSort1 {
    public static void insertSort(int[] array){
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
            int v = array[bound];
            int cur = bound - gap;
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
    public static void selectSort(int[] array){
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[cur] < array[bound]){
                    swap(array,bound,cur);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void heapSort(int[] array){
        createHeap(array);
        int heapSize = array.length;
        for (int i = 0;i < array.length;i++){
            swap(array,0,heapSize - 1);
            heapSize--;
            shiftDown(array,heapSize,0);
        }
    }

    private static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1 ) / 2; i >= 0  ; i--) {
            shiftDown(array,array.length,i);
        }
    }

    private static void shiftDown(int[] array, int heapSize, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < heapSize){
            if (child + 1 < heapSize && array[child + 1] > array[child]){
                child = child + 1;
            }
            if (array[child] > array[parent]){
                swap(array,child,parent);
            }else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }
    public static void quickSort(int[] array){
        quickSortHelper(array,0,array.length - 1);
    }

    private static void quickSortHelper(int[] array,int left,int right) {
        if (left >= right){
            return;
        }
        int index = partition(array,left,right);
        quickSortHelper(array,0,index - 1);
        quickSortHelper(array,index + 1,right);
    }

    private static int partition(int[] array, int left, int right) {

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

    public static void main(String[] args) {
        int[] array = {9,2,3,7,8,5,1,4};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //quickSort(array);
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
