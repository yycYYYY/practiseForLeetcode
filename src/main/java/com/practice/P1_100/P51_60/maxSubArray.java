package com.practice.P1_100.P51_60;

public class maxSubArray {
    /*
    NO.53 最大子序和
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    示例:

    输入: [-2,1,-3,4,-1,2,1,-5,4]
    输出: 6
    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

     */
    int solution1(int[] nums){
        int max = nums[0];
        //dp是每个以i结尾的子串的最大子序和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1;i < nums.length;i++){
            dp[i] = Math.max(0,dp[i - 1]) + nums[i];
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray m = new maxSubArray();
        System.out.println(m.solution1(a));
    }
}
