package com.Test0819;

import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-19
 */
public class TestSort3 {
    public static void quickSort(int[] array){
        /**
         * 辅助完成递归过程
         * 为了代码简单，区间设置成前闭后闭区间
         */
        quickSortHelper(array,0,array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right){
            return;
        }
        /**
         * 针对 [left,right] 区间进行真理
         * index 返回值就是整理完毕后，left 和 right 的重合位置
         * 知道了这个位置才能进一步进行递归
         */
        int index = partition(array,left,right);
        quickSortHelper(array,left,index - 1);
        quickSortHelper(array,index + 1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[right];
        while (i < j){
            //从左往右找到哦啊哦比基准值大的元素
            while (i < j && array[i] <= base){
                i++;
            }
            //当上面的循环结束的时候，i 要么 和 j 重合，要么找到了比基准值大的值
            //从右往左找比基准值小的元素
            while (i < j && array[j] >= base){
                j--;
            }
            swap(array,i,j);
        }
        swap(array,i,right);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
