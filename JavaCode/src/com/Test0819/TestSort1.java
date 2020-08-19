package com.Test0819;

import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:堆排
 * User:Zyt
 * Date:2020-08-19
 */
public class TestSort1 {
    //堆排序
    private static void swap(int[] array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void heapSort(int[] array){
        //先建立堆
        createHeap(array);
        int heapSize = array.length;
        //循环把堆顶元素交换到最后，并进行调整
        //循环此时是 length - 1，当堆中只剩下一个元素的时候，也就一定是有序的了
        for (int i = 0; i < array.length - 1; i++) {
            swap(array,0,heapSize - 1);
            //交换完成后，要把最后一个元素从堆中删除，对的长度就变成 array - i -1
            heapSize--;
            shiftDown(array,heapSize,0);
        }
    }

    private static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2;i >= 0;i--){
            shiftDown(array,array.length,i);
        }
    }

    private static void shiftDown(int[] array, int heapLength, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < heapLength){
            if (child + 1 < heapLength && array[child + 1] > array[child]){
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
    public static void main(String[] args) {
        int[] arr = {9, 2, 8, 5, 3, 1, 4};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
