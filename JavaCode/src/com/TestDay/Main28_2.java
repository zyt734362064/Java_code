package com.TestDay;

import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:验证密码合格程序
 * https://www.nowcoder.com/questionTerminal/184edec193864f0985ad2684fbc86841
 * User:Zyt
 * Date:2021-01-15
 */
public class Main28_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String password = sc.nextLine();
            if (checkChar(password)&& checkSame(password) && checkLength(password)){
                System.out.println("OK");
            }else {
                System.out.println("NG");
            }
        }
    }

    public static boolean checkLength(String password){
        if (password == null || password.length() < 8){
            return false;
        }else {
            return true;
        }
    }
    public static  boolean checkChar(String password){
        int num = 0,lowercase = 0,uppercase = 0,others = 0;
        char[] charNum = password.toCharArray();
        for (int i = 0; i < charNum.length; i++) {
            if (charNum[i] >= '0' && charNum[i] <= '9'){
                num = 1;
                continue;
            }else if (charNum[i] >= 'a' && charNum[i] <= 'z'){
                lowercase = 1;
                continue;
            }else if (charNum[i] >= 'A' && charNum[i] <= 'Z'){
                uppercase = 1;
                continue;
            }else{
                others = 1;
                continue;
            }
        }
        int sum = num + lowercase + uppercase + others;
        return  (sum) >= 3 ? true : false;
    }
    public static boolean checkSame(String password){

        for (int i = 0; i < password.length() - 2; i++) {
            String str = password.substring(i,i+3);
            if(password.substring(i+1).contains(str)){
                return false;
            }
        }
        return  true;
    }
}
