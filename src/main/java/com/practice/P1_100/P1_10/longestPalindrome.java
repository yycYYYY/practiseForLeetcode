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
        int maxLen = -1;
        String maxStr = "";
        int len = s.length();
        if (len < 2) return s;
        //这里作为动态规划里P[i+1][j-1]的存储，两层for循环，会对所有子串做一个判定boolean，是否是回文子串
        boolean[][] dp = new boolean[len][len];
        //
        for (int j = 1;j < len;j++){
            //此处的j指的是
            for (int i = j;i >= 0;i--){
                if (j-i >= 3){
                    //dpij是否为true要根据dp i+1,j-1判断，所以要以j升序，i降序来遍历填写动态状态表
                    //并且由于j-1<j,所以我们要以j为外层遍历，这里如果时间长，忘了怎么回事的话，可以自己花下
                    //动态规划二维表，每一个ij，需要去找右下元素（i为x，j为y）
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }else {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }

                if (maxLen < j-i && dp[i][j]){
                    maxLen = j-i;
                    maxStr = s.substring(i,j+1);
                }
            }
        }
        return maxStr;
    }

    public static void main(String[] args) {
        longestPalindrome l = new longestPalindrome();
        System.out.println(l.solution("acaaaaaca"));
    }
}
