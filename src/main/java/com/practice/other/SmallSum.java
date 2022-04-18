package com.practice.other;

/**
 * @Author: yyc
 * @Date: 2022/4/8 8:10 PM
 * 小和问题：
 * 在一个数组中，ei诶一个数左边所有比当前数小的数加起来，得到的值即为小和。
 * 例如：
 * 1，3，4，2，5的小和为 (0) + (1) + (1 + 3) + (1) + (1 + 3 + 4 + 2) = 16
 */
public class SmallSum {

    /**
     * 简单方式，按位遍历，查出每位的小和，然后相加
     * 时间复杂度为N的二次方
     */
    public int solution1(int[] nums){
        int res = 0;
        if(nums.length <= 1){
            return res;
        }

        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i && nums[j] < nums[i]; j++){
                res += nums[j];
            }
        }
        return res;
    }

    /**
     * 二分的变种方法
     * 时间复杂度为logN，这也是此题的最优时间复杂度解
     * 这个小和，也可以采用另外一种计算方式，也就是从前往后，依次计算后面有多少个数大于当前数，有多少个数大于当前数，
     * 就将多少个当前值计算到小和中。
     * 这样的计算方式，也就是lc 315 hard 计算右侧小于当前元素的个数同样的需要求
     * 例如：
     * 1，3，4，2，5
     * 1 -> 后面有4个数大于1 -> 1 * 4
     * 3 -> 后面有2个数大于3 -> 3 * 2
     * 4 -> 后面有1个数大于4 -> 4 * 1
     * 2 -> 后面有1个数大于2 -> 2 * 1
     * 5 -> 后面没有数      -> 5 * 0
     */
    public int solution2(int[] nums){
        return process(nums, 0, nums.length - 1, 0);
    }

    private int process(int[] nums, int left, int right, int sum){
        if (left < right){
            int mid = (right + left) /2;
            sum = process(nums, left, mid, sum);
            sum = process(nums, mid + 1, right, sum);
            sum = merge(nums, left, mid, right, sum);
            return sum;
        }
        return sum;
    }

    private int merge(int[] nums, int left, int mid, int right, int sum){
        int[] temp = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int current = 0;

        while (p1 <= mid && p2 <= right) {
            if (nums[p1] < nums[p2]){
                temp[current++] = nums[p1];
                sum += nums[p1] * (right - p2 + 1);
                p1++;
            }else {
                                temp[current++] = nums[p2++];
            }
//            注意下方代码是错误的，原因是又开始的思路整理就是错误的，如果左侧数值大于右侧数值不产生小和
//            else if (nums[p1] > nums[p2]) {
//                temp[current++] = nums[p2];
//                sum += nums[p2] * (mid - p1 +1);
//                p2++;
//            }else {
//                temp[current++] = nums[p2++];
//            }
        }

        while (p1 <= mid){
            temp[current++] = nums[p1++];
        }

        while (p2 <= right){
            temp[current++] = nums[p2++];
        }

        for (int i = left; i < temp.length; i++){
            nums[left + i] = temp[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        SmallSum smallSum = new SmallSum();
        int[] nums = {1,3,4,2,5};
        int sum = smallSum.solution2(nums);
        System.out.println(sum);
    }
}
