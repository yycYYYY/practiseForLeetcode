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


    public boolean solution(char[][] board, String word) {
        if (board == null){
            return false;
        }
        int rol = board.length;
        int column = board[0].length;
        int strLength = word.length();

        for (int i = 0; i < rol; i++) {
            for (int j = 0; j < column; j++) {
                boolean[] canReach = new boolean[]{i > 0, i < rol - 1, j > 0, j < column - 1};
                boolean res = dfs(board, canReach, i, j, 0, word, strLength);
                if (res){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[] canReach,int curRol, int curCol, int cur, String word, int strLength) {
        if (cur < strLength && board[curRol][curCol] == word.charAt(cur)){
            if (cur == strLength - 1){
                return true;
            }

        }
        return false;
    }
}
