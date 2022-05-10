package com.practice.p1_100.P61_70;

public class UniquePaths {
    /*
    NO.62 不同路径
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    问总共有多少条不同的路径？

    示例1:
    输入: m = 3, n = 2
    输出: 3
    解释:
    从左上角开始，总共有 3 条路径可以到达右下角。
    1. 向右 -> 向右 -> 向下
    2. 向右 -> 向下 -> 向右
    3. 向下 -> 向右 -> 向右

    提示：
    1 <= m, n <= 100
    题目数据保证答案小于等于 2 * 10 ^ 9
     */
    int solution(int m ,int n){
        if (m < 2 || n<2) return 1;
        //二维数组，每一位的不同路径数
        int[][] dp = new int[m][n];
        for (int a = 0;a<m;a++){
            dp[a][0] = 1;
        }

        for (int b = 0;b<n;b++){
            dp[0][b] = 1;
        }
        for (int i = 1;i<m;i++){
            for (int j = 1; j < n;j++){
                dp[i][j] =dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        System.out.println(u.solution(3,2));
    }
}
