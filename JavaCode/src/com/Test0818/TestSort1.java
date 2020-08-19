package com.Test0818;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-18
 */

import java.util.Arrays;

/**
 * 选择排序
 */
public class TestSort1 {
    public static void selectSort(int[] array){
        for (int bound = 0; bound < array.length;bound++){
            for (int cur = bound + 1;cur < array.length;cur++){
                if (array[cur] < array[bound]){
                    int tmp = array[cur];
                    array[cur] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,2,8,5,3,1,4};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
