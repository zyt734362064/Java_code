package com.Test1110;

import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-11-10
 */
public class Main {
    public int minNumberInRotateArray(int [] array) {
        if (array.length < 1){
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = left;
        while (array[left] >= array[right]){
            if (right - left <= 1){
                mid = right;
                break;
            }
            mid = ( right - left ) / 2;
            if (array[left] == array[right] && array[mid] == array[left] ){
                return MinIndex(array,left,right);
            }
            if (array[mid] > array[left]){
                left = mid;
            }else if(array[mid] > array[right]){
                right = mid;
            }

        }
        return array[mid];
    }

    private int MinIndex(int[] array, int left, int right) {
        int result = array[left];
        for (int i = array[left + 1];i<= array.length - 1;i++){
            if (result > array[i]){
                result  = array[i];

            }
        }
        return result;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] array = {3,4,5,1,2};
        System.out.println(Arrays.toString(array));
        int s = main.minNumberInRotateArray(array);
        System.out.println(s);
    }
}
