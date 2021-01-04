package com.Test1209;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-12-10
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        while (x-- > 0){
            int n = sc.nextInt();
            int s = sc.nextInt();
            int[] card = new int[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                int tmp = i + 1;
                for (int j = 0;j < s;j++){
                    if (tmp <= n){
                        tmp = 2 * tmp - 1;

                    }else {
                        tmp = 2 * (tmp - n);
                    }
                }
                card[tmp - 1] = sc.nextInt();
            }
            if (card.length > 0){
                System.out.print(card[0]);
            }
            for (int i = 1;i < 2 * n;i++){
                System.out.print(" " + card[i]);
            }
            System.out.println();
        }

    }
}
