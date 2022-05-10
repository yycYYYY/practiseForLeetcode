package com.practice.p1_100.P61_70;

public class MinPathSum {
    /*
    NO.64 最小路径和
    给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
     */
    int solution(int[][] grid){
        if (grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;
//        以每位最小路径和作为dp
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
//        先把左边界和上边界的数值，初始化，作为初始条件
        for (int i = 1;i < m;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int j = 1;j< n;j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
//        跟62\63逻辑差不多，由于每次只能向右下移动，右下的最小路径和，就是左上两个dp里更小的哪一个，加上当前位置的值
//        由于每次都会选择更小的值，遍历到最后，最后一个dp内包含的就是整个路径的最小路径和
        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        MinPathSum m = new MinPathSum();
        int[][] a = {{1,3,1},{1,5,1},{4,2,1}};
        int s = m.solution(a);
        System.out.println(s);
    }
}
