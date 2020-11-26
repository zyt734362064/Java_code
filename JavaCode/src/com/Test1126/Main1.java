package com.Test1126;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-11-26
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            char[] s1 = sc.nextLine().toCharArray();
            String s2 = sc.nextLine();
            for (int i = 0; i < s1.length; i++) {
                if (!s2.contains(String.valueOf(s1[i]))){
                    System.out.print(s1[i]);
                }
            }

        }
    }
}
