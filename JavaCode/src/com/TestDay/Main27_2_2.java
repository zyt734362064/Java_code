package com.TestDay;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2021-01-14
 */
public class Main27_2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String ip = sc.nextLine();
            String ip10 = sc.nextLine();
            System.out.println(switch10(ip));
            System.out.println(switch2(ip10));
        }
    }

    private static long switch10(String s) {
        StringBuffer sb = new StringBuffer();
        String[] num = s.split("\\.");
        for (int i = 0;i < num.length;i++) {
            sb.append(binary(num[i]));
        }
        return Long.parseLong(sb.toString(),2);

    }

    private static String binary(String s) {
        StringBuffer sb = new StringBuffer();
        int num = Integer.parseInt(s);
        int k = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int flag = (num & k) == 0 ? 0 : 1;
            sb.append(flag);
            num = num << 1;
        }
        return sb.toString();
    }

    private static String switch2(String s) {
        StringBuffer sb = new StringBuffer();
        String s2 = Long.toBinaryString(Long.parseLong(s));
        String zero = "";
        for (int i = 0; i < 32 - s2.length(); i++) {
            zero += 0;
        }
        s2 = zero + s2;
        String[] num = new String[4];
        num[0] = s2.substring(0, 8);
        num[1] = s2.substring(8, 16);
        num[2] = s2.substring(16, 24);
        num[3] = s2.substring(24);
        for (int i = 0; i < 4; i++) {
            sb.append(Integer.parseInt(num[i],2));
            if (i != 3) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

}
