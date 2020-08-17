package com.Test0817;

import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:插入排序
 * User:Zyt
 * Date:2020-08-17
 */
public class TestSort1 {
    public static void insertSort(int[] array){
        //通过 bound 来划分两个区间,[0,bound)已排序区间，[bound,size)待排序区间

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
            //当退出循环的时候，cur 走到了 cur - 1 的位置所以 cur 需要 + 1
            array[cur + 1] = v;
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
