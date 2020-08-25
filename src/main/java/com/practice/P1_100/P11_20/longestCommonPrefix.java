package com.practice.P1_100.P11_20;

public class longestCommonPrefix {
    /*
    NO.14 最长公共前缀
    编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
     */

    /*
    注意边界！
     */
    String solution(String[] strs){
        StringBuilder res = new StringBuilder();
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        for (int i = 0;i < strs[0].length();i++){
            for (int j = 1;j < strs.length;j++){
                if (i >= strs[j].length()) return res.toString();
                if (strs[j].charAt(i) != strs[0].charAt(i)) return res.toString();
                if (j == strs.length -1) res.append(strs[0].charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] a = {"aa","a","aaa"};
        longestCommonPrefix l = new longestCommonPrefix();
        System.out.println(l.solution(a));
    }
}
