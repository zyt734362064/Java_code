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

    public static void postOrder(Node root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        Node root = build();
        System.out.println("先序遍历:");
        preOrder(root);
        System.out.println();
        System.out.println("中序遍历：");
        inOrder(root);
        System.out.println();
        System.out.println("后序遍历：");
        postOrder(root);
    }
}
