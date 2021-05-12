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


    String solution(String num1, String num2){
        if ("0".equals(num1) || "0".equals(num2)){
            return "0";
        }

        StringBuilder res = new StringBuilder();

        int[] result = new int[num1.length() * num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {

            for (int j = num2.length() - 1; j >= 0; j--) {
                result[i + j +1] = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

//        for ()

        return res.toString();
    }

    String solution2(String num1, String num2){
        //把字符串转换成char数组
        char chars1[] = num1.toCharArray();
        char chars2[] = num2.toCharArray();

        //声明存放结果和两个乘积的容器
        int result[] = new int[chars1.length + chars2.length];
        int n1[] = new int[chars1.length];
        int n2[] = new int[chars2.length];

        //把char转换成int数组，为什么要减去一个'0'呢？因为要减去0的ascii码得到的就是实际的数字
        for(int i = 0; i < chars1.length;i++)
            n1[i] = chars1[i]-'0';
        for(int i = 0; i < chars2.length;i++)
            n2[i] = chars2[i]-'0';

        //逐个相乘，因为你会发现。AB*CD = AC(BC+AD)BD , 然后进位。
        for(int i =0 ; i < chars1.length; i++){
            for(int j =0; j < chars2.length; j++){
                result[i+j]+=n1[i]*n2[j];
            }
        }

        //满10进位，从后往前满十进位
        for(int i =result.length-1; i > 0 ;i--){
            result[i-1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        //转成string并返回
        String resultStr = "";
        for(int i = 0; i < result.length-1; i++){
            resultStr+=""+result[i];
        }
        return resultStr;
    }

    public static void main(String[] args) {
        String a = "123";
        String b = "456";
        Multiply m = new Multiply();
        System.out.println(m.solution2(a, b));
    }
}
