package com.practice.P1_10;

public class reverseInt {
    /*
    NO.7
    给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
    假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
    请根据这个假设，如果反转后整数溢出那么就返回 0。
     */

    int reverseIntSimple(int vl){
        int result = 0;
        //此解法错误，不能在这个位置，做最大最小值判断，我们没办法简单的通过反转前的值
//        来比较反转后的值。应在循环中间做判断，每一次循环都做一次判断。而且判断方法还比较复杂且不优雅
        //在此处做数值最大小判定
        if (vl>99999){
            return 0;
        }
        while (vl!=0){
           int temp = result%10;
           result = result*10 + temp;
           vl /= 10;
        }
        return result;
    }

    /**
     * 网上大佬的解法，简单的题，反而更能看出其功底
     *
     */
    int reverseIntSmart(int vl){

        long result = 0;

        while (vl != 0){

            result = result*10 + vl%10;
            vl /= 10;
        }

        return (int)result == result?(int)result:0;
    }

//    public static void main(String[] args) {
//        palindromeNumber p = new palindromeNumber();
//
//        ClassLoader cl1 = p.getClass().getClassLoader();
//
//
//        while (cl1 != null){
//            System.out.println(cl1.toString());
//            cl1 = cl1.getParent();
//        }}
}
