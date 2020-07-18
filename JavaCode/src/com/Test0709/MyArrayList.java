package com.Test0709;

import java.util.Arrays;

/**
 * Create with IntelliJ IDEA
 * Description:review list
 * User:Zyt
 * Date:2020-07-09
 */
public class MyArrayList {
   public int[] elem;//数组
   public int usedSize;//有效的数据个数
   public  static final int capacity = 10;//初始容量

    public MyArrayList() {
        this.elem = new int[capacity];
        this.usedSize = 0;
    }
    //打印顺序表
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
    private boolean isFull(){
        if (this.usedSize == this.elem.length){
            return true;
        }
        return false;
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //1、判断 pos 位置是否合法
        //2、挪数据 当 i< pos 完成
        //3、this.elem[pos] = data;
        if (isFull()){
            this.elem = Arrays.copyOf(this.elem,2 * this.elem.length);
        }
        if (pos > usedSize || pos < 0){
            System.out.println("pos 值不合法");
            return;
        }

        for (int i = usedSize - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;

    }
     // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind == elem[i]){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
     public int search(int toFind) {
         for (int i = 0; i < this.usedSize; i++) {
             if (toFind == elem[i]) {
                 return i;
             }
         }
         return -1;
     }

     //判断是否为空
     private boolean isEmpty(){
        return this.usedSize == 0;

     }

     //判断 pos 值是否合法
     private void checkPos(int pos){
         if (pos > usedSize || pos < 0){
             throw new RuntimeException("pos 值不合法！");
         }
     }
    // 获取 pos 位置的元素
     public int getPos(int pos) {
        //1、顺序表是否为空

         //return pos 位置
         if (isEmpty()){
             //return -1;
             throw new RuntimeException("顺序表为空！");
         }
         //2、判断 pos 合法性
         if (pos < 0 || pos >= this.usedSize){
             throw new RuntimeException("pos 位置不合法！");
         }
        return this.elem[pos];
    }
     // 给 pos 位置的元素设为 value
     public void setPos(int pos, int value) {
        if (pos < 0 || pos >= this.usedSize)
        this.elem[pos] = value;
     }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
       int i = search(toRemove);
       if (i == -1){
           System.out.println("没有需要删除的数字！");
           return;
       }
        while (i < this.usedSize - 1) {
            elem[i] = elem[i+1];
            i++;
        }
        this.usedSize--;
    }
     // 获取顺序表长度
     public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    public void clean(){
        this.usedSize = 0;
    }
}
