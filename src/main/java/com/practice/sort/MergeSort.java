package com.practice.sort;

/**
 * 归并排序：
 * 简单递归，小的放左侧，大的放右侧
 * 时间复杂度:N * logN
 * 空间复杂度: O[N]
 *
 * 相比于N的二次方的排序来说，优点在于利用了额外的空间，来保存了比较的信息，每一次小的排序后，
 * 都获得了一个小的有序数组，避免了大量比较操作的浪费
 * @Author yyc
 **/
public class MergeSort {

    public int[] sort(int[] nums){
        if (nums == null || nums.length <= 1){
            return nums;
        }
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int left, int right){
        if (left == right){
            return;
        }
        int mid = (left + right) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= right){
            temp[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }

        while (p1 <= mid){
            temp[i++] = nums[p1++];
        }

        while (p2 <= right){
            temp[i++] = nums[p2++];
        }
        for (int j = 0; j < temp.length; j++) {
            nums[left + j] = temp[j];
        }
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        for (int i: sort.sort(new int[]{1,3,4,2,5})) {
            System.out.println(i);
        }
    }
}
