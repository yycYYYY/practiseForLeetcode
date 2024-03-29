package com.practice.p1_100.P61_70;

public class ClimbStairs {
    /*
    NO.70 爬楼梯
    假设你正在爬楼梯。需要 n阶你才能到达楼顶。

    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

    注意：给定 n 是一个正整数。

    示例 1：
    输入： 2
    输出： 2
    解释： 有两种方法可以爬到楼顶。
    1.  1 阶 + 1 阶
    2.  2 阶

    示例 2：
    输入： 3
    输出： 3
    解释： 有三种方法可以爬到楼顶。
    1.  1 阶 + 1 阶 + 1 阶
    2.  1 阶 + 2 阶
    3.  2 阶 + 1 阶
     */

    /*
    一看就是动态规划的的题，但是一开始思路有点偏，没有想好状态转移方程。
    看了答案才发现，方程给你写出来之后，真的确实是一个easy题
    f(x)=f(x-1)+f(x-2)
    爬到第n级的方法，可以是从n-1级爬一级到达，也可以是从n-2爬两级到达。
    所以n的方法数量就是n-1和n-2的方法数量之和
     */
    int solution(int n){
        int f0 ,f1 =0,res = 1;
        for (int i = 1;i <= n;i++){
            f0 = f1;
            f1 = res;
            res = f0 + f1;
        }
        return res;
    }
}
