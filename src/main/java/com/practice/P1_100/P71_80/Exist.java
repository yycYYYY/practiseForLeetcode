package com.practice.P1_100.P71_80;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * NO.79 单词搜索
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 示例 2：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 *
 * 示例 3：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 *
 * 提示：
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 * @Author yuyongchao
 **/
public class Exist {

    // 看了答案之后，答案的这个设计更优越，把四个方向设成一个二维数组，然后遍历这四个方向，把row和col做一次相加
    // 这比我一开始所使用的的一维数组canReach，然后四个方向写四个if，每个if里面的操作都一样，仅仅方向不一样的设计要强很多
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int row;
    int col;
    int strLength;
    char[][] board;
    String word;

    public boolean solution(char[][] board, String word) {
        if (board == null){
            return false;
        }
        this.board = board;
        this.row = board.length;
        this.col = board[0].length;
        this.strLength = word.length();
        this.word = word;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean[][] used = new boolean[row][col];
                boolean res = dfs(used, i, j, 0);
                if (res){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(boolean[][] used,int curRow, int curCol, int cur) {

        if (board[curRow][curCol] == word.charAt(cur)){
            if (cur == strLength - 1){
                return true;
            }
            used[curRow][curCol] = true;
            for (int[] direction : DIRECTIONS) {
                //注意这里要使用新的row和col，否则会影响到回溯时的回滚操作的正确性，把下一次所使用的的位置给错误的置成false
                int newRow = curRow + direction[0];
                int newCol = curCol + direction[1];
                if (inArea(newRow, newCol) && !used[newRow][newCol]) {
                    if (dfs(used, newRow, newCol,cur + 1)) {
                        return true;
                    }
                }
            }
            used[curRow][curCol] = false;

        }
        return false;
    }

    private boolean inArea(int curRow, int curCol){
        return curRow >= 0 && curRow < row && curCol >=   0 && curCol < col;
    }
}
