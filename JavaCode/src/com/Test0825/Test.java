package com.Test0825;

import java.util.HashMap;
import java.util.Map;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-25
 */
public class Test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("及时雨","宋江");
        map.put("玉麒麟","卢俊义");
        for (Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        map.put("及时雨","宋江");
        System.out.println(map);
    }
}
