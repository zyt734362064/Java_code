package com.Test1208;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:尼科彻斯定理
 * User:Zyt
 * Date:2020-12-08
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            long m = Integer.valueOf(s);
            long a = m * (m - 1) + 1;
            System.out.print(a);
            for (int i = 1; i < m; i++) {
                System.out.print("+" + (a+=2));
            }
            System.out.println();
        }
    }
}
