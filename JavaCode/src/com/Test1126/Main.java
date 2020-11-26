package com.Test1126;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:买苹果
 * User:Zyt
 * Date:2020-11-26
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(many(n));
        }
    }

    private static int many(int n) {
        if (n % 2 != 0 || n == 10 || n < 6){
            return -1;
        }
        if (n % 8 == 0){
            return n / 8;
        }else if (n % 6 == 0){
            return n / 6;
        }else {
            return n / 8 + 1;
        }
    }
}
