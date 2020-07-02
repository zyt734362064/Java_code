package com.Test0702;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int m = sc.nextInt();
        if (list.contains(m)){
            for (int i = 0; i < n; i++) {
                if (list.get(i) == m){
                    System.out.println(i);
                }
            }
        }else {
            System.out.println(-1);
        }
    }
}
