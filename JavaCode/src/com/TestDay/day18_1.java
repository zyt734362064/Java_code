package com.TestDay;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2021-01-06
 */
public class day18_1 {
    public static double Radio(String str){
        char[] chars = str.toCharArray();
        double radio = 0;
        double count = 0;
        for (char c : chars){
            if (c == 'G' || c == 'C'){
                count++;
            }
        }
        radio = count / (double)str.length();
        return radio;
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        while (sc.hasNext()){
            String dna = sc.nextLine();
            int num = sc.nextInt();
            double radioMax = 0;
            String strMax = "";
            for (int i = 0; i < dna.length() - num + 1; i++) {
                String str = dna.substring(i,i + num);
                if (Radio(str) > radioMax){
                    strMax = str;
                    radioMax = Radio(str);
                }
            }
            System.out.println(strMax);
        }
    }
}
