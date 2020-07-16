package com.Test0716;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-16
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int[][] res = getNearLess(arr);
            for (int i = 0;i < n; i++){
                System.out.println(res[i][0] + " " + res[i][1]);
            }
        }
    }

    public static int[][] getNearLess(int[] arr) {
        ArrayDeque<List<Integer>> stack = new ArrayDeque<>();
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek().get(0)]){
                List<Integer> topList = stack.pop();
                int leftLess = stack.isEmpty() ? - 1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer n : topList){
                    res[n][0] = leftLess;
                    res[n][1] = i;
                }
            }
            if (!stack.isEmpty() && arr[i] == arr[stack.peek().get(0)]){

            }
        }
        return res;
    }
}
