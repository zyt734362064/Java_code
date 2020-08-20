package com.Test0820;

import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-20
 */
public class Heap2 {
    public static void shiftDown(int[] array,int size,int index){
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size){
            if (child + 1 < size && array[child] < array[child + 1]){
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
        for (int i = (size - 1 - 1) / 2;i >= 0; i--){
            shiftDown(array,size,i);
        }
    }
    public static void shiftUp(int[] array,int size,int index){
        int child = index;
        int parent = (child - 1) / 2;
        while (child > 0){
            if (array[parent] < array[child]){
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            }else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }
    public static void createHeapUp(int[] array,int size){
        for (int i = 0; i < array.length; i++) {
            shiftUp(array,array.length,i);
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,4,6,8};
        createHeap(array,array.length);
        System.out.println(Arrays.toString(array));
        createHeap(array,array.length);
        System.out.println(Arrays.toString(array));

    }
}
