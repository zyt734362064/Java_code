package com.TestDay;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2021-01-07
 */
public class Main22_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String have = sc.next();
            String need = sc.next();
            Map<Character,Integer> h = new HashMap<>();
            for (char hC : have.toCharArray()){
                if (h.containsKey(hC)){
                    h.put(hC,h.get(hC) + 1);
                }else {
                    h.put(hC,1);
                }
            }
            Map<Character,Integer> n = new HashMap<>();
            for (char hN:need.toCharArray()){
                if (n.containsKey(hN)){
                    h.put(hN,n.get(hN));
                }else {
                    h.put(hN,1);
                }
            }
            Boolean isBuy = true;
            int num = 0;
            for (Map.Entry<Character,Integer> e:n.entrySet()){
                char key = e.getKey();
                int value = e.getValue();
                if (h.containsKey(key) && value > h.get(key)){
                    isBuy = false;
                    num += value - h.get(key);
                }else if (!h.containsKey(key)){
                    isBuy = false;
                    num += value;
                }
            }
            if (isBuy){
                System.out.println("Yes " + (have.length() - need.length()));
            }else {
                System.out.println("NO " + num);
            }
        }
    }
}
