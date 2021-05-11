package com.practice.P1_100.P11_20;

import java.util.Arrays;

public class ThreeSumClosest {
    /*
    NO.16 最接近的三数之和
    给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。

    示例：
    输入：nums = [-1,2,1,-4], target = 1
    输出：2
    解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

    提示：
    3 <= nums.length <= 10^3
    -10^3<= nums[i]<= 10^3
    -10^4<= target<= 10^4
     */

    /*
    1、排序，排序是为了双指针移动有根据可循（让左指针右移增大sum，右指针左移，减小sum）
    2、当前diff小于|res - target|,则替换res
    3、（当前diff < 上一个diff）-》sum大于target移动右指针，反之，移动左指针
    4、当前diff大于上一个diff或L>R，小循环结束（LR指针的循环）
    5、i < len-2 ，固定的i，大循环结束

    此解法，还可以进一步优化，去除重复case，判断nums[i] !=nums[i+1]。能够过滤掉重复元素
     */
    int solution(int[] nums,int target){
        int res = nums[0]+nums[1]+nums[nums.length-1];
//        当前res与target的差值绝对值
        int curDiff = res - target>0?res-target:target-res;
//        上一组三数与target的差值绝对值
        int tempDiff = curDiff;
        int sum = 0;

        Arrays.sort(nums);
        for (int i = 0;i < nums.length-2;i++){
            int L = i+1;
            int R = nums.length -1;
            while (L < R){
                sum = nums[i] + nums[L] + nums[R];
                curDiff = sum - target > 0 ? sum-target : target-sum;
//                如果三数之和等于target，直接返回
                if (sum == target) return target;
//                如果三数之和，相较于上一组，更接近，则替换res
                if (curDiff < (res - target>0?res-target:target-res))
                    res = sum;
                if (curDiff <= tempDiff){
                    if (sum < target) L++;
                    if (sum > target) R--;
                }
                tempDiff = curDiff;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSumClosest t = new ThreeSumClosest();
        System.out.println(t.solution(new int[]{0, 0, 0, 1,99},100));
    }
}
