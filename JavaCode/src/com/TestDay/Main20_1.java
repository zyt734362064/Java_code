package com.TestDay;

import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:先对数组排序，
 * 用Arrays.sort
 * 取中间的数字进行判断
 * 出现次数是否大于 n / 2
 * User:Zyt
 * Date:2021-01-05
 */
public class Main20_1 {
    public int getValue(int[] gifts, int n) {
        // write code here
        Arrays.sort(gifts);
        int num = 0;
        int a = gifts[n / 2];
        for (int i = 0; i < gifts.length; i++) {
            if (gifts[i] == a) {
                num++;
            }
        }
        return num <= n / 2 ? 0 : a;
    }
}
