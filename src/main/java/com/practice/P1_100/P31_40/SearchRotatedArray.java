package com.practice.P1_100.P31_40;

/**
 NO.33  搜索旋转排序数组
 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 ( 例如，数组[0,1,2,4,5,6,7]可能变为[4,5,6,7,0,1,2])。
 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回-1。
 你可以假设数组中不存在重复的元素。
 你的算法时间复杂度必须是O(logn) 级别。

 示例 1:
 输入: nums = [4,5,6,7,0,1,2], target = 0
 输出: 4

 示例2:
 输入: nums = [4,5,6,7,0,1,2], target = 3
 输出: -1
 */
public class SearchRotatedArray {

    /*
    阶段性的二分
    例如：567891234,
    判断
     */
    int solution(int[] nums,int target){
        if (nums.length == 0) return -1;
        int l = 0,r = nums.length -1,mid = 0;

        while(l <= r){
            mid = l + ((r - l) >> 1);
            if (target == nums[mid]) return mid;
//          判断mid处于当前区间的左端还是右端，如果是左端，走下面的逻辑
            if (nums[mid] >= nums[l] && nums[mid] > nums[r]){
//              注意此处应>= ，否则[3,5]  3   用例过不去
                if (target >= nums[l] && target < nums[mid]){
                    r = mid -1;
                }else {
                    l = mid + 1;
                }

//          如果是右端，走下面的逻辑
            }else if (nums[mid] <= nums[r] && nums[mid] < nums[l]){
//              此处应<=,  原因遇上同理
                if (target <= nums[r] && target > nums[mid]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }

//          当前区间没有了左端右端，变成了自小到大有序的数组
            }else {
                if (target > nums[mid]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }

            }
        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedArray s = new SearchRotatedArray();
        int res = s.solution(new int[]{3,5,1},3);
        System.out.println(res);
    }
}
