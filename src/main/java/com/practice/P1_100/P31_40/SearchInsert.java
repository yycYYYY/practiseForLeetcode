package com.practice.P1_100.P31_40;

/**
    NO.35 搜索插入位置   （这道简单题在第二遍刷的时候，可以好好看下，就是最简单的二分！！！）
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

    你可以假设数组中无重复元素。

    示例 1:
    输入: [1,3,5,6], 5
    输出: 2

    示例2:
    输入: [1,3,5,6], 2
    输出: 1

    示例 3:
    输入: [1,3,5,6], 7
    输出: 4

    示例 4:
    输入: [1,3,5,6], 0
    输出: 0
 * @author yyc
 */
public class SearchInsert {
    /**
     * 就是简单的二分，千万不要想复杂了，只需要注意一下，target > nums[nums.length - 1]的边界情况
     */
    public int solution(int[] nums,int target){
        int len = nums.length;
        int left = 0,right = len - 1;
        if (target > nums[len - 1]){
            return len;
        }
        int res = 0;

        while(left <= right){

            int mid = (left + right) >> 1;

            if (nums[mid] == target) return mid;

//          但是这里为什么反过来不行
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SearchInsert s = new SearchInsert();
        int res = s.solution(new int[]{1,3,5,6},2);
        System.out.println(res);
    }
}
