package com.Test0708;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:简单错误记录
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名和行号
 * 1、记录最多8条错误记录，对相同对错误记录（即文件名称和行号完全匹配）只记录一条，错误计数增加；
 * （文件所在目录不同文件名和行号相同也要合并）
 * 2、超过16个字符的文件名称，只记录文件的最后有效16 个字符；（如果文件名不同，而是文件名的候16个字符和行号相同，也要
 * 合并）
 * 3、输入的文件可能带路径，记录文件名称不能带路径
 * User:Zyt
 * Date:2020-07-08
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String,Integer>map = new LinkedHashMap<String,Integer>();
        while (in.hasNext()){
            String path = in.next();
            int id = path.lastIndexOf('\\')

        }
    }

}
