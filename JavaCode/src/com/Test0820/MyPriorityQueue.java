package com.Test0820;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-20
 */
public class MyPriorityQueue {
    private int[] array = new int[100];
    private int size = 0;

    public void offer(int x){
        array[size] = x;
        size++;
        //把新加入的元素进行向上调整
    }
    public static void shiftUp(int[] array,int size,int index){
        int child = index;
        int parent = (child - 1) / 2;
        while (child > 0){
            if (array[child] > array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }
}
