package cn.offer;
/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 */
public class 二进制中1的个数 {

    public int NumberOf1(int n){
        int count = 0;
        while(n != 0){
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    /**
     * 判断一个整数是不是2的整数次方
     * @param n
     * @return
     */
    public boolean isTrue(int n){
        if(((n - 1) & n) == 0)
            return true;
        return false;
    }

    /**
     * 输入两个整数m和n，计算需要改变m的二进制表示中的多少位可以得到n
     * @param m
     * @param n
     * @return
     */
    public int getW(int m , int n){
        int result = m ^ n;
        int count = 0;
        while(result != 0){
            count++;
            result = (result - 1) & result;
        }
        return count;
    }

    public static void main(String[] args) {
        二进制中1的个数 num = new 二进制中1的个数();
        System.out.println(num.getW(10 , 13));
    }

}
