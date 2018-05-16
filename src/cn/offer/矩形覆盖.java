package cn.offer;
/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class 矩形覆盖 {

    public int RectCover(int target) {
        if(target < 1)
            return 0;
        if(target == 1 || target == 2)
            return target;
        int first = 1;
        int second = 2;
        while(target-- > 2){
            second += first;
            first = second - first;
        }
        return second;
    }

    public static void main(String[] args) {
        矩形覆盖 jx = new 矩形覆盖();
        System.out.println(jx.RectCover(5));
    }

}
