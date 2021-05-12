package com.practice.P1_100.P41_50;

/**
 * NO.43 字符串相乘
 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。

 示例 1:
 输入: num1 = "2", num2 = "3"
 输出: "6"

 示例2:
 输入: num1 = "123", num2 = "456"
 输出: "56088"

 说明：
 num1和num2的长度小于110。
 num1 和num2 只包含数字0-9。
 num1 和num2均不以零开头，除非是数字 0 本身。
 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * @author admin
 */
public class Multiply {

    final static String ZERO = "0";

    String solution(String num1, String num2){
        if (num1 == null || num2 == null || ZERO.equals(num1) || ZERO.equals(num2)){
            return ZERO;
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < num1.length(); i++) {

            for (int j = 0; j < num2.length(); j++) {

            }
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
