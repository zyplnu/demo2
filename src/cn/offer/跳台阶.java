package cn.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class 跳台阶 {

    public int JumpFloor(int target) {
       int first = 1;
       int second = 2;
       int sum = 0;
       for(int i = 0; i < target - 2; i++){
           /*sum = first + second;
           first = second;
           second = sum;*/
           first = first + second;

       }
       return sum;
    }

    public static void main(String[] args) {
        跳台阶 ttj = new 跳台阶();
        System.out.println(ttj.JumpFloor(4));
    }

}
