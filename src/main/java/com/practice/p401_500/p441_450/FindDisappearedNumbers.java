package com.practice.p401_500.p441_450;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: yyc
 * @Date: 2022/5/9 7:27 下午
 * @Description: lc easy 448 找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，
 * 并以数组的形式返回结果。
 *
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 *
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[2]
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 */
public class FindDisappearedNumbers {
    public List<Integer> solution1(int[] nums) {
        Set<Integer> res = new HashSet<>();
        int n = nums.length;
        for (int i = 1; i <= n; i++){
            res.add(i);
        }

        for (int num : nums){
            res.remove(num);
        }
        return new ArrayList<>(res);
    }

    public List<Integer> solution2(int[] nums) {

        int len = nums.length;
        for (int num : nums){
            if (num < nums.length){
                nums[num] = nums[num] + len;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int num : nums){
            if (num <= len){
                res.add(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
//        int[] nums = {4,3,2,7,8,2,3,1};
        int[] nums = {1, 1};
        List<Integer> res = findDisappearedNumbers.solution1(nums);

        for (int num : res){
            System.out.println(num);
        }
    }
}
