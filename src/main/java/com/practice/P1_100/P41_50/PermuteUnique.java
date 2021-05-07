package com.practice.P1_100.P41_50;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * NO.47 全排列2
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。（相对于NO.46，输入nums可能包含重复数字）
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 */
public class PermuteUnique {

    /**
     * 相比于NO46的全排列，需要有一个去重的操作，也就是下方
     * @param nums
     * @return
     */
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        int length = nums.length;
        Deque path =  new ArrayDeque(length);
        boolean[] used = new boolean[length];

        dfs(nums, 0, length, path, res, used);
        return res;
    }

    public void dfs(int[] nums, int depth, int length, Deque path, List res, boolean[] used){
        //添加了一个判重逻辑，如果重复，就不往res里加。跑了用例之后发现，运行速度，很差，需要优化
        if(depth == length){
            List<Integer> pathRes = new ArrayList<>(path);
            if(!res.contains(pathRes)){
                res.add(new ArrayList(path));
            }
        }

        for(int i = 0;i < length;i++){
            if(!used[i]){
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, depth + 1, length, path, res, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
