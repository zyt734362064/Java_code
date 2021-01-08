package com.TestDay;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2021-01-08
 */
public class Main23_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        int A1 =0;
        int A2 =0;
        int A3 =0;
        int A4 =0;
        int A5 =0;
        int count = 0;
        int flag = 1;
        for (int i = 0;i < N;i++){
            a[i] = sc.nextInt();
            if (a[i] % 5 == 0 && a[i] % 2 == 0){
                A1 += a[i];
            }
            if (a[i] % 5 == 1){
                A2 += flag*a[i];
                flag = -flag;
            }
            if (a[i] % 5 == 2){
                A3++;
            }
            if (a[i] % 5 == 3){
                A4 += a[i];
                count++;
                System.out.println(A4 + " " + count );
            }
            if (a[i] % 5 == 4){
                if (A5 < a[i]){
                    A5 = a[i];
                }
            }
        }
        if (A1 != 0){
            System.out.print(A1 + " ");
        }else {
            System.out.print("N" + " ");
        }
        if (A2 != 0){
            System.out.print(A2 + " ");
        }else {
            System.out.print("N" + " ");
        }
        if (A3 != 0){
            System.out.print(A3 + " ");
        }else {
            System.out.print("N" + " ");
        }
        if (A4 != 0){
            System.out.print(A4 / count + "." + (int)((A4%count*100/count+5)/10)+" ");
        }else {
            System.out.print("N" + " ");
        }
        if (A5 != 0){
            System.out.print(A5);
        }else {
            System.out.print("N");
        }
    }
}
