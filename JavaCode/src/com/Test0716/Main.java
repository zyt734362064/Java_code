package com.Test0716;

import java.util.*;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-16
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int arr[] = new int[n];
            int x = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                x ^= arr[i];
            }
            int index = 0;
            for (int i = 0; i < 32; i++) {
                if (((x >> 1) & 1) == 1){
                    index = 1;
                    break;
                }
            }
            int num1 = 0;
            int num2 = 0;
            for (int i = 0; i < n; i++) {
                if (((arr[i] >> index) & 1 ) == 1){
                    num1 ^= arr[i];
                }else {
                    num2 ^= arr[i];
                }
            }

            if (num1 >= num2){
                System.out.println(num1 +" " + num2);
            }else {
                System.out.println(num1 + " " + num2);
            }


        }

    }
}
