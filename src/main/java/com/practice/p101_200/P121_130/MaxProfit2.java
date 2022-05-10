package com.practice.p101_200.P121_130;

public class MaxProfit2 {
    /*
    买卖股票的最佳时机 II
    给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

    示例 1:
    输入: [7,1,5,3,6,4]
    输出: 7
    解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
       随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

    示例 2:
    输入: [1,2,3,4,5]
    输出: 4
    解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
       注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
       因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

    示例3:
    输入: [7,6,4,3,1]
    输出: 0
    解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

    提示：
    1 <= prices.length <= 3 * 10 ^ 4
    0 <= prices[i]<= 10 ^ 4
     */

    /*
    与121的区别就是可以多次交易，第一眼的想法是穷举，也就是暴力法，把所有的赚钱情况都列举出来（多次循环），但是后来一想，咋可能需要穷举，
    太蠢了，炒股就是低买高卖，找出所有的拐点。例如价格是1，2，3，4，1  把所有赚钱情况列出来，第一条情况就是：「1买2卖，然后2买3卖，3买4卖」。
    这实际与「1买4卖」的情况是一致的，所以我们需要做的是找到拐点，然后把剩下的数，重新组成一个数组，再重复这个寻找拐点，低买高卖的步骤。
    1-1、把这个数组想成一条线，先找出第一个低点，作为第一次买入（低点的定义：x[n]>x[n-1] & x[n] < x[n+1]）
    1-2、找到后面第一个高点，卖出。（高点的定义：x[n]>x[n-1] & x[n] < x[n+1]）
    2、把剩下的数组成数据，重复上述的步骤
     */
    public int solution(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = 0;
        int minPosition = 0;
        int curPosition = 1;
        while (curPosition < prices.length){
            if (prices[curPosition] <= prices[minPosition]){
                minPosition = curPosition;
                curPosition++;
                continue;
            }
            if (curPosition == prices.length - 1){
                if (prices[curPosition] > prices[minPosition]){
                    maxProfit += prices[curPosition] - prices[minPosition];
                    break;
                }
            }

            if (prices[curPosition + 1] < prices[curPosition]){
                maxProfit += prices[curPosition] - prices[minPosition];
                minPosition = curPosition + 1;
            }
            curPosition++;
        }
        return maxProfit;
    }

    /*
    答案这个思路，真的好，"站在未来看过去"，假设我每一天都交易，但如果某一天交易我会亏损，那这一天我就不交易。
    每一次可以赚钱的机会，我都交易了，每一次赔钱的机会，我都规避了，那这一整段时间内，我的盈利就是最大化的
     */
    public int solution2(int[] prices){
        int profit = 0;
        for (int i = 1; i < prices.length;i++){
            int temp = prices[i] - prices[i -1];
            profit += Math.max(temp, 0);
        }
        return profit;
    }

    public static void main(String[] args) {
        MaxProfit2 m = new MaxProfit2();
        int[] a ={1,2,3,4,5};
        System.out.println(m.solution(a));
    }
}
