package com.Test0706;

import java.math.BigInteger;
        import java.util.Arrays;
        import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            BigInteger[] bigIntegers = new BigInteger[N];
            for (int i = 0; i < N; i++) {
                bigIntegers[i] = sc.nextBigInteger();
            }
            Arrays.sort(bigIntegers);
            for (int i = 0; i < N; i++) {
                System.out.println(bigIntegers[i]);
            }
        }
    }
}
