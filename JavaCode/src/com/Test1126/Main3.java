package com.Test1126;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:汽水瓶
 * User:Zyt
 * Date:2020-11-26
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            long sum = 0;
            while (n > 2){
                sum = sum + n / 3;
                n = n / 3 + n % 3;
            }
            if (n == 2){
                sum = sum + 1;
            }
            System.out.print(sum);
        }
    }
}
