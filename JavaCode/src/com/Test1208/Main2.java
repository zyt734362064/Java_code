package com.Test1208;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-12-08
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long m = sc.nextLong();
            long a = m * (m - 1) + 1;
            System.out.print(a);
            for (int i = 1; i < m; i++) {
                System.out.print("+" + (a+=2));
            }
            System.out.println();
        }
    }
}
