package com.practice.P1_100.P31_40;

public class SearchInsert {
    /*
    NO.35 搜索插入位置
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

    你可以假设数组中无重复元素。

    示例 1:
    输入: [1,3,5,6], 5
    输出: 2

    示例 2:
    输入: [1,3,5,6], 2
    输出: 1

    示例 3:
    输入: [1,3,5,6], 7
    输出: 4

    示例 4:
    输入: [1,3,5,6], 0
    输出: 0
     */
    int solution(int[] nums,int target){
        int res = 0;
        int left = 0,right = nums.length - 1;

        while(left <= right){

            int mid = (left + right) >> 1;
//            if (nums[mid] == target){
//                return mid;
//            }
//
//            if (left >= right){
//                if (nums[left] > target){
//                    return left == 0?0:left - 1;
//                }else {
//                    return left  + 1;
//                }
//            }

            if (nums[mid] <= target){
                res = left;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SearchInsert s = new SearchInsert();
        int res = s.solution(new int[]{0,1,3,4},2);
        System.out.println(res);
    }
}
