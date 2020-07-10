package com.Test0710;
import java.util.*;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-10
 */
public class GoUpstairs {
    public int countWays(int n) {
        if (n < 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (n == 3){
            return 4;
        }
        int[] A = {1,2,4};
        for (int i = 4; i <= n; i++) {
            int tmp = ((A[1] + A[0])% 1000000007 + A[2]) % 1000000007;
            A[0] = A[1];
            A[1] = A[2];
            A[2] = tmp;
        }
        return  A[2];
    }
}
