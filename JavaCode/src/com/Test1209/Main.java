package com.Test1209;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-12-09
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.addAB(10, -5));
    }
    public int addAB(int A, int B) {
        // write code here
        int yh = 0;
        int y = 0;
        while (B != 0){
            yh = A ^ B;
            y = (A & B) << 1;
            A = yh;
            B = y;
        }
        return A;
    }
}
