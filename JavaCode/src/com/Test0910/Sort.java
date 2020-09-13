package com.Test0910;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-10
 */
public class Sort {
    public static void insertSort(int[] array){
        for (int bound = 1; bound < array.length; bound++) {
            int cur = bound - 1;
            int v = array[bound];
            while ( cur >= 0){
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

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,1,4,6};

    }
}
