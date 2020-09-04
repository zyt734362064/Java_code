package com.Test0904;

import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-04
 */
public class Main{
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0;j < array.length - 1;j++){
                if (array[j] > array[j + 1]){
                    int tmp = array[j];
                     array[j] = array[j +1];
                     array[j + 1] = tmp;
                }
            }
        }
    }
    private static void swap(int[] array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void headSort(int[] array){
        createHeap(array);
        int heapSize = array.length;
        for (int i = 0;i < array.length -1 ;i++){
            swap(array,0,heapSize - 1);
            heapSize--;
            shiftDown(array,heapSize,0);
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

    private static void createHeap(int[] array) {
        for (int i = (array.length - 1 -1); i >= 0; i--) {
            shiftDown(array,array.length - 1,i);

        }
    }


    public static void selectSort(int[] array){
        for (int i = 0;i < array.length;i++){
            for (int j = i + 1;j < array.length; j++){
                if (array[i] > array[j]){
                    swap(array,i,j);
                }
            }
        }
    }
    public static void insertSort(int[] array){
        for (int bound = 1;bound <array.length;bound++){
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

    public static void quickSort(int[] array){
        quickSortHelper(array,0,array.length - 1);
    }

    private static void quickSortHelper(int[] array,int left,int right){
        if (left >= right){
            return;
        }
        int index = partition(array,left,right);
        quickSortHelper(array,0,index - 1);
        quickSortHelper(array,index + 1,right);
    }

    private static int partition(int[] array, int left, int right) {
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
            if (i < j) {
                swap(array,i,j);
            }
        }
        swap(array,i,right);
        return i;
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
