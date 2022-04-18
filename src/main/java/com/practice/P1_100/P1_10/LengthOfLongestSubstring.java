package com.practice.P1_100.P1_10;

import java.util.*;

public class LengthOfLongestSubstring {
    /*
    NO.3 无重复的最长子串---有问题，需要细看，今天心情爆炸！不看了----
    给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。

    示例1:

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
    解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
    请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
     */

    /*
    写的有问题，用set就行，把queue里的value拿出来
     */
    int solution1(String s){
        if (s.length() < 2) {
            return s.length();
        }

        int maxlen = 0;
        int right = 0;
        Map<Character,Integer> queue = new HashMap<>();

        for (int i = 0;i < s.length();i++){
            if (queue.containsKey(s.charAt(i))) {
                right = queue.get(s.charAt(i))+1;
            }
            queue.put(s.charAt(i),i);
            maxlen = Math.max(maxlen,i-right+1);
        }

        return maxlen;
    }

    /*滑动窗口法
    从最左侧开始判断每一位的最大窗口是多大，添加最左侧的元素进入，让后从该位元素开始，窗口向右侧扩张，遇到重复元素停止，判断是否最大长度
    直至左侧元素遍历结束，完成统计。

    1、判断下一个right和queue中是否重复，无重复则尽可能的向右添加无重复的元素，遇到重复的停止
    2、记录队列长度
    3、删除左面第一个，重复一操作

    对于此操作，浪费了一些时间复杂度，如果当前位置遇到两个连续的重复字符，
    可以直接把左侧的字符，直接移到当前位置，从而减少一些判断和计算，但如何把左侧的字符直接移到当前位置
    这个是solution1遇到的问题，也是待解决问题，我们可能需要通过一个标志位和一个存储字符和其在s中位置的map
     */
    int solution2(String s){
        int maxlen = 0;
        int right = 0;
        Set<Character> queue = new LinkedHashSet<>();
        Set maxQueue;
        for (int left = 0;left < s.length();left++){
            if (left != 0){
                queue.remove(s.charAt(left-1));
            }
            while (right <s.length()&&(!queue.contains(s.charAt(right)))){
                queue.add(s.charAt(right));
                right++;
            }
            maxQueue = new HashSet(queue);
            maxlen = Math.max(maxlen,right-left);
        }
        return maxlen;
    }
    public static void main(String[] args) {
        LengthOfLongestSubstring l =new LengthOfLongestSubstring();
        System.out.println(l.solution2("aabba"));
    }
}
