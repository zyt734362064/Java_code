package com.TestDay;
import java.util.*;
/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2021-01-04
 */
public class Main19_1 {


    public class Substr {
        public boolean[] chkSubStr(String[] p, int n, String s) {
            // write code here
            boolean[] returnStr = new boolean[p.length];
            for (int i = 0; i < p.length; i++) {
                returnStr[i] = s.contains(p[i]);
            }
            return returnStr;
        }
    }
}
