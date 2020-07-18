package com.Test0709;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-09
 */
public class TestDemo {
    public static void main(String[] args) {
        MyArrayList myArrayList1 = new MyArrayList();

        for (int i = 0; i < 10; i++) {
            myArrayList1.add(i,i*10);
        }
       /* myArrayList1.display();
        *//*myArrayList1.add(10,666);
        myArrayList1.display();*//*
        System.out.println("========");
        *//*System.out.println(myArrayList1.search(3));
        System.out.println(myArrayList1.contains(3));*//*
        System.out.println(myArrayList1.getPos(3));
        //System.out.println(myArrayList1.getPos(20));*/

        //System.out.println(myArrayList1.size());
        myArrayList1.display();
/*        myArrayList1.remove(50);
        myArrayList1.display();*/
        myArrayList1.clean();
        System.out.println("==============");
        myArrayList1.display();
        System.out.println("==============");
    }
}
