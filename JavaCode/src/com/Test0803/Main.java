package com.Test0803;


import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:输出最长的数字串
 * User:Zyt
 * Date:2020-08-03
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            int count = 0;
            int max = 0;
            int last = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    count++;
                    if (count > max ){
                        max = count;
                        last = i;
                    }
                }else {
                    count = 0;
                }
            }
            System.out.println(str.substring(last - max + 1,last + 1));
        }

    }
}
