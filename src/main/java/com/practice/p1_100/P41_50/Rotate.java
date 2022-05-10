package com.practice.p1_100.P41_50;

/**
 * NO.48 旋转图像
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * 示例 2：
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * 示例 3：
 * 输入：matrix = [[1]]
 * 输出：[[1]]
 *
 * 示例 4：
 * 输入：matrix = [[1,2],[3,4]]
 * 输出：[[3,1],[4,2]]
 *
 * 提示：
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 * @Author yuyongchao
 **/
public class Rotate {
    /**
     * 经过画图可知，顺时针旋转90度，也可以通过，另一种方法实现，
     * 先沿着斜对角线（一三象限对角线），交换两侧数据，再沿着上下中轴线，交换两侧数据
     *  1   2   3   4        16  12  8  4        13  9  5  1
     *  5   6   7   8    --》15  11  7  3  --》  14  10  6  2
     *  9  10  11  12       14  10  6  2        15  11  7  3
     * 13  14  15  16       13  9   5  1        16  12  8  4
     * @param matrix nxn数组
     */
    public void solution(int[][] matrix) {
        if (matrix == null || matrix.length == 1){
            return;
        }
        int length = matrix.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - j -1][length - i -1];
                matrix[length - j -1][length - i -1] = temp;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < (length / 2); j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = temp;
            }
        }

    }

    public static void main(String[] args) {
        Rotate r = new Rotate();
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        r.solution(a);
    }
}
