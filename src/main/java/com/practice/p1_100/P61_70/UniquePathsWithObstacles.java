package com.practice.p1_100.P61_70;

public class UniquePathsWithObstacles {
    /*
    NO.63 不同路径2
    看起来思路跟62题像是一样，知识多一个判断nums[i][j]是否为1的情况。
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
    网格中的障碍物和空位置分别用 1 和 0 来表示。
    说明：m 和 n 的值均不超过 100。

    示例 1:
    输入:
    [
      [0,0,0],
      [0,1,0],
      [0,0,0]
    ]
    输出: 2
    解释:
    3x3 网格的正中间有一个障碍物。
    从左上角到右下角一共有 2 条不同的路径：
    1. 向右 -> 向右 -> 向下 -> 向下
    2. 向下 -> 向下 -> 向右 -> 向右
     */

    /*
    果然思路一模一样。。。。。。
     */
    int solution(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int a = 0;a<m;a++){
            if (obstacleGrid[a][0] == 0){
                dp[a][0] = 1;
            }else break;
        }

        for (int b = 0;b<n;b++){
        if (obstacleGrid[0][b] == 0){
            dp[0][b] = 1;
//            这里一定要注意一个小细节，路线只能往右下走，如果这一行或者这一列有一个障碍物
//            那么这一行或列所有按直线（不转弯的路径），都无法走通。
//            所以最边上的[i][0],[0][j]，一旦遇到了障碍物，障碍物后方的dp一定为0
        }else break;
        }

        for (int i = 1;i<m;i++){
            for (int j = 1; j < n;j++){
                if (obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    int solution2(int[][] obstacleGrid){
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        // 定义 dp 数组并初始化第 1 行和第 1 列。
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        // 根据状态转移方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 进行递推。
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] a = {{0,0,0},{0,1,0},{0,0,0}};
        UniquePathsWithObstacles u =new UniquePathsWithObstacles();
        System.out.println(u.solution(a));
    }
}
