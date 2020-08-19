package com.Test0819;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-19
 */
public class TestSort2 {
    //
    public static void heapSort(int[] array){

        createHeap(array);
        int heapSize = array.length;
        for (int i = 0; i < array.length - 1; i++) {
            swap(array,0,heapSize - 1);
            heapSize--;
            shiftDown(array,heapSize,0);
        }
    }

    private static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0;i--){
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
            child = parent * 2 + 1;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0;j < array.length -1;j++){
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
    public static void bubbleSort1(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int cur = array.length - 1; cur > i;cur--){
                if (array[cur] < array[cur - 1]) {
                    swap(array,cur,cur - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,5,3,6,2,4,7};
        bubbleSort1(arr);
        System.out.println(Arrays.toString(arr));
    }
}
