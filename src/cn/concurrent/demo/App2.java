package cn.concurrent.demo;

public class App2 {

    public static void main(String[] args) {
        UserDao target = new UserDao();
        System.out.println(target.getClass());
        UserDao proxy = (UserDao) new ProxyFactory2(target).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();

        String str = new String("haha");
        System.out.println(String.class.getName());
    }

}
