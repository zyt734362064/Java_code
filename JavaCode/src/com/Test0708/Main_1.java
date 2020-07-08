package com.Test0708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-08
 */
public class Main_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String Line = bufferedReader.readLine();
        String[] words = Line.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            System.out.format("%s ",words[words.length - 1 - i]);
        }
        System.out.println(words[0]);
    }
}
