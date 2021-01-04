package com.TestDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2021-01-04
 */
public class Main19_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int option = sc.nextInt();
            List<Student> studentList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                studentList.add(new Student(sc.next(),sc.nextInt()));
            }
            if (option == 0){
                studentList.sort(((o1, o2) -> o2.score - o1.score));
            }else if (option == 1){
                studentList.sort(((o1, o2) -> o1.score - o2.score));
            }
            for (Student student:studentList){
                System.out.println(student.name + " " +student.score);
            }
        }
    }

   static class Student{
        public String name;
        public int score;

       public Student(String name, int score) {
           this.name = name;
           this.score = score;
       }
   }
}
