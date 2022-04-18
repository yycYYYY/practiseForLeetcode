package com.practice.p301_400.p311_320;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yyc
 * @Date: 2022/4/8 9:48 PM
 * @Description: lc 315 hard 计算右侧小于当前元素的个数
 *
 * 给你一个整数数组 nums ，按要求返回一个新数组counts 。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于nums[i] 的元素的数量。
 *
 * 示例 1：
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 *
 * 示例 2：
 * 输入：nums = [-1]
 * 输出：[0]
 *
 * 示例 3：
 * 输入：nums = [-1,-1]
 * 输出：[0,0]
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class CountSmaller {

    /**
     * 同 @SmallSum 本题也有简单算法，依次遍历和二分算法
     */
    public List<Integer> solution1(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);

        for (int i = 0; i < nums.length; i++){
            int counts = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]){
                    counts++;
                }
            }
            res.add(i, counts);
        }
        return res;
    }

    /**
     * 通过二分寻找  所有  当前数右侧 小于当前数的  元素   数量
     * 相对于小数问题，更复杂一点点，需要求啊哦添加索引数组，每次排序后，根据索引数组去映射关系，最后还原出结果
     */
    public List<Integer> solution2(int[] nums){
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        List<Integer> res = new ArrayList<>(nums.length);
        int[] originalArray = nums;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 0);
        }
        process(nums, 0 , nums.length - 1, map);
        return res;
    }

    private void process(int[] nums, int left, int right, Map<Integer, Integer> map){
        if (left < right){
            int mid = (right + left) / 2;
            process(nums, left, mid, map);
            process(nums, mid + 1, right, map);
            merge(nums, left, mid, right, map);
        }
    }

    private void merge(int[] nums, int left, int mid, int right, Map<Integer, Integer> map){
        int[] temp = new int[right - left + 1];
        int current = 0;
        int p1 = left;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= right){
            if (nums[p1] < nums[p2]){

            }
        }
    }

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>(1);
        System.out.println(test.get(0));
    }
}
