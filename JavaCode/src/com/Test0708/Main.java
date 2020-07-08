package com.Test0708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create with IntelliJ IDEA
 * Description:编程题说反话
 * 给定一句英语，编写程序，将句中的所有单词顺序颠倒输入
 * User:Zyt
 * Date:2020-07-08
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        String[] words = line.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            System.out.format("%s ",words[words.length - 1 - i]);
        }
        System.out.println(words[0]);
    }
}
