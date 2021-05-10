package com.practice.P1_100.P31_40;

import java.util.ArrayList;
import java.util.List;

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
    /*
    这个看起来就有点像组合总和+全排列了，两种去重限制叠加到一起了
    既不允许重复用元素，也不允许res包含重复组合
    那就是used[]  begin两个操作一起上？？？
     */
    public List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        return res;
    }
}
