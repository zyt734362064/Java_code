package com.Test0908;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:最大公约数和最小公倍数
 * User:Zyt
 * Date:2020-09-08
 */
public class TestCount {
    /**
     * 求最大公约数
     * 用辗转相处法小树除大数
     * 得到的余数继续除刚刚的除数
     * 然后第二余数除以第一余数
     * 直到余数为零时，得到的
     */
    public static int Gcd(int m,int n){
        if (m < n){
            int tmp = m;
            m = n;
            n = tmp;
        }
        if (m % n == 0){
            return n;
        }
        return Gcd(n,m%n);

    }
    public static int Lcm(int m,int n){
        return m * n / Gcd(m,n);
    }
    public static void main(String[] args){
/*        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println("最大公约数为：" + Gcd(m,n));
            System.out.println("最小公倍数为：" + Lcm(m,n));

        }*/
        String s = "abcab";
        String s1 = s + s;
        System.out.println(s1);
        String s2 =  s1.substring(1,s1.length() -1);
        System.out.println(s2);
        System.out.println(s2.contains(s));
    }
}
