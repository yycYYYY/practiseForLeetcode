package com.practice.p1_100.P41_50;

/**
 * NO.45 跳跃游戏2
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *     从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 *
 * 示例 2:
 * 输入: [2,3,0,1,4]
 * 输出: 2
 *
 * 提示:
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 * @Author yuyongchao
 **/
public class Jump2 {
    public int solution(int[] nums) {
        if (nums.length == 1){
            return 1;
        }
        int distance = 0;
        int time = 0;
        int pre = 0;
        for (int i = 0; i <= distance; i++) {
            int temp = i + nums[i];
            if (temp > distance){
                if (i - pre > nums[pre]){
                    pre = i;
                    time++;
                }
                time++;
                distance = time;
            }

            if (distance >= nums.length -1){
                return time;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Jump2 j = new Jump2();
        System.out.println(j.solution(new int[]{2,3,1,1,4}));
    }
}
