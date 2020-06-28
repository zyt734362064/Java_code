package com.Test0628;
import javax.swing.tree.TreeNode;
import java.util.*;

//二叉树平衡检查
/*public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Balance {
    public boolean isBalance(TreeNode root) {
        // write code here
        if(root == null){
            return true;
        }
        int leftHight = getTreeHight(root.left);
        int rightHight = getTreeHight(root.right);
        if (Math.abs(leftHight - rightHight) > 1){
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
    public static int getTreeHight(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(getTreeHight(root.left),getTreeHight(root.right))+ 1;
    }
}
*/