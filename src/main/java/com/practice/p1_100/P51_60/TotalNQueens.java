package com.practice.p1_100.P51_60;

/**
 * @Author: yyc
 * @Date: 2022/4/25 8:46 PM
 * @Description: lc 52 hard N皇后2（计数）
 *
 * n皇后问题 研究的是如何将 n个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 * 示例 1：
 * 输入：n = 4
 * 输出：2
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 *
 * 提示：
 * 1 <= n <= 9
 */
public class TotalNQueens {

    public int solution1(int n) {
        return process(new int[n], 0);
    }

    private int process(int[] recordArray, int i){
        int res = 0;
        if (i == recordArray.length){
            return 1;
        }

        for (int j = 0; j < recordArray.length; j++){
            if (SolveNQueens.isValid(recordArray, i, j)){
                recordArray[i] = j;
                res += process(recordArray, i + 1);
            }
        }
        return res;
    }

    int ans = 0;
    public int solution2(int n) {
        dfs(n, 0, 0, 0, 0);
        return this.ans;
    }

    private void dfs(int n, int row, int cols, int pie, int na) {
        if (row == n) {
            this.ans ++;
            return;
        }
        int positions = ((1 << n) - 1) & (~(cols | pie | na));
        while (positions != 0) {
            int p = positions & (-positions);
            positions &= (positions - 1);
            dfs(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1);
        }
    }

    public static void main(String[] args) {
        TotalNQueens totalNQueens = new TotalNQueens();
        System.out.println(totalNQueens.solution1(2));
    }
}
