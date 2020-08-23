package com.Test0823;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-23
 */
public class TestCollection {
    public static void main(String[] args) {
        //创建 Collection
        Collection<String> collection = new ArrayList<>();
        //使用 size 方法
        System.out.println(collection.size());
        //使用 isEmpty 方法
        System.out.println(collection.isEmpty());
        //使用 add 方法插入元素
        collection.add("我");
        collection.add("爱");
        collection.add("Java");
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        //可以 toArray 把 Collection 转换成数组
        //得到的结果是 Object[]
        Object[] array = collection.toArray();
        System.out.println(Arrays.toString(array));
        //可以直接使用 for 循环来遍历集合中的元素
        for (String s : collection){
            //s 就会分别指向 collection 中的每一个元素
            System.out.print(s);
        }
        System.out.println();
        //使用 contains 方法判定元素是否存在
        System.out.println(collection.contains("我"));
        //删除元素
        collection.remove("我");
        for (String s : collection){
            //s 就会分别指向 collection 中的每一个元素
            System.out.print(s);
        }
        System.out.println();
        collection.clear();
        System.out.println("清空元素后");
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());

    }
}
