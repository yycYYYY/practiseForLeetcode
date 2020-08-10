package com.practice.P1_100.P1_10;

public class reverseInt {
    /*
    NO.7
    版本
    给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
    假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
    请根据这个假设，如果反转后整数溢出那么就返回 0。
     */

    int solution1(int x){
        int result = 0;

        while (x!=0){
            int temp = x%10;
            if ((result > Integer.MAX_VALUE/10) || (result == Integer.MAX_VALUE/10 && temp > 7) ||
                    result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && temp < -8))
                return 0;

            result = result*10 + temp;
            x /= 10;

        }
        return result;
    }

    /**
     * 网上大佬的解法，简单的题，反而更能看出其功底
     * 先通过一个long来保存反转后的值，然后将long强转成int，如果值没有超出int极限值
     * 那强转前后的值，一定是相等的。如果不相等则证明溢出了，直接返回0；
     *
     */
    int solution2(int x){

        long result = 0;

        while (x != 0){

            result = result*10 + x%10;
            x /= 10;
        }

        return (int)result == result?(int)result:0;
    }

    public static void main(String[] args) {
        reverseInt r =new reverseInt();
        int a = -2147483412;
        System.out.println(a);
        System.out.println(r.solution2(a)== r.solution1(a));
        System.out.println(Integer.MIN_VALUE);
    }
}
