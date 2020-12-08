package com.Test1208;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-12-08
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[10];
        for (int i = 0; i < 10; i++) {
            num[i] = sc.nextInt();
        }
        for (int i = 1; i < 10 ; i++) {
            if (num[i] != 0){
                System.out.print(i);
                num[i]--;
                break;
            }
        }
        while (num[0] != 0){
            System.out.print(0);
            num[0]--;
        }
        for (int i = 1; i < 10; i++) {
            while (num[i] !=0 ) {
                System.out.print(i);
                num[i]--;
            }
        }
    }
}
