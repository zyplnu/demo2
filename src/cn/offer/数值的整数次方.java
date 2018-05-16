package cn.offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class 数值的整数次方 {

    public double Power(double base , int exponent){
        if(base == 0)
            return -1;
        if(exponent == 0)
            return 1;
//        int absExponent = exponent > 0 ? exponent : -exponent;
        int absExponent = Math.abs(exponent);
        double result = PowerWithPositive(base , absExponent);
        if(exponent < 0)
            return 1.0 / result;
        return result;
    }

    public double PowerWithPositive(double base , int exponent){
       if(exponent == 0)
           return 1;
       if(exponent == 1)
           return base;
       double result = PowerWithPositive(base , exponent >> 1);
       result *= result;
       if((exponent & 0x1) == 1)
           result *= base;
       return result;
    }

    public static void main(String[] args) {
        数值的整数次方 result = new 数值的整数次方();
        System.out.println(result.Power(2 , 4));
        System.out.println(0x1);
    }

}
