package com.Test1125;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:统计回文
 * User:Zyt
 * Date:2020-11-25
 */

public class Main1 {
    public static boolean isHuiWen(String s){
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s1 = scanner.nextLine();
            String s2 =scanner.nextLine();
            int count = 0;
            for (int i = 0; i <= s1.length(); i++) {
                StringBuilder sb = new StringBuilder(s1);
                sb.insert(i,s2);
                if (isHuiWen(sb.toString())){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
