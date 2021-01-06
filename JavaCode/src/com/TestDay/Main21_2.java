package com.TestDay;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2021-01-06
 */
public class Main21_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String words = sc.nextLine();
            char[] chars = words.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c >= 'A'){
                    c = (char)(c > 'E' ? (c - 5) : (c + 21));
                    chars[i] = c;
                }
            }
            System.out.println(new String(chars));
        }
    }
}
