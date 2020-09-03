package com.Test0902;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-02
 */
public class Solution1_2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c== '['){
                stack.push(c);
                continue;
            }
            if (stack.empty()){
                return false;
            }
            char top =  stack.pop();
            if (map.get(top) == c){
                continue;
            }
            return false;
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }
}
