package com.practice.p1_100.P91_100;

/**
 * TODO ：未完成
 * @Author: yyc
 * @Date: 2022/5/17 4:20 下午
 * @Description: lc mid 96 不同的搜索二叉树数量
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * (二叉搜索树，左子小于根， 右子大于根)
 * 示例 1：
 * 输入：n = 3
 * 输出：5
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 *
 * 提示：
 * 1 <= n <= 19
 */
public class NumTrees {

    public int recursion(int num){
        if (num == 1){
            return 1;
        }

        // 只有左子
        int onlyLeftNums = recursion(num - 1);
        //只有右子
        int onlyRightNums = recursion(num - 1);

        // 左右子都有
        int AllLRNUms = 0;
        if (num > 2){
            AllLRNUms = recursion(num - 2);
        }

        return AllLRNUms + onlyLeftNums + onlyRightNums;
    }

    public static void main(String[] args) {
        NumTrees n = new NumTrees();
        System.out.println(n.recursion(4));
    }
}
