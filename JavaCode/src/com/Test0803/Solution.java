package com.Test0803;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-03
 */
public class Solution {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = input.length;
        if (k > len){
            return list;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0;j < len - i - 1;j++){
                if (input[j] < input[j+1]){
                    int tmp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = tmp;
                }
            }
            list.add(input[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] test = {5,3,7,8,9,1};
        ArrayList<Integer> list = GetLeastNumbers_Solution(test,3);
        list.toArray();
    }
}
