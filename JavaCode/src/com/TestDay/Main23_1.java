package com.TestDay;

import java.util.*;
 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2021-01-08
 */
public class Main23_1 {
    public boolean isBalance(TreeNode root) {
        // write code here
        if (root == null){
            return true;
        }
        int leftTreeHigh = getTreeHigh(root.left);
        int rightTreeHigh = getTreeHigh(root.right);
        if (Math.abs(leftTreeHigh - rightTreeHigh) > 1){
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }

    private int getTreeHigh(TreeNode root) {
            if (root == null){
                return 0;
            }
            return  Math.max(getTreeHigh(root.left) , getTreeHigh(root.right)) + 1;
    }
}
