package com.practice.P1_100.P21_30;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicates {
    /*
    NO.26 删除排序数组中的重复项
    给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

    示例1:
    给定数组 nums = [1,1,2],
    函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
    你不需要考虑数组中超出新长度后面的元素。
    示例2:
    给定 nums = [0,0,1,1,1,2,2,3,3,4],
    函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
    你不需要考虑数组中超出新长度后面的元素。
     */

    /*
    1、sf快慢指针，s为0，f为1
    2、比较nums[s]nums[f]如果相同，f++，不相等；nums[s+1] = nums[f] s++ f++
    3、直到f < nums.length
     */
    int solution(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int len = nums.length,S = 0,F = 1;
        while (F < nums.length){
            if (nums[S] == nums[F]){
                F++;
                len--;
            }else {
                nums[S+1] = nums[F];
                F++;
                S++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        RemoveDuplicates r = new RemoveDuplicates();
        int[] nums = {1,1,1,3};
        System.out.println(r.solution(nums));
    }
}
