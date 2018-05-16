package cn.concurrent.demo;

public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("start transaction...");
        target.save();
        System.out.println("end transaction...");
    }
}
