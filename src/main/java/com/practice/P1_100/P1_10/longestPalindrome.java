package com.practice.P1_100.P1_10;

public class longestPalindrome {
    /*
    NO.5   最长回文子串
    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

    示例 1：

    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。
    示例 2：

    输入: "cbbd"
    输出: "bb"
     */
    String solution(String s){
        int maxLen = 0;
        String maxStr = "";
        int len = s.length();
        //这里作为动态规划里P[i+1][j-1]的存储，两层for循环，会对所有子串做一个判定boolean，是否是回文子串
        boolean[][] dp = new boolean[len][len];
        //此处的i代表的是字符串的最大长度，同时也指的是字符串的右指针，我们通过对最大字符串的长度，从大到小遍历，是否是回文串
        for (int i = len - 2;i > 0;i--){
            //此处的j指的是
            for (int j = i;j >= 0;j--){
                if (i -j <2) dp[j][i] = true;
                if (s.charAt(j) == s.charAt(j) && dp[j+1][i-1]) dp[j][i] = true;
                if (maxLen < i-j){
                    maxStr = s.substring(j,i);
                }
            }
        }
        return maxStr;
    }

    public static void main(String[] args) {
        longestPalindrome l = new longestPalindrome();
        System.out.println(l.solution("aaabbbaaa"));
    }
}
