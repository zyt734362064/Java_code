package com.Test0820;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:此处按大堆实现
 * User:Zyt
 * Date:2020-08-20
 */
public class Heap {
    /**
     *
     * @param array
     * @param size array 中哪部分是堆
     * @param index 从哪个位置开始向下调整
     */
    public static void shiftDown(int[] array,int size,int index){
        int parent = index;
        int child = 2 * parent + 1;
        //这个条件的含义是看看 parent 有没有子节点
        while (child < size){
            // 把左右子树中比较大的节点找到
            if (child + 1 < size && array[child] < array[child + 1]){
                child = child + 1;
            }
            //上述条件结束后，child 肯定对应左右子树中比较大的元素
            //在拿当前的这个 child 和 parent 位置的元素比较一下
            if (array[child] > array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }
    public static void creatHeap(int[] array,int size){
        for (int i = (size - 1 -1) / 2;i>= 0;i--){
            shiftDown(array,size,i);
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8,4};
        creatHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}
