package com.TestDay;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2021-02-02
 */
public class Main41_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int max = nums[0];
            int sum = nums[0];
            for (int i = 1; i < n; i++) {
                if (sum <= 0){
                    sum = nums[i];
                }else {
                    sum += nums[i];
                }
                if (max < sum){
                    max = sum;
                }
            }
            System.out.println(max);

        }
    }
}
