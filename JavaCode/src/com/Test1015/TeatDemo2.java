package com.Test1015;

import com.Test1015.demo1.Animal;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-10-15
 */

class Base {
    public int a;
}
class Derive extends Base {
    public int b;
}


public class TeatDemo2 extends Animal {
    public void func(){
        Animal animal = new Animal();
        System.out.println(super.name);
    }

    public static void main(String[] args) {


    }
}

