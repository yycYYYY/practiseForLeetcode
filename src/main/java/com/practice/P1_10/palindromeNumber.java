package com.practice.P1_10;

public class palindromeNumber {
    /*
    NO.9
    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     */
    boolean isPalindrome(int vl){
        if (vl == 0) return true;
        if (vl < 0||vl % 10 == 0) return false;
        int result = 0;
        while (vl != 0){

            result = result*10 + vl%10;
            vl /= 10;
        }
        if (result == vl)
        return true;
    }
}
