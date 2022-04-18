package com.practice.sort;

/**
 * 快排：
 * 时间复杂度:O[N * logN] ~ O[N^2]
 * 空间复杂度:o[logN] ~ O[N]
 * 最差情况是O[N^2]，划分值打的最偏的端点，每次只搞定一个数（保证一个数顺序正确）
 * 为什么是 O[N * logN]，最差是N的二次方，但是基准值的选择是随机的，列举不同的基准值的排序复杂度再求平均是N * logN
 *
 * @author yongchaoyu
 */
public class QuickSort {
    /**
     * 左神快排
     * 1.0
     * 划定最右侧值为基准值，左侧索引为小于等于基准值，右侧索引为大于基准值
     * 初始索引，当前索引：0，左：0， 右：length - 2 （length - 1 为基准值）
     * 当前索引从左开始遍历，如果小于等于基准值，不动，左索引右移，当前索引右移；如果大于基准值，当前值与右索引值交换，当前索引不动，右索引左移
     * 遍历至当前索引等于右侧索引，交换当前索引值与基准值，得到当前索引为中间值，左侧都小于等于它，右侧都大于等于它
     * 2.0 荷兰国旗问题
     * 再多分出一个等于基准值的区域
     * 同样从左开始遍历，小于基准值，当前值不动，左索引右移，当前索引右移；等于基准值，当前值不动，左索引不动，当前索引右移；如果大于基准值，当前值与右索引值交换，当前索引不动，右索引左移
     */

    void sort1(int[] nums, int start, int end){

        if (nums == null || nums.length <= 1 || start >= end){
            return;
        }

        int left = start;
        int right = end;
        int base = nums[start];

        /*
         * 0、默认选取最左面的数为基准值
         * 1、先从左找左面大于基准值的数据，位置记为左索引
         * 2、再从右找右面小于基准值得数据，位置记为右索引
         * 3、交换12步骤中的数据（左右索引中的数据）
         * 4、此时左索引就是基准位，并且左索引中的数据是小于基准值的，所以将左索引其中的值放到最左端，基准值放到左索引中
         * 5、分治，【起始位置-左索引-1】，【左索引+1，终点位置】两个数组分别再排序（找自己的基准值）
         */
        while (left < right){
            while (nums[left] <= base && left < right){
                left++;
            }

            while (nums[right] >= base && left < right){
                right--;
            }

            if (left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        nums[start] = nums[left];
        nums[left] = base;
        sort1(nums, start, left - 1);
        sort1(nums, left + 1, end);

    }

    static void sort2(int[] nums, int start, int end){
        if (nums == null || nums.length == 0 || nums.length == 1 || start >= end){
            return;
        }

        int left = start;
        int right = end;
        int base = nums[start];

        /* 
         * 0、默认选取最左面的数为基准值
         * 1、从右面开始找，找到比基准数小的，切换到左面（与左面的起始位置调换）
         * 2、再通左面开始找，找到比基准数大的，切换到右面（与右面的当前位置调换）
         * 3、此时的左索引的位置就是基准位，把一开始选中的基准值放到基准位上（此时基准位左面的元素都小于基准值，右面的都大于基准值）
         * 4、分治，除开基准值外，基准值两侧的数组再分别排序（分别寻找各自的基准值）
         */
        while (left < right){

            while (left < right && nums[right] >= base){
                right++;
            }
            nums[left] = nums[right];

            while (left < right && nums[left] <= base){
                left++;
            }
            nums[right] = nums[left];
        }

        nums[left] = base;
        sort2(nums, start, left - 1);
        sort2(nums, right + 1, end);
    }
}
