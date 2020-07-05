package com.Test0705;

import java.util.Scanner;

public class Main1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            float num1 = factorial(n);
            float num2 = count(n);
            float result = (num2 / num1)*100;
            System.out.println(String.format("%.2f",result) + "%");
        }
    }

    private static int count(int n) {
        if (n == 1){
            return 0;
        }else if (n == 2){
            return 1;
        }else {
            return (n -1)*(count(n -1) + count(n - 2));
        }

    }

    private static float factorial(int n) {
        float resule = 1;
        if (n == 1){
            return 1;
        }else if (n > 0){
            resule = n * factorial(n -1);
        }
        return resule;
    }
}
