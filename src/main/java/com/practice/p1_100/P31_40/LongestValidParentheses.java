package com.practice.p1_100.P31_40;

/**
NO.32 最长有效括号
给定一个只包含 '('和 ')'的字符串，找出最长的包含有效括号的子串的长度。

示例1:
输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"

示例 2:
输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
 */
public class LongestValidParentheses {

    int solution1(String s){
        int max = 0;
        int len = s.length();
        if (len < 2) return 0;
        int[] dp = new int[len];
        //dp的定义也有问题，dp[i]为以i结尾的子串长度，若i为（则dp为0
        dp[0] = 0;
        for (int i = 1;i < len;i++){
            if (s.charAt(i) == ')'){
                /*
                大体思路是对的，但是没有考虑到()(())、()(())、()(())((((()
                这三种case的情况，需要对dp[i]的状态转移方程做一个修正
                状态转移的条件对了，但是状态转移方程（值的变化方式）错了
                 */
                if (s.charAt(i-1) == '('){
//                    此时应该加上当前位置前两位的最大子串长度，因为（也占据着一个位置。
                    dp[i] = (i >= 2?dp[i-2]:0) + 2;
                }else if (i - dp[i-1] -1 >= 0 && s.charAt(i - dp[i-1] -1) == '('){
//                    注意()(())的情况，此时需要加上当前最大子串之前一位的最大子串
                    dp[i] = dp[i-1]+ (i-dp[i-1]-2 >= 0?dp[i-dp[i-1]-2]:0) + 2;
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses l = new LongestValidParentheses();
        int a = l.solution1("()(())))()");
        System.out.println(a);
    }
}
