package com.TestDay;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2021-01-13
 */
public class Main27_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            String array = sc.nextLine();
            String[] arrays = array.split(" ");
            String x = sc.next();
            System.out.println(Arrays.asList(arrays).indexOf(x));
        }
    }
}
