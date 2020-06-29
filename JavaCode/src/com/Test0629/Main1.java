package com.Test0629;

import java.util.Scanner;

//最高分是多少
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int m = 0;
        while (sc.hasNext()){
            n = sc.nextInt();
            m = sc.nextInt();
            int[] stu = new int[n];
            for (int i = 0; i < n; i++) {
                stu[i] = sc.nextInt();
            }
            //老师询问
            for (int i = 0; i < m; i++){
                String c = sc.next();
                int a = sc.nextInt();
                int b = sc.nextInt();

                if (c.equals("Q")){
                    int s = Math.min(a,b);//开始下标
                    int e = Math.max(a,b);//结束下标\
                    int max = stu[s - 1];
                    for (int index = s;index < e; index++){
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
