package com.Test1110;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-11-16
 */
public class Test {
    public static void main(String[] args) {
        //System.out.println("赵萌");
        /*Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int i = sc.nextInt();
            int j = sc.nextInt();
            int sum = i + j;
            System.out.println(sum);
            */


        for (int h = 0; h < 10;h++){
            if (h < 5) {
                System.out.println("第" + h + "天");
            }else {
                System.out.println("结束");
                break;
            }
        }

    }
}
