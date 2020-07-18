package com.practice.P1_100.P91_100;

public class isInterleave {
    /*
    NO.97 交错字符串
    给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
    例：
    输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
    输出: true

    输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
    输出: false
     */
    Boolean solution(String sq,String s2,String s3){
        /*
        见到这道题第一反应，就是放一个哈希表，存放着前两个字符串的字符，key为字符，value为字符数量
        然后再拿s3里每一个字符去map里containsKey（），如果存在value就减1，如果不存在该key就返回false
        如果所有的遍历完都为true，再看下map里所有的值是不是都是0，不是0则返回false；都是0，代表s3里的
        字符是s1s2两个字符串里字符混乱拼合而成。

        但这个思路错误的理解了题意，题目要求为【交错】而非【混乱拼合】，交错是要求有序的
        看了题解发现，本题需要使用动态规划，路要一步一步走，这题先不看，还是先搞链表
         */
        return true;
    }
}
