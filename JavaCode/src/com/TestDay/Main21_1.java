package com.TestDay;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:统计每个月兔子的总数
 * 采用递归的方法
 * User:Zyt
 * Date:2021-01-06
 */
public class Main21_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            System.out.println(rabit(num));
        }
    }

    private static int rabit(int n) {
        if (n <= 2){
            return 1;
        }
        return rabit(n - 1) + rabit(n - 2);
    }
}
