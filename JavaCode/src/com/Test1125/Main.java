package com.Test1125;

import java.util.Scanner;
import java.util.Stack;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-11-25
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String l1 = sc.next();
            String[] l2 = l1.split("[^0-9]+");
            int max = 0;
            String result = null;
            for (int i = 0; i < l2.length; i++) {
                int length = l2[i].length();
                if (length > max){
                    result = l2[i];
                    max = length;
                }
            }
            System.out.println(result);
        }
    }
    public boolean chkParenthesis(String A, int n) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (char a : A.toCharArray()) {
            if (a == '(' ){
                stack.push(')');
            }else if (stack.empty() || stack.pop() != a){
                return false;
            }
        }
        return stack.empty();
    }
}
