package com.practice.p201_P300.p281_290;

/**
 * @Author: yyc
 * @Date: 2022/5/6 5:49 下午
 * @Description: lc easy 283 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *
 * 提示:
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 */
public class MoveZeroes {

    public void solution1(int[] nums) {
        if (nums.length <= 1){
            return;
        }

        int zeroPos = -1;
        int cur = 0;
        while (cur < nums.length){
            if (nums[cur] == 0){
                if (zeroPos == -1 || nums[zeroPos] != 0){
                    zeroPos = cur;
                }
                if (cur + 1 >= nums.length - 1){
                    break;
                }
                if (nums[cur + 1] != 0){
                    swap(nums, zeroPos, cur + 1);
                    cur = zeroPos;
                }

            }
            cur++;
        }

        // 上面的循环不会处理最后一位，需要补充上
        if (zeroPos != -1 && nums[nums.length - 1] != 0){
            swap(nums, nums.length - 1, zeroPos);
        }
    }

    /**
     * 真他吗蠢，把这么简单的双指针想这么复杂，真是傻逼
     */
    public void solution2(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length){
            if (nums[right] != 0){
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }


    public void swap(int[] nums, int p, int q){
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 3, 1, 2};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.solution1(a);
        for (int num : a){
            System.out.println(num);
        }
    }
}
