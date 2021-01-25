package com.TestDay;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2021-01-25
 */
public class Main29_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            float fenzi = cuopai(n);
            float fenmu = factorial(n);
            float result = (fenzi / fenmu) * 100;
            System.out.println(result + "%");
        }
    }

    private static float factorial(int n) {
        float resule = 1;
        if (n == 0){
            return 1;
        }else if (n > 0){
            return n * factorial(n - 1);
        }else {
            return resule;
        }
    }

    private static float cuopai(int n) {
        if (n == 1){
            return 0;
        }else if (n == 2){
            return 1;
        }else {
            return (n-1) * (cuopai(n - 1) + cuopai(n - 2));
        }
    }
}
