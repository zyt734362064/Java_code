package com.Test0710;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-10
 */
public class GoUpstairs_1 {
    public int GoUpsstairs(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (n == 3){
            return  4;
        }
        int[] A = {1,2,4};
        for (int i = 4; i <= n ; i++) {
            int tmp = ((A[0] + A[1]) % 1000000007 + A[2]) % 1000000007;
            A[0] = A[1];
            A[1] = A[2];
            A[2] = tmp;
        }
        return A[2];
    }

    public static void main(String[] args) {
        GoUpstairs_1 goUpstairs_1 = new GoUpstairs_1();
        System.out.println(goUpstairs_1.GoUpsstairs(5));
    }
}
