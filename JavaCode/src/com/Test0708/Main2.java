package com.Test0708;

import java.util.*;

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
            int id = path.lastIndexOf('\\');
            String fileName = id == -1 ? path : path.substring(id + 1);
            int line = in.nextInt();
            String key = fileName + " " + line;
            if (map.containsKey(key)){
                map.put(key,map.get(key) + 1);
            }else {
                map.put(key,1);
            }

        }
        List<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int m = 0;
        for (Map.Entry<String,Integer>mapping : list){
            if (m >=  8){
                break;
            }
            String[] str = mapping.getKey().split(" ");

            String filename = str[0];
            if (filename.length() > 16){
                filename = filename.substring(filename.length() - 16);

            }
            String n = str[1];
            Integer count = mapping.getValue();
            System.out.printf("%s %s %d%n",filename,n,count);
            m++;
        }
    }

}
