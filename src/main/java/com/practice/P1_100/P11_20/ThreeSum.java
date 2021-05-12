package com.practice.P1_100.P11_20;

import com.practice.dataStructure.ListNode;

import java.util.*;

/**
 NO.15 三数之和
 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。

 示例：
 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class ThreeSum {

    /*
    先数组排序，然后用twosum的方式遍历，这种方式是错误的。复杂度很高，还需要考虑后续的去重，非常恶心
     */
    List<List<Integer>> solution(int[] nums){
        if (nums == null || nums.length <3) return null;
        List<List<Integer>> res = new ArrayList<>();
        int temp = 0;
        HashSet<Integer> tv = new HashSet<>();
        tv.add(nums[0]);

        for (int l = 1;l < nums.length;l++){
            if (!tv.contains(nums[l])) tv.add(nums[l]);
        }

        Arrays.sort(nums);
        for(int i = 0;i< nums.length-2;i++){
            if (i == 0 || nums[i] != nums[i - 1]){

                for (int j = i+1;j < nums.length - 1;j++){
                    if (j == 0 || nums[j] != nums[j - 1]){
                        temp = -nums[i] - nums[j];
                        if (tv.contains(temp)){
                            List<Integer> lt = new ArrayList<>();
                            lt.add(nums[i]);
                            lt.add(nums[j]);
                            lt.add(temp);
                            res.add(lt);
                        }
                    }
                }
            }
        }
        return res;
    }

    //用评论里的排序双指针，不再使用哈希表匹配，哈希表匹配后续的去重比较恶心
    List<List<Integer>> solution2(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <3) return res;
        Arrays.sort(nums);
        for (int i = 0;i < nums.length && nums[i] <= 0;i++){
            if (i ==0 || nums[i] != nums[i-1]){
                int L = i + 1,R = nums.length-1;
                while (L<R){
                    int sum = nums[i]+nums[L]+nums[R];
                    if (sum == 0){
                        res.add(Arrays.asList(nums[i],nums[L],nums[R]));

                        while(L<R&&nums[L] == nums[L+1]) L++;
                        while(L<R&&nums[R] == nums[R-1]) R--;

                        L++;
                        R--;
                    }else if (sum < 0) L++;
                    else R--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        int[] a = new int[]{-1,-1,1,0};
        List b = t.solution2(a);
        System.out.println(b);
    }
}
