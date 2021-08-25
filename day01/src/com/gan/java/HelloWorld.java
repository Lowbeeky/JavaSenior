package com.gan.java;

public class HelloWorld {
    public static void main(String[] args) {
        Student student = new Student();
        student.doEat();
    }
}

class Person{
    public static void eat(){
        System.out.println("人要吃饭");
    }
}

class Student extends Person{
    public void doEat(){
        for (int i = 0; i < 10; i++) {
            if(i%2==0){
                eat();
            }
        }
    }
}
