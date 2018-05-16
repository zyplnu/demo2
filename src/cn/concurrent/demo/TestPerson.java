package cn.concurrent.demo;

public class TestPerson {

    public static void main(String[] args) throws ClassNotFoundException {


        Class c = Class.forName("cn.concurrent.demo.Person");

        System.out.println(c.getName());
    }

}
