package cn.concurrent.demo;

public class MyExcption extends RuntimeException{

    public MyExcption() {
        System.out.println("自定义异常");
    }
}
