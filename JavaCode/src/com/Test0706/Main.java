package com.Test0706;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            jiCheck(str.toCharArray());
        }
    }

    private static void jiCheck(char[] chars) {
        int[] result = new int[8];
        for (int i = 0; i < chars.length; i++) {
            int n = 0x01;
            int count = 0;
            int index = 7;
            while (index > 0){
                result[index] = (chars[i] & n) == 0 ? 0 : 1;
                if (result[index] == 1){
                    count++;
                }
                n <<= 1;
                index--;
            }
            result[0] = (count % 2 == 1) ? 0 : 1;
            for (int k =0;k < 8;k++){
                System.out.print(result[k]);

            }
            System.out.println();
        }
    }
}
