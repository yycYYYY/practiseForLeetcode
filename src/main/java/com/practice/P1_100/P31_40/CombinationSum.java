package com.practice.P1_100.P31_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    /*
    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    candidates 中的数字可以无限制重复被选取。

    说明：
    所有数字（包括 target）都是正整数。
    解集不能包含重复的组合。 

    示例 1：
    输入：candidates = [2,3,6,7], target = 7,
    所求解集为：
    [
      [7],
      [2,2,3]
    ]

    示例 2：
    输入：candidates = [2,3,5], target = 8,
    所求解集为：
    [
     [2,2,2,2],
     [2,3,3],
     [3,5]
    ]

    提示：
    1 <= candidates.length <= 30
    1 <= candidates[i] <= 200
    candidate 中的每个元素都是独一无二的。
    1 <= target <= 500
     */

    /*
    暴力思路：
    单次结果List res    目标值target   每次计算中间值temp   当前位置（数组中的位置）cur
    当前计算位置（每次循环的计算位置）tempCur
    数组排序[6,2,3,7] --> [2,3,6,7]    目标7
    tempCur = cur
    在数组内，从后往前减target - candidates[tempCur]得到temp，并且往res存入一次当前candidates[tempCur]
    如果temp是0，直接返回res，小于零本次小循环结束啥也不返回，大于0，再减一次
    直到temp为0，返回res
    tempCur为0之后，结束小循环
    当cur变成0之后，结束大循环
     */
    List<List<Integer>> solution(int[] candidates, int target){
        List<Integer> resList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int cur = candidates.length - 1;
        Arrays.sort(candidates);
        while (cur > 0){
            int tempCur = cur;
            int temp = target;
            while (tempCur > 0){
                if (temp == 0) res.add(resList);
                if (temp < 0) break;

                if (temp >= candidates[tempCur]){
                    temp = temp - candidates[tempCur];
                    resList.add(candidates[tempCur]);
                }
                tempCur--;
            }
            cur--;
        }
        return res;
    }
}
