package com.practice.p1_100.P41_50;

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

    //太蠢了，记得思路，但是记不清细节，一定要记得，乘法的操作
    String solution(String num1, String num2){
        if ("0".equals(num1) || "0".equals(num2)){
            return "0";
        }

        StringBuilder res = new StringBuilder();
        int temp;

        int[] result = new int[num1.length() + num2.length() - 1];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                result[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        for (int i = result.length - 1; i >= 0 ; i--) {
            res.append(result[i] % 10);
            temp = result[i] / 10;
            if (i == 0){
                if (temp >= 10){
                    res.append(temp % 10);
                    res.append(temp / 10);
                }else {
                    //注意如果是0，那就不进位了，否则会导致res出现以0结束的情况，依旧是最终返回的res以0打头的情况
                    if (temp != 0) {
                        res.append(temp);
                    }
                }
                continue;
            }
            result[i - 1] += temp;

        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "999999999999";
        String b = "999999999999999";
        Multiply m = new Multiply();
        System.out.println(m.solution(a, b));
    }

}
