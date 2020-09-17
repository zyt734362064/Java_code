package com.Test0917;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-17
 */
class Node{
    public char val;
    public Node left;
    public Node right;
    public Node(char val){
        this.val = val;
    }
}
public class TestTree {
    public static Node build(){
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        g.right = h;
        c.right = f;

        return a;
    }
    public static  void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    /**
     * 求二叉树中节点的个数
     * @param root
     */
    public static int size(Node root){
        if (root == null){
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    public static void postOrder(Node root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 求二叉树叶子节点的个数
     *
     */
    public static int leafSize(Node root){
       if (root == null){
           return 0;
       }
       if (root.left == null && root.right == null){
           return 1;
       }
       return leafSize(root.left) + leafSize(root.right);
    }

    /**
     * 求二叉树第 k 层节点的个数
     * 如果 k < 1 只能是空树，直接返回 1
     * 如果 k == 1 求根节点个数，直接返回 1
     * k 层节点个数 = 左子树 k - 1 层节点个数 + 右子树 k - 1 层节点个数
     * @param root
     * @return
     */
    public static int kLevel(Node root,int k){

        if (k < 1 || root == null){
            return 0;
        }
        if (k == 1){
            return 1;
        }
        return kLevel(root.left,k - 1) + kLevel(root.right,k - 1);
    }

    /**
     * 二叉树中查找指定元素
     * @param root
     * @param toFind
     * @return
     */
    Node find(Node root,char toFind){
        if (root == null){
            return null;
        }
        if (root.val == toFind){
            return root;
        }
        Node result = find(root.right,toFind);
        if (result != null){
            return result;
        }
        return find(root.right,toFind);
    }

    public static void main(String[] args) {
        Node root = build();
/*        System.out.println("先序遍历:");
        preOrder(root);
        System.out.println();
        System.out.println("中序遍历：");
        inOrder(root);
        System.out.println();
        System.out.println("后序遍历：");
        postOrder(root);*/

        System.out.println(kLevel(root,3));
    }


}
