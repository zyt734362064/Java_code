package com.TestDay;

import java.util.Scanner;

public class Main24_2 {
    public static void main(String args[]){
        Scanner in =  new Scanner(System.in);


        while(in.hasNextInt()) {
            int numOfStudents = in.nextInt();

            int numOfSql = in.nextInt();


            //将学习成绩放在一个数组

            int[] studentGorce = new int[numOfStudents];

            for(int i = 0;i<numOfStudents;i++) {
                studentGorce[i] = in.nextInt();
            }

            //遇到操作语句：
//          如果是Q:向屏幕输出当前数组的最大值（规定范围内）
//          如果是U：对数组更新

            //读取7条语句
            for(int j =0;j<numOfSql;j++) {

                if(in.next().equals("Q")) {
//               System.out.println("test for q");
                    int beginIndex = in.nextInt();
                    int endIndex = in.nextInt();

                    //判断开始索引是不是小于结束索引，如果不是交换两个数值
                    if(beginIndex > endIndex) {
                        int temp = beginIndex;
                        beginIndex = endIndex;
                        endIndex = temp;
                    }

                    //取范围里面的最大值，遍历一遍，用一个变量存储历史最大值
                    int biggestScore = 0;
                    for(int cur = beginIndex-1;cur<endIndex;cur++) {
                        if(studentGorce[cur]>biggestScore) {
                            biggestScore = studentGorce[cur];
                        }
                    }
                    System.out.println(biggestScore);


                }
                else {
                    int index = in.nextInt();
                    int updataData = in.nextInt();

                    studentGorce[index-1] = updataData;

                }
            }
        }
    }
}