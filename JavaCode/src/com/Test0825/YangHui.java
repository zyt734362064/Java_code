package com.Test0825;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-25
 */
public class YangHui {
    public List<List<Integer>> generate(int numRows) {
        /**
         * 杨辉三角特点：
         * 第一行固定就是 1
         * 第二行也固定就是两个 1
         * 第 i 行，首尾元素固定都是 1
         * 第 i 行有 i 个元素，
         * 对于第 i 行 来说，第 j 列的值就是 i -1 行  j - 1 列值加上 i - 1 行 j 列值之和
         */
        if (numRows <= 0){
            return new ArrayList<>();
        }

    }
}
