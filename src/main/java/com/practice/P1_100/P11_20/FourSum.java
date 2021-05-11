package com.practice.P1_100.P11_20;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    /*
    NO.18 四数之和
    给定一个包含n 个整数的数组nums和一个目标值target，
    判断nums中是否存在四个元素 a，b，c和 d，
    使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。

    注意：
    答案中不可以包含重复的四元组。

    示例：
    给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
    满足要求的四元组集合为：
    [
      [-1,  0, 0, 1],
     [-2, -1, 1, 2],
     [-2,  0, 0, 2]
    ]
     */

    /*
    其实和三数之和差不多，甚至可以说是完全一样，知识多了一层循环
    不过，还可以多加一些判断条件做一些优化，去掉冗余操作
     */
    List<List<Integer>> solution(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        int sum = 0;
        if (nums == null||nums.length < 4) return res;
        Arrays.sort(nums);
        //比三数之和，多了一层循环，其余都一样
        for (int i = 0;i < nums.length - 3;i++){
            if (i>0&&nums[i] == nums[i-1]) continue;

            for (int j = i+1;j < nums.length - 2;j++){
                if (j>i+1 && nums[j] == nums[j-1]) continue;

                int L = j+1,R = nums.length -1;
                while (L < R){
                    sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[L],nums[R]));

                        while(L< R && nums[L] == nums[L+1]) L++;
                        while(L< R && nums[R] == nums[R-1]) R--;
                        L++;
                        R--;
                    }else if (sum < target){
                        while(L< R && nums[L] == nums[L+1]) L++;
                        L++;
                    }
                    else {
                        while(L< R && nums[R] == nums[R-1]) R--;
                        R--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,0,-1,0,-2,2,-1};
        int[] nums2 = {-4,-1,-1,-1,0,2,1};
        int[] nums3 = {0,0,0,0};
        FourSum f = new FourSum();
        f.solution(nums2,0);
        System.out.println(f.solution(nums3,0));
    }
}
