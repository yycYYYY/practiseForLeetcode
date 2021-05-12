package com.practice.P1_100.P1_10;

public class PalindromeNumber {
    /*
    NO.9
    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     */
    boolean solution1(int x){
        if (x == 0) return true;
        if (x < 0||x % 10 == 0) return false;

        long result = 0;
        int temp = x;
        while (temp != 0){

            result = result*10 + temp%10;
            temp /= 10;
        }
        if (result == x)
        return true;
        return false;
    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.solution1(121));
    }
}
