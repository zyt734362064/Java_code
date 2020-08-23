package com.Test0824;

import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-24
 */
public class Solution {
    public static boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1,str.length() - 1).contains(s);

    }
    public int numWays(int n) {
        if (n ==  0 || n == 1 ){
            return 1;
        }
        int[] step = new int[n + 1];
        step[1] = 1;
        step[2] = 2;
        for (int i = 3;i <= n; i++){
            step[i] = step[i - 1] + step[i - 2];
            step[i] %= 1000000007;
        }
        return step[n];
    }

    public static void main(String[] args) {
        /*String s ="abc";
        String s1 ="abcabc";
        String s2 ="ababa";
        String s3 ="aba";
        boolean a = repeatedSubstringPattern(s);
        boolean a1 = repeatedSubstringPattern(s1);
        boolean a2 = repeatedSubstringPattern(s2);
        boolean a3 = repeatedSubstringPattern(s3);
        System.out.println(a);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);*/
        int n = 7;
        Solution solution = new Solution();
        int num = solution.numWays(n);
        System.out.println(num);
    }
}
