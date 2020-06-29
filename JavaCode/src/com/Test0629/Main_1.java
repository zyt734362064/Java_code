package com.Test0629;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int m = 0;
        while (sc.hasNext()){
            n = sc.nextInt();
            m = sc.nextInt();

            int[] stu = new int[n];
            for (int i = 0; i < n; i++){
                stu[i] = sc.nextInt();
            }
            for (int i = 0;i < m;i++) {
                String c = sc.next();
                int a = sc.nextInt();
                int b = sc.nextInt();

                if (c.equals("Q")){
                    int x = Math.min(a,b);
                    int y = Math.max(a,b);

                    int max = stu[x - 1];
                    for (int index = x; index < y; index++){
                        max = Math.max(max,stu[index]);
                    }
                    System.out.println(max);

                }
                if (c.equals("U")){
                    stu[a - 1] = b;
                }
            }
        }
    }
}
