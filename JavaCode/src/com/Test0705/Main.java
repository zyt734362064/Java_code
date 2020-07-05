package com.Test0705;

import java.util.Scanner;

//年会抽奖
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            float sum1 = factorial(n);
            float sum2 = count(n);
            float result1 = (sum2 / sum1)*100;
            System.out.println(String.format("%.2f",result1) + "%");
        }
    }
//错拍算法
    public static float count(int n) {
        if (n == 1){
            return 0;
        }else if (n == 2){
            return 1;
        }else {
            return (n - 1)*(count(n - 1)+ count(n -2));
        }
    }

    public static float factorial(int num) {
        float resule = 1;
        if (num == 1){
            return 1;
        }else if (num > 0){
            resule = num * factorial(num - 1);
        }
        return resule;
    }

}
