package com.Test0820;

import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-20
 */
public class Heap1 {
    public static void shiftDown(int[] array,int size,int index){
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size){
            if (child  + 1 < size && array[child] < array[child + 1]){
                child = child + 1;
            }
            if (array[child] > array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else {
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }
    public static void createHeap(int[] array,int size){
        for (int i = (size - 1 - 1) / 2; i >= size; i--) {
            shiftDown(array,size,i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,5,6,2,7,3,4,1};
        createHeap(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
