package com.Test0702;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String strIp = sc.nextLine();
            long numIP = Long.valueOf(sc.nextLine());
            System.out.println(ipToNum(strIp));
            System.out.println(numToIp(numIP));
        }
    }

    private static String numToIp(long numIP) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder numBuilder = new StringBuilder();
        stringBuilder.append(Long.toBinaryString(numIP));
        while (stringBuilder.length() < 32){
            stringBuilder.insert(0,0);
        }
        for (int i = 0; i < 4; i++) {
            String temp = stringBuilder.substring(i*8,i*8 +8);
            numBuilder.append(Long.valueOf(temp,2));
            numBuilder.append(".");

        }
        numBuilder.deleteCharAt(numBuilder.length() - 1);
        return numBuilder.toString();
    }

    private static long ipToNum(String strIp) {
        String[] strlist = strIp.split("\\.");
        StringBuilder stringBuilderAll = new StringBuilder();
        for (int i = 0; i < strlist.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Long.toBinaryString(Long.valueOf(strlist[i])));
            while (stringBuilder.length() < 8){
                stringBuilder.insert(0,0);
            }
            stringBuilderAll.append(stringBuilder);

        }
        return Long.valueOf(stringBuilderAll.toString(),2);

    }
}
