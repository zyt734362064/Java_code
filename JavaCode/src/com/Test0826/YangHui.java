package com.Test0826;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-26
 */
public class YangHui {
    public List<List<Integer>> yangHui(int numRows){
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
        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        result.add(second);
        if (numRows == 2){
            return result;
        }

        for (int rows = 3;rows <= numRows; rows++){
            List<Integer> preLines = result.get(rows - 1 - 1);
            List<Integer> curLines = new ArrayList<>();
            for (int col = 2; col < rows; col++){
                curLines.add(1);
                curLines.add(preLines.get(col - 1 - 1) + preLines.get(col - 1));
            }
            curLines.add(1);
            result.add(curLines);
        }
        return result;
    }
}
