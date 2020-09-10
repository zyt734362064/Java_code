package com.Test0910.test;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-10
 */
public class Person {
    private String name;
    private String password;
    private int id;

    public Person(String name, String password, int id) {
        this.name = name;
        this.password = password;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        /*ObjectMapper objectMapper = new ObjectMapper;
        Person person = new Person("aaa","123",1);
        String jsonString = objectMapper.writeVaulerAsString(person);
        System.out.println(jsonString);*/

    }
}
