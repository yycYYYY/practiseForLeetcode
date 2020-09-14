package com.practice.P1_100.P31_40;

import java.util.Arrays;

public class NextPermutation {
    /*
    NO.31 下一个排列
    实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    必须原地修改，只允许使用额外常数空间。

    以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1
     */
    void solution(int[] nums){
        if (nums == null || nums.length ==1) return;
        int cur = nums.length - 1;
        int min = nums.length - 1;

        while(cur > 0){
            if (nums[cur] > nums[cur - 1]){
                if (nums[min] > nums[cur - 1]){
                    int temp = nums[min];
                    nums[min] = nums[cur - 1];
                    nums[cur - 1] = temp;

                    int[] sortNums = new int[nums.length - cur];

                    for (int i = 0;i < sortNums.length;i++){
                        sortNums[i] = nums[cur + i];
                    }
                    Arrays.sort(sortNums);

                    for (int j = 0;j < sortNums.length;j++){
                        nums[cur + j] = sortNums[j];
                    }
                    return;
                }else min--;
            }else cur --;
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        int[] nums = {3,2,1};
        n.solution(nums);
        for (int a:nums){
            System.out.println(a);
        }
    }
}
