package com.practice.P1_100.P41_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 46.全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @author
 */
public class Permute {

    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if ( nums == null || nums.length == 0){
            return res;
        }
        int length = nums.length;
        int head = 0;
        int cur = 0;
        List<Integer> temp = new ArrayList<>();

        for (int a: nums){
            temp.add(a);
        }
        res.add(temp);


        while (head < length){
            while (cur < length){
                temp.add(nums[cur]);
                if (cur == length - 1){
                    if (res.contains(temp)){
                        cur -= 2;
                    }
                }
                cur++;

            }

            head++;
        }

        return res;
    }
}
