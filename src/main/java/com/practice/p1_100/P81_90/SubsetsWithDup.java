package com.practice.p1_100.P81_90;

import java.util.*;

/**
 * NO.90 子集2
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 **/
public class SubsetsWithDup {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> solution(int[] nums) {

        Arrays.sort(nums);
        int length = nums.length;
        boolean[] used = new boolean[length];

        dfs(nums, used, length, 0);
        return res;
    }
    public void dfs(int[] nums, boolean[] used, int length, int depth){
        res.add(new ArrayList<>(path));
        if (depth == length){
            return;
        }
        for (int i = depth; i < length; i++) {
            //相比与78题，多一个去重判断
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }

            if(!used[i]){
                //这里做一下去重，如果nums里没有重复元素，并且要求子集元素不能重复，那就保证不出现异位词即可。
                //由此，我们可以通过保证子集内部也是有序的，这个方式来避免出现重复子集。假如结果里有，123和132，那么132就是不被允许的，因为它不是有序的
                //这样可以避免异位词的出现，也就避免了重复子集的出现
                if (!path.isEmpty() && nums[i] < path.getLast()){
                    continue;
                }
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, used, length, depth + 1);
                path.removeLast();
                used[i] = false;
                //注意此处应该有一个非0判断，depth，如果不判断，在回溯到源头时，depth = -1的情况，导致used[depth]数组溢出
                if (depth != 0){
                    depth--;
                }
            }
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup s = new SubsetsWithDup();
        int[] a = {1, 2, 2};
        List res = s.solution(a);
        System.out.println(res);
    }
}
