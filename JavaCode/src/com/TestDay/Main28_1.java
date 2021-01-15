package com.TestDay;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:守形数
 * 链接：https://www.nowcoder.com/questionTerminal/99e403f8342b4d0e82f1c1395ba62d7b
 * User:Zyt
 * Date:2021-01-15
 */
public class Main28_1  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            shouxingshu(sc.nextInt());
        }
    }

    private static void shouxingshu(int x) {
        int x2 = x * x;
        String s1 = String.valueOf(x);
        String s2 = String.valueOf(x2);
        s2 = s2.substring(s2.length() - s1.length(),s2.length());
        if (s1.equals(s2)){
            System.out.println("Yes!");
        }else {
            System.out.println("No!");
        }
    }
}
