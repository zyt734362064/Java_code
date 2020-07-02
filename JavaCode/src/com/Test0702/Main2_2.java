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
        //现将这个字符串转换成二进制数
        stringBuilder.append(Long.toBinaryString(numIp));
        //如果这个数字不足32位，就在前面添加 0
        while    (stringBuilder.length() < 32){
            stringBuilder.insert(0,0);
        }
        //分成四组，将每一组的8位数字
        // 将这个八位数字转换成十进制
        //并且在后面添加一个“·”做分隔
        for (int i = 0; i < 4; i++) {
            String tmp = stringBuilder.substring(i*8,i*8+8);
            numBuilder.append(Long.valueOf(tmp,2));
            numBuilder.append(".");
        }
        //删除掉最后一个多出来的点
        numBuilder.deleteCharAt(numBuilder.length() - 1);
        //以字符串的形式返回这个修改后的数字
        return numBuilder.toString();
    }

    private static long ipToNum(String strIp) {
        StringBuilder stringBuilderAll = new StringBuilder();
        //根据“.”将二进制数字分隔成 4 个二进制数
        String[] list = strIp.split("\\.");
        for (int i = 0; i < list.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();//
            //把每一段的二进制数转换成二进制数
            //并且暂存进一个stringBuilder 中
            stringBuilder.append(Long.toBinaryString(Long.valueOf(list[i])) );
            //写一个循环 当这个数字不足 8 位的时候就在前面加 0
            while (stringBuilder.length() < 8){
                stringBuilder.insert(0,0);
            }
            //把这几个 stringbuilder 组合在一起
            stringBuilderAll.append(stringBuilder);
        }
        //再将这个数字转换成 十进制数
        return Long.valueOf(stringBuilderAll.toString(),2);
    }
}
