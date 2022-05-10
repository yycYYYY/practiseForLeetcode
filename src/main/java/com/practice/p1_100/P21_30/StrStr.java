package com.practice.p1_100.P21_30;

public class StrStr {
    /*
    NO.28 实现strStr()
    实现strStr()函数。

    给定一个haystack 字符串和一个 needle 字符串，
    在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
    示例 1:
    输入: haystack = "hello", needle = "ll"
    输出: 2

    示例 2:
    输入: haystack = "aaaaa", needle = "bba"
    输出: -1

    说明:
    当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
    对于本题而言，当needle是空字符串时我们应当返回 0 。这与C语言的strstr()以及 Java的indexOf()定义相符。
    */
    int solution(String haystack, String needle){
        if (needle == null || needle.equals("")||needle.equals(haystack)) return 0;
        if (haystack == null || haystack.equals("")) return -1;
        int len = needle.length();
//        这里的边界条件应该是haystack.len -len +1，弄错了好几次
        for (int i = 0;i < haystack.length()-len + 1;i++){
            if (haystack.charAt(i) != needle.charAt(0)) continue;
            String temp = haystack.substring(i,i+len);
            if (temp.equals(needle)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr s = new StrStr();
        System.out.println(s.solution("mississippi","pi"));
    }
}
