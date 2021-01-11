package com.TestDay;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2021-01-11
 */
public class Main24_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int n = sc.nextInt();
            int ability = sc.nextInt();
            int[] monster = new int[n];
            for (int i = 0; i < n; i++) {
                monster[i] = sc.nextInt();
                if (monster[i] <= ability){
                    ability += monster[i];
                }else {
                    ability += GCD(ability,monster[i]);
                }
            }
            System.out.println(ability);
        }
        sc.close();
    }

    private static int GCD(int a, int b) {
            while (b > 0){
                int tmp = b;
                b = a % b;
                a = tmp;
            }
            return a;
    }
}
