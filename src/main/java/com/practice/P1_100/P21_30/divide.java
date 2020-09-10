package com.practice.P1_100.P21_30;

public class divide {
    /*
    NO.29 两数相除
    给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

    返回被除数 dividend 除以除数 divisor 得到的商。
    整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
    示例 1:
    输入: dividend = 10, divisor = 3
    输出: 3
    解释: 10/3 = truncate(3.33333..) = truncate(3) = 3

    示例 2:
    输入: dividend = 7, divisor = -3
    输出: -2
    解释: 7/-3 = truncate(-2.33333..) = -2
 
    提示：
    被除数和除数均为 32 位有符号整数。
    除数不为 0。
    假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。
    本题中，如果除法结果溢出，则返回 231 − 1。
     */

    /*
    位运算
    基本思路：10/3，10-3-3-3  res=3
    位运算 a<<n 就是a*2^n   a>>n 就是a/2^n
    通过位运算来减少重复的减法运算
     */
    int solution(int dividend, int divisor){
        if (dividend == 0) return 0;
        boolean sign = (dividend > 0)&(divisor > 0);
//        相对于正数，负数处理边界更简单
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;

        if (dividend == divisor) return sign?1:-1;



        return 0;
    }

    public static void main(String[] args) {
        System.out.println(11>>1);
    }
}
