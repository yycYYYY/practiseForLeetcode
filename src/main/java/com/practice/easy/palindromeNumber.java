package com.practice.easy;

public class palindromeNumber {
    boolean isPalindrome(int vl){
        if (vl == 0) return true;
        if (vl < 0||vl % 10 == 0) return false;
        return true;
    }

    boolean isPalindromeByString(int vl){
        if (vl == 0) return true;
        if (vl < 0||vl % 10 == 0) return false;
        return true;
    }
}
