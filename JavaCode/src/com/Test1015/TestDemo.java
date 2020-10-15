package com.Test1015;

import javax.lang.model.element.AnnotationMirror;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-10-15
 */
class Animal {
    public String name;

    public void sleep(){
        System.out.println(this.name + "Animal::sleep()");
    }
    public void eat(){
        System.out.println(this.name + "Animal::eat()");
    }
    public Animal(String name) {
        this.name = name;
        System.out.println("Animal(String)");
    }
}

class Cat extends Animal{
    public int count = 99;
    public Cat(String name){
        super(name);
        System.out.println("Cat(String)");
    }
    @Override
    public void eat(){
        System.out.println(this.name  + "猫实现的 Cat:eat()");
    }
}
class Bird extends Animal {
public Bird(String name){
        super(name);
        };
@Override
public void eat(){
        System.out.println(this.name +  "Bird::eat()");
        }
public void fly(){
        System.out.println(this.name + "Bird::fly()");
        }
        }
public class TestDemo {

    public static void main1(String[] args) {
        Cat cat = new Cat("mimi");
        Animal animal = new Animal("豆豆");
    }

    public static void main2(String[] args) {
        Animal animal = new Cat("咪咪");//父类引用子类对象
        animal.eat();

    }

    public static void main3(String[] args) {
        Animal animal = new Cat("小猫咪");
        animal.eat();
    }

    public static void main4(String[] args) {
        Animal animal = new Bird("鹦鹉");
        Bird bird = (Bird) animal;
        bird.fly();
    }

    public static void main(String[] args) {
        Animal animal = new Cat("八哥");

        //A instanceof B 判断 A 是不是 B 的一个实例
        if (animal instanceof  Bird){
            Bird bird = (Bird) animal;
            bird.fly();
        }else {
            System.out.println("不是!不能向下转型!");
        }

    }
}
