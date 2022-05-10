package com.practice.p1_100.P31_40;

import java.util.Arrays;

/**
 NO.31 下一个排列
 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 必须原地修改，只允许使用额外常数空间。

 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class NextPermutation {

    void solution(int[] nums){
        if (nums == null || nums.length ==1) return;
        int cur = nums.length - 1;
        int min = nums.length - 1;

        while(cur > 0){
//          找后一个数大于前一个数的位置，例如12345，正解就是12354
            if (nums[cur] > nums[cur - 1]){
//              如果后一个数（当前数cur），大于前一个数（cur-1），就找一找当前数之后，有没有介于nums[cur]nums[cur-1]之间的最小的数
//              例如1232543，cur数{5}>cur-1数{2}，但5之后的4介于，cur和cur-1的值之间有最小的数是3，调换两个数的位置，得到1233542
                if (nums[min] > nums[cur - 1]){
                    int temp = nums[min];
                    nums[min] = nums[cur - 1];
                    nums[cur - 1] = temp;
//                  上一步得到了1233542，但这不是正解，还需要把cur-1后面的数组，做一下排序，1233245才是正解
                    int[] sortNums = new int[nums.length - cur];

                    for (int i = 0;i < sortNums.length;i++){
                        sortNums[i] = nums[cur + i];
                    }
                    Arrays.sort(sortNums);

                    for (int j = 0;j < sortNums.length;j++){
                        nums[cur + j] = sortNums[j];
                    }
                    return;
                }else min--;
            }else cur --;
        }
//      如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        int[] nums = {3,2,1};
        n.solution(nums);
        for (int a:nums){
            System.out.println(a);
        }
    }
}
