package com.Test0702;

import java.util.Scanner;

public class Main2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String strIp = sc.nextLine();
            Long numIp = Long.valueOf(sc.nextLine());
            System.out.println(ipToNum(strIp));
            System.out.println(numToIp(numIp));
        }
    }

    private static String numToIp(long numIp) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder numBuilder = new StringBuilder();
        stringBuilder.append(Long.toBinaryString(numIp));
        while    (stringBuilder.length() < 32){
            stringBuilder.insert(0,0);
        }
        for (int i = 0; i < 4; i++) {
            String tmp = stringBuilder.substring(i*8,i*8+8);
            numBuilder.append(Long.valueOf(tmp,2));
            numBuilder.append(".");
        }
        numBuilder.deleteCharAt(numBuilder.length() - 1);
        return numBuilder.toString();
    }

    private static long ipToNum(String strIp) {
        StringBuilder stringBuilderAll = new StringBuilder();
        String[] list = strIp.split("\\.");
        for (int i = 0; i < list.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Long.toBinaryString(Long.valueOf(list[i])) );

            while (stringBuilder.length() < 8){
                stringBuilder.insert(0,0);
            }
            stringBuilderAll.append(stringBuilder);
        }
        return Long.valueOf(stringBuilderAll.toString(),2);
    }
}
