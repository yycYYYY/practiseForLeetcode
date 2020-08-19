package com.practice.P1_100.P11_20;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class intToRoman {
    /*
    NO.12 整数转罗马数字
    罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

    字符          数值
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
    通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
    数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
    这个特殊的规则只适用于以下六种情况：
    I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
    X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
    C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
    给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

    示例 1:
    输入: 3
    输出: "III"

    示例 2:
    输入: 4
    输出: "IV"

    示例 3:
    输入: 9
    输出: "IX"

    示例 4:
    输入: 58
    输出: "LVIII"
    解释: L = 50, V = 5, III = 3.
     */
    //此方法慢的一比，看的题解中的暴力匹配法，真的快
    String solution1(int num){
        StringBuilder res = new StringBuilder();
        int n = 0;
        int temp = num;
        Map<String,Integer> params = new LinkedHashMap<>();
        Map<String,Integer> romanNums = new LinkedHashMap<>();
        params.put("M",1000);
        params.put("CM",900);
        params.put("D",500);
        params.put("CD",400);
        params.put("C",100);
        params.put("XC",90);
        params.put("L",50);
        params.put("XL",40);
        params.put("X",10);
        params.put("IX",9);
        params.put("V",5);
        params.put("IV",4);
        params.put("I",1);
        for (Map.Entry<String,Integer> entry : params.entrySet()){
            n = temp/entry.getValue();
            temp = temp%entry.getValue();
            romanNums.put(entry.getKey(),n);
        }

        for (Map.Entry<String,Integer> entry : romanNums.entrySet()){
            for (int i = 0;i<entry.getValue();i++){
                res.append(entry.getKey());
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        int a = 4;
        intToRoman i = new intToRoman();
        String b = i.solution1(a);
        System.out.println(b);
    }
}
