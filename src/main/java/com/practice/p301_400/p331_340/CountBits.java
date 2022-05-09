package com.practice.p301_400.p331_340;

/**
 * @Author: yyc
 * @Date: 2022/5/6 6:39 下午
 * @Description: lc easy 338 比特位计数
 * 给你一个整数 n ，对于0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 * 示例 2：
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 * 提示：
 * 0 <= n <= 105
 *
 * 进阶：
 * 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
 * 你能不使用任何内置函数解决此问题吗？（如，C++ 中的__builtin_popcount ）
 */
public class CountBits {
    public int[] solution1(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++){
            int cur = i;
            int count = 0;
            while (cur != 0){
                if (cur % 2 == 1){
                    count++;
                }
                cur = cur >> 1;
            }
            res[i] = count;
        }
        return res;
    }

    /**
     * 提接种看到一个很吊的思路，显得这题如果用动态规划就很傻
     * 已知0的二进制1个数一定是零，而对于所有的数字，按奇偶区分，都有这样的性质，
     * 奇数：奇数的二进制1个数，一定是前一个数加1，因为偶数的最后一位必定是0，而紧接着比它大一的奇数也就是最后一位+1
     * 偶数：任意一个偶数a，它的二进制1的个数一定等于这个偶数除以二的值b(>>1)，因为实际上b * 2 = a，也就是b左移一位
     * ，右侧补0。所以这两者的二进制1个数一定相等。
     */
    public int[] solution2(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i <= n; i++){
            if ((i & 1) == 1){
                res[i] = res[i - 1] + 1;
            }else {
                res[i] = res[i >> 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        int[] res = countBits.solution2(5);
        for (int num : res){
            System.out.println(num);
        }
    }
}
