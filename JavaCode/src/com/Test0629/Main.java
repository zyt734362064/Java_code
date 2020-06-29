package com.Test0629;

import java.util.Scanner;
//小易打怪兽
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        int ability = 0;
        while (scanner.hasNext()){
            num = scanner.nextInt();
            ability = scanner.nextInt();
            for (int i = 0; i < num; ++i) {
                int monster = scanner.nextInt();
                if (monster <= ability){
                    ability += monster;
                }else {
                    ability += GCD(ability,monster);
                }

            }
            System.out.println(ability);
        }
        scanner.close();
    }

    private static int GCD(int ability, int monster) {
        while (monster > 0){
            int temp = monster;
            monster = ability % monster;
            ability = temp;
        }
        return ability;
    }
}
