package Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-15
 */
public class TestGson {
    static class Student{
        private String name;
        private int id;
        private double score;

        public Student(String name, int id, double score) {
            this.name = name;
            this.id = id;
            this.score = score;
        }
    }
    public static void main(String[] args) {

        //实例化 Gson 对象（工厂模式)
        Gson gson = new GsonBuilder().create();
        //把一个对象转成 JSON 字符串
        Student student = new Student("zzz",10,90);
        String jsonString = gson.toJson(student);
        System.out.println(jsonString);
        //把一个 JSON 字符串转回成一份对象
        String str = "{\"name\":\"zzz\",\"id\":10,\"score\":90.0}";
        Student s = gson.fromJson(str,Student.class);
        System.out.println(s.id + "," + s.name +"," + s.score);
    }
}
