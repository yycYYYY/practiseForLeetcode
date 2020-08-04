package com.practice.P1_100.P1_10;

import com.practice.dataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class convertZ {

    /*
    NO.6
    将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

    比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

    L   C   I   R
    E T O E S I I G
    E   D   H   N
    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     */

    /**
     * 见到这道题的第一思路，就是声明一个二维数组，然后根据z的排列规则，将字符串s的遍历，填到二位数组里，
     * 然后再根据行来读取，同时去除空值，得到每行的字符串，最后拼接字符串。
     * 二维数组的z排列规则：
     * 1、以[0,0]开始，先按列升序排列至[0,n-1]，当列到n-1时截至转向
     * 2、以[0,n-1]开始，行开始加1，列开始减一，列坐标到0为止，[n-1,0]
     * 3、再重复12过程，从[n-1,0]补充到[n-1,n-1]，直至字符串s遍历结束
     *
     * 这个思路过于复杂，看到leetcode中有一个！！非常精髓！！的思路
     * 不再声明二维数组，而是直接声明n个行字符串
     * 把数字在数组中的排列规则，简化成数字在n个字符串的排列，把空值直接忽略
     * 把原字符串-》二维数组-》n个行字符串-》结果字符串    这一过程简化为
     * 原字符串-》n个行字符串-》结果字符串
     * 省去了大量的逻辑
     */
    String solution1(String s,int numRows){
        if (s == null || numRows == 1 || numRows == 0) return s;

        StringBuilder[] resTemp = new StringBuilder[numRows];
        for (int i = 0;i < resTemp.length;i++){
            resTemp[i] = new StringBuilder();
        }

        StringBuilder res = new StringBuilder();
        int flag = -1,start = 0;

        for (int i = 0;i < s.length();i++){
            if (start == 0 || start == numRows-1) flag = -flag;

            resTemp[start].append(s.charAt(i));
            start += flag;

        }

        for (StringBuilder temp:resTemp){
            res.append(temp);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        convertZ z = new convertZ();
        String a = z.solution1("asdfghj",3);
        System.out.println(a);
    }
}
