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
         *          * 第一行固定就是 1
         *          * 第二行也固定就是两个 1
         *          * 第 i 行，首尾元素固定都是 1
         *          * 第 i 行有 i 个元素，
         *          * 对于第 i 行 来说，第 j 列的值就是 i -1 行  j - 1 列值加上 i - 1 行 j 列值之和
         */
        if (numRows <= 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if (numRows == 1){
            return result;
        }
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if (numRows == 2){
            return result;
        }

        /**
         * 接下来处理第 i 行的情况
         * 第 i 行有 i 列
         * (i,j) = (i - 1,j -1) + (i - 1, j)
         * 第一个元素和最后一个元素都是 1
         */
        for (int row = 3;row <= numRows;row++){
            List<Integer> prevLines = result.get(row - 1 - 1);
            List<Integer> curLines = new ArrayList<>();
            curLines.add(1);
            for (int col = 2;col < row;col++){
                int curNum = prevLines.get(col - 1 - 1) + prevLines.get(col - 1);
                curLines.add(curNum);
            }
            curLines.add(1);
            result.add(curLines);
        }

        return result;
    }
}
