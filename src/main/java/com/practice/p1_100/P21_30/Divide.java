package com.practice.p1_100.P21_30;

public class Divide {
    /*
    NO.29 两数相除
    给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

    返回被除数dividend除以除数divisor得到的商。
    整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
    示例1:
    输入: dividend = 10, divisor = 3
    输出: 3
    解释: 10/3 = truncate(3.33333..) = truncate(3) = 3

    示例2:
    输入: dividend = 7, divisor = -3
    输出: -2
    解释: 7/-3 = truncate(-2.33333..) = -2

    提示：
    被除数和除数均为 32 位有符号整数。
    除数不为0。
    假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31− 1]。
    本题中，如果除法结果溢出，则返回 2^31− 1。
     */

    /*
    位运算
    基本思路：10/3，10-3-3-3  res=3
    位运算 a<<n 就是a*2^n   a>>n 就是a/2^n
    通过位运算来减少重复的减法运算
     */
    int solution(int dividend, int divisor){
        if (dividend == 0) return 0;
//        由于参数是两个int，边界溢出只有一种情况，就是下面这一行
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        boolean sign = (dividend > 0)&&(divisor > 0) || (dividend < 0)&&(divisor < 0);
//        定义一个结果标志位，然后把除数被除数，都转成负数，方便运算
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;

        if (dividend == divisor) return sign?1:-1;

        int res = 0;
        while (dividend <= divisor){

            int tempSor = divisor;
            int tempRes = 1;
//            注意此处，需要小于dividend >> 1,如果是小于dividend，会多循环一次
//            上面的想法也错了。不能使用dividend >> 1，因为这样会造成数值的不准确，应该使用dividend - tempSor
            while(tempSor >= (dividend -tempSor)){
               tempSor = tempSor << 1;
               tempRes = tempRes << 1;
            }
            res += tempRes;
            dividend -= tempSor;
        }


        return sign?res:0-res;
    }


}
