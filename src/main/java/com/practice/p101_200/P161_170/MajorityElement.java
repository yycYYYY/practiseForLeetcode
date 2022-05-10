package com.practice.p101_200.P161_170;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yyc
 * @Date: 2022/5/6 5:11 下午
 * @Description: lc easy 169 多数元素
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例1：
 * 输入：nums = [3,2,3]
 * 输出：3
 *
 * 示例2：
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class MajorityElement {

    public int solution1(int[] nums) {
        int mostNumber;
        Map<Integer, Integer> numCounts = new HashMap<>();

        if (nums.length == 0){
            return -1;
        }
        mostNumber = nums[0];
        for (int num : nums) {
            if (!numCounts.containsKey(num)) {
                numCounts.put(num, 1);
            } else {
                numCounts.put(num, numCounts.get(num) + 1);
                mostNumber = numCounts.get(mostNumber) > numCounts.get(num) ?
                        mostNumber : num;
            }
        }

        return numCounts.get(mostNumber) > (nums.length / 2) ? mostNumber : -1;
    }

    /**
     * 摩尔投票法，这个真的屌
     * 初始化第一个元素为1票，遍历后方，遇到相同的数字票数+1，遇到不同的数票数-1；
     * 当票数为0的时候，更换新元素，票数重置为1
     *
     * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
     * 且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
     * 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
     * 无论数组是1 2 1 2 1，亦或是1 2 2 1 1，总能得到正确的候选人。
     */
    public int solution2(int[] nums){
        int mostNum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (mostNum == nums[i]){
                ++count;
            }
            else if (--count == 0) {
                mostNum = nums[i];
                count = 1;
            }
        }
        return mostNum;
    }

    public static void main(String[] args) {
        MajorityElement element = new MajorityElement();
        System.out.println(element.solution1(new int[]{2,3,3}));
    }
}
