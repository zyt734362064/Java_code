package com.Test1120;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-11-20
 */

import java.util.*;


public class Solution {
    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        // write code here
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 1;
        while (end <= str1.length()){
            if (str2.contains(str1.substring(start,end))){
                if (sb.length() < end - start){
                    sb.delete(0,sb.length());
                    sb.append(str1,start,end);
                }
                end++;
            }else {
                start++;
            }
        }
        if (sb.length() <= 0){
            return "-1";
        }
        return sb.toString();
    }
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        // write code here
        if (s.length() <= 0 ){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '('){
                stack.push(')');
            }else if (c == '{'){
                stack.push('}');
            }else if (c == '['){
                stack.push(']');
            }else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();

    }

    /**
     * 返回第 K 大的数
     * @param a
     * @param n 数组长度
     * @param K 第 K 大的数
     * @return
     */
    public int findKth(int[] a, int n, int K) {
        // write code here
        if (n <= 0 || K <= 0){
            return -1;
        }
        findKthHelper(a,0,n - 1);
        return a[K - 1];
    }

    private void findKthHelper(int[] a, int left, int right) {
        if (left > right){
            return;
        }
        int num = partition(a,left,right);

        findKthHelper(a,0,num - 1);
        findKthHelper(a,num + 1,right);

    }

    private int partition(int[] a, int left, int right) {
        int base = a[right];
        int i = left;
        int j = right;
        while (i < j){
            while (i < j && a[i] >= base){
                i++;
            }
            while (i < j && a[j] <= base){
                j--;
            }
            if (i < j){
                swap(a,i,j);
            }
        }
        swap(a,i,right);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {9,5,2,7,3,6};
        int q =solution.findKth(a,6,3);
        System.out.println(q);
    }

}