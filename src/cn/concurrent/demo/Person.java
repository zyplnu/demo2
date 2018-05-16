package cn.concurrent.demo;

public class Person {

    private String name = "Tom";

    public int age = 18;

    public Person() {
    }

    private void say(){
        System.out.println("private say();");
    }

    public void work(){
        System.out.println("public work();");
    }
}
