package com.practice.p1_100.P51_60;

/**
 * NO.50 跳跃游戏
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 示例1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 示例2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 */
public class CanJump {
    /**
     * 看到这道题第一反应，有点刷回溯dfs刷的走火入魔了，第一反应竟然是画树，dfs！爷直接穷举剪枝深度遍历
     * 贪心：每次按最远可移动距离，跳到最远，如果跳到最后，跳的距离大于等于最后一位，那肯定返回true/
     * @param nums
     * @return
     */
    public boolean solution(int[] nums){
        if (nums.length == 1){
            return true;
        }

        int length = nums.length;
        // 每一位可以跳的最远距离
        int distance = 0;

        // 注意这里遍历的范围是，当前位（i）可以走的最远的范围
        // 例如{2,3,1,1,4} 当走到第一位2的时候，最远可以跳到nums[2],我们就遍历走一下nums[1]nums[2]
        // 遍历走这两个位置，看走到每一个位置能走多远，如果能走的更远，就更新distance，
        // 遍历到nums[1]时发现，能走到1 + 3 = 4，就更新distance为4，遍历到nums[2],发现最远距离是2 + 1 = 3
        // 那就不更新distance，当前distance为4，直接跳到nums[4]
        for (int i = 0; i <= distance; i++) {
            int temp = i + nums[i];
            distance = Math.max(temp, distance);
            // 如果最远距离大于最后一个位置的下标，那肯定能跳过去
            if (distance >= length -1){
                return true;
            }
        }
        return false;
    }
}
