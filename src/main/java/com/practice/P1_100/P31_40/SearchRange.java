package com.practice.P1_100.P31_40;

public class SearchRange {
    /*
    NO.34 在排序数组中查找元素的第一个和最后一个位置
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    你的算法时间复杂度必须是 O(log n) 级别。
    如果数组中不存在目标值，返回 [-1, -1]。

    示例 1:
    输入: nums = [5,7,7,8,8,10], target = 8
    输出: [3,4]

    示例 2:
    输入: nums = [5,7,7,8,8,10], target = 6
    输出: [-1,-1]
     */
    int[] solution(int[] nums,int target){
        int[] res = new int[]{-1,-1};
        int left = 0,right = nums.length - 1;

        while(left <= right){
            int mid = (left + right)>>1;
            if (nums[mid] == target){
                int l = mid,r = mid;

                while (l != 0 && nums[l - 1] == target) --l;
                res[0] = l;

                while (r != nums.length - 1 && nums[r + 1] == target) ++r;
                res[1] = r;

            }

            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SearchRange s = new SearchRange();
        int[] res = s.solution(new int[]{5,6,7,7,8,8,9},8);

        for (int i:res){
            System.out.println(i);
        }
    }
}