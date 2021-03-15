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
        if (n == 1) return  x;
//        这里有问题，n太大了，超出了double temp的范围
        if (n == Integer.MIN_VALUE) return 1.0 / myPow(x,-(n/2)) * myPow(x,-(n/2));
        if (n < 0) return 1 / myPow(x,-n);
        double temp = myPow(x,n / 2);
        if (n % 2 == 0) return temp * temp;
        return x * temp * temp;
    }



    /*
    官方答案中的解法，用long规避了溢出的情况。。。直接返回0.0,也是服了。。。对于Integer.MAX_VALUE的情况依然展示成Infinity
    如果要是按照答案这种耍流氓，那我用myPow3的方法也能解决这个场景，感觉这答案真鸡儿双标，明明是在已有题意中，无法断言的case，非要检查这个case
    你检查个什么劲呢，对于Nan和0.0有什么区别和意义么，都是错误的
     */
    public double myPow2(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    double myPow3(double x,int n){
        if (x == 1 || n == 0) return 1;
        if (n == 1) return  x;
//        这里有问题，n太大了，超出了double temp的范围，所以递归的这种，需要添加
        if (n == Integer.MIN_VALUE){
            double temp = myPow(x,-(n/2));
            return temp == Double.POSITIVE_INFINITY?0.0 : 1.0 / (temp * temp);
        }
        if (n < 0) return 1 / myPow(x,-n);
        double temp = myPow(x,n / 2);
        if (n % 2 == 0) return temp * temp;
        return x * temp * temp;
    }

        public static void main(String[] args) {
        MyPowFunc m = new MyPowFunc();
        int n = Integer.MAX_VALUE;
//        int n = 16;
        m.myPow(2, -2147483648);
        m.myPow(2, 2147483647);
        System.out.println(m.myPow2(2,n));
//        System.out.println(-(n/2));
    }
}
