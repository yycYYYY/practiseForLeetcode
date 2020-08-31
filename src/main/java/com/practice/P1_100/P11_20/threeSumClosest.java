package com.practice.P1_100.P11_20;

import java.util.Arrays;

public class threeSumClosest {
    /*
    NO.16 最接近的三数之和
    给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

    示例：
    输入：nums = [-1,2,1,-4], target = 1
    输出：2
    解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

    提示：
    3 <= nums.length <= 10^3
    -10^3 <= nums[i] <= 10^3
    -10^4 <= target <= 10^4
     */
    int solution(int[] nums,int target){
        int res = nums[0]+nums[1]+nums[nums.length-1];
        //当前res与target的差值绝对值
        int temp = res - target>0?res-target:target-res;
        Arrays.sort(nums);
        for (int i = 0;i < nums.length;i++){
            int L = i+1;
            int R = nums.length;
            while (L < R){
                if (nums[i] + nums[L] + nums[R] == target) return target;
            }
        }
        return 0;
    }
}
