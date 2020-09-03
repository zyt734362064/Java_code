package com.Test0902;

import java.util.Stack;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-02
 */
public class Solution {
    public boolean isValid(String s) {
        //先创建一个类
        Stack<Character> stack = new Stack<>();
        //循环遍历字符串中的每个字符
        for (int i = 0;i <s.length();i++){
            char c = s.charAt(i);
            //判定 c 是否是左括号，如果是左括号就入栈
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
                //进入下次循环，取出下一个字符
                continue;
            }
            if (stack.empty()){
                //如果发现当前字符不是左括号，并且栈为空，说明字符串违法
                //这种情况说明前面没有合适的左括号和当前括号匹配
                return false;
            }
            //判定 c 是否是右括号，如果是，就取出栈顶元素进行对比
            char top = stack.pop();
            if (top == '(' && c == ')'){
                continue;
            }
            if (top == '[' && c == ']'){
                continue;
            }
            if (top == '{' && c == '}'){
                continue;
            }
            //除了上面的三种合法情况，剩下的都是非法的
            return false;
        }
        //遍历完字符串后看栈是否为空
        if (stack.empty()){
            return true;
        }
        return false;
    }
}
