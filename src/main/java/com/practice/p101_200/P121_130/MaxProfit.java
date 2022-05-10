package com.practice.p101_200.P121_130;

public class MaxProfit {
    /*
    买卖股票的最佳时机
    给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

    示例 1：
    输入：[7,1,5,3,6,4]
    输出：5
    解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
        注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

    示例 2：
    输入：prices = [7,6,4,3,1]
    输出：0
    解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     */

    /*
    读过题之后，发现这个题的思路应该还是比较简单的，遍历一次就可以，定义一个maxProfit，一个minPrice，
    遍历每一位是不是最小的，如果是则替换minPrice；同时计算一下此时卖出获得的利润是不是最大的，如果是则替换maxProfit
     */
    public int solution(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        if (prices.length == 1) return 0;
        for (int i = 1;i < prices.length;i++){
            int temp = prices[i] - minPrice;
            maxProfit = temp > maxProfit ? temp : maxProfit;
            minPrice = minPrice < prices[i]?minPrice : prices[i];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit m = new MaxProfit();
        int[] a = {7,1,5,3,6,4};
        System.out.println(m.solution(a));
    }
}
