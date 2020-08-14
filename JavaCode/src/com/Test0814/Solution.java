package com.Test0814;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * User:Zyt
 * Date:2020-08-14
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        char[] strS = s.toCharArray();
        char[] strT = t.toCharArray();
        Arrays.sort(strS);
        Arrays.sort(strT);
        System.out.println(strS);
        System.out.println(strT);
        return Arrays.equals(strS,strT);

    }

    public static void main(String[] args) {

            String s = "anagram";
            String t = "nagaram";
            Solution solution = new Solution();
            boolean so = solution.isAnagram(s,t);
            System.out.println(so);


    }
}
