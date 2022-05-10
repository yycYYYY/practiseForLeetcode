package com.practice.p1_100.P51_60;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yyc
 * @Date: 2022/4/25 6:47 PM
 * @Description: lc 51 hard N皇后
 *
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 示例 1：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[["Q"]]
 * 提示：
 * 1 <= n <= 9
 */
public class SolveNQueens {

    public List<List<String>> solution1(int n) {
        List<List<String>> res = new ArrayList<>();
        process(new int[n], 0, res);
        return res;
    }

    /**
     * 全排列法，依次判断皇后在每一行的位置，然后再迭代判断下一行的所有位置
     * @param recordArray 记录每行中皇后的位置
     * @param i 当前处理到哪一行
     * @param res 最后的结果集
     */
    private void process(int[] recordArray, int i, List<List<String>> res){
            if (i == recordArray.length){
            res.add(getStringRes(recordArray));
        }
        for (int j = 0; j < recordArray.length; j++){
            if (isValid(recordArray, i, j)){
                recordArray[i] = j;
                process(recordArray, i + 1, res);
            }
        }
    }

    /**
     *
     * @param recordArray 当前的位置信息，record[m] = n，表明第m行，第n列，有皇后
     * @param row 当前处理的行（打算放皇后的行）
     * @param col 打算放皇后的列
     * @return
     */
    public static boolean isValid(int[] recordArray, int row, int col){
        for (int i = 0; i < row; i++){
            if (recordArray[i] == col || Math.abs(recordArray[i] - col) == Math.abs(row - i)){
                return false;
            }
        }
        return true;
    }

    /**
     * 把结果数组转换成结果字符串
     */
    private List<String> getStringRes(int[] recordArray){
        List<String> res = new ArrayList<>();
        for (int k : recordArray) {
            char[] resStr = new char[recordArray.length];
            for (int j = 0; j < recordArray.length; j++) {
                resStr[j] = k == j ? 'Q' : '.';
            }
            res.add(new String(resStr));
        }
        return res;
    }

    /**
     * 使用位运算来判断，非常之难以想到
     */
    public List<List<String>> solution2(int n) {
        List<List<String>> res = new ArrayList<>();
        int limit = 1 << n - 1;
        int colLimit;
        int rowLimit;
        int slashLimit;
        return res;
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        List<List<String>> res = solveNQueens.solution1(4);
        System.out.println(res);
    }
}
