package com.practice.P1_100.P1_10;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {
    /*
    NO.3 无重复的最长子串
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

    示例 1:

    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:

    输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例 3:

    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    int solution1(String s){
        if (s.length() < 2) return s.length();
        int maxlen = 0;
        Set<Character> queue = new HashSet<>();
        int right = -1;
        for (int i = 0;i < s.length();i++){
            if (!queue.contains(s.charAt(i))){
                queue.add(s.charAt(i));
            }else {
                right ++;
            }
            maxlen = Math.max(maxlen, (i - right + 1));
        }
        return 0;
    }
}
