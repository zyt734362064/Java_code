package com.Test0823;

import java.util.HashMap;
import java.util.Map;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-23
 */
public class TestMap {
    public static void main(String[] args) {
        //1、创建 map 实例
        Map<String,String> map = new HashMap<>();
        //2、使用 size 获取到元素的个数（键值对的个数）
        System.out.println(map.size());
        //3、查看是否为空
        System.out.println(map.isEmpty());
        //4、把一些键值对存放进去
        map.put("及时雨","宋江");
        map.put("玉麒麟","卢俊义");
        map.put("智多星","吴用");
        map.put("入云龙","公孙胜");
        //5、使用 get 方法根据 key 来查找对应的value，如果 key 不存在 ，则返回一个 null
        System.out.println(map.get("及时雨"));
        System.out.println(map.get("玉麒麟"));
        System.out.println(map.get("大刀"));
        System.out.println(map.getOrDefault("行者","武松"));
        //6、通过 containsKey 和 containsValue 判定某个值是否存在
        System.out.println(map.containsKey("智多星"));
        System.out.println(map.containsValue("公孙胜"));
        //7、foreach 遍历 Map 中的所有键值对
        for (Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("---------------");
        map.remove("入云龙");
        for (Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        map.clear();
        System.out.println("全部删除后：");
        for (Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
