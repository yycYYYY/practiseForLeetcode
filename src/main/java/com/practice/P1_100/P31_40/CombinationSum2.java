package com.practice.P1_100.P31_40;

import java.util.*;

/**
 * NO.40 组合总和2
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例1:
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 示例2:
 * 输入: candidates =[2,5,2,1,2], target =5,
 * 所求解集为:
 * [
 *  [1,2,2],
 *  [5]
 * ]
 */
public class CombinationSum2 {
    /**
     * 这道题的回溯操作，dfs，去重操作，极为经典！！！！！
     * 如果再看到这道题，忘记了解法，一定要回过头来，再画一遍图！！！！！！！
     *
    这个看起来就有点像组合总和+全排列了，两种去重限制叠加到一起了
    既不允许重复用元素，也不允许res包含重复组合
    那就是used[]  begin两个操作一起上？？？  是的，没错，就是俩者一起上，第一次错了，是因为used数组用的不对，见#65行
     单独的used[]并不是去重操作，仅仅是dfs的记录操作，用于替代dfs的候补列表栈，真正去重的是#65行的那个判断，那个是精髓
     简单的组合是不可以的，还是得画一下图
     */
    public List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return res;
        }
        int length = candidates.length;
        boolean[] used = new boolean[length];
        Deque<Integer> path = new LinkedList<>();

        Arrays.sort(candidates);
        dfs(res, candidates, path, 0, 0, length, used, target);

        return res;
    }

        private void dfs(List<List<Integer>> res, int[] candidates, Deque<Integer> path, int depth, int begin, int length, boolean[] used, int distance) {
            if (distance == 0){
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = begin; i < length; i++) {
                if (distance < 0){
                    return;
                }
    //          第一遍没能去重，used用的不对，主要是这里，
                if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]){
                    continue;
                }

                if (!used[i]){
                    path.addLast(candidates[i]);
                    used[i] = true;
                    distance -= candidates[i];
                    dfs(res, candidates, path, depth + 1, i, length, used, distance);
                    path.removeLast();
                    used[i] = false;
                    distance += candidates[i];
                }
            }
        }
        public static void main(String[] args) {
        CombinationSum2 c = new CombinationSum2();
//        int[] can = new int[]{10,1,2,7,6,1,5};
        int[] can = new int[]{1,1,2,3};
        List<List<Integer>> res;
        res = c.solution(can,4);
        System.out.println(res.toString());

    }
}
