package com.TestDay;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:整数与IP地址间的转换
 * https://www.nowcoder.com/questionTerminal/66ca0e28f90c42a196afd78cc9c496ea
 * User:Zyt
 * Date:2021-01-14
 */
public class Main_27_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String ip = sc.nextLine();
            String ip10 = sc.nextLine();
            System.out.println(switch10(ip));
            System.out.println(switch2(ip10));
        }
    }

    private static String switch2(String s) {
        StringBuffer sb = new StringBuffer();
        String ip2 = Long.toBinaryString(Long.parseLong(s));
        String zero = "";
        for (int i = 0; i < 32 - ip2.length(); i++) {
            zero += 0;
        }
        ip2 = zero + ip2;
        String[] ips =  new String[4];
        ips[0] = ip2.substring(0,8);
        ips[1] = ip2.substring(8,16);
        ips[2] = ip2.substring(16,32);
        ips[3] = ip2.substring(32);

        for (int i = 0; i < 4; i++) {

            sb.append(Integer.parseInt(ips[i],2));
            if (i != 3){
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private static long switch10(String ip) {
        String[] ips = ip.split("\\.");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ips.length; i++) {
            sb.append(binary(ips[i]));
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
}
