package com.Test0715;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-15
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[][] op = new int[n][2];
            for (int i = 0; i < n; i++) {
                op[i][0] = sc.nextInt();
                op[i][1] = sc.nextInt();
            }
            stickPuzzle(n,op);
        }
    }
    public static void stickPuzzle(int n,int[][] op){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
            if (op[i][0] == 1){
                list.add(op[i][1]);
            }else {
                list.remove(op[i][1]);
            }
            if (canFormPoly(list)){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }

    }
    public static boolean canFormPoly(ArrayList<Integer> list){
        int len = list.size();
        for (int i = 0; i < len; i++) {
            int temp = list.remove(i);
            int sum = 0;
            for (int j = 0; j < len - 1; j++){
                sum += list.get(j);
            }
            if (sum <= temp){
                list.add(i,temp);
                return false;
            }
            list.add(i,temp);
        }
        return true;
    }
}
