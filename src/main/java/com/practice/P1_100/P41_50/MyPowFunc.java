package com.practice.P1_100.P41_50;

public class MyPowFunc {
    /*
    NO.50 pow(x,n)
    实现 pow(x, n) ，即计算 x 的 n 次幂函数。
    -100.0 < x < 100.0
    n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
     */
    double myPow(double x,int n){
        if (x == 1 || n == 0) return 1;
        if (n < 0) return 1/myPow(x,-n);
        double temp = myPow(x,n/2);
        if (n % 2 == 0) return temp * temp;
        return x * temp * temp;
    }

    public static void main(String[] args) {
        MyPowFunc m = new MyPowFunc();
//        System.out.println(m.myPow(0.00001, 2147483647));
        System.out.println(Integer.MAX_VALUE);
    }
}
