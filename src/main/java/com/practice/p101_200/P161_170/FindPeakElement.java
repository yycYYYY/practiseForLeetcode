package com.practice.p101_200.P161_170;

/**
 * @Author: yyc
 * @Date: 2022/4/8 3:08 PM
 * @Description: lc 161 mid :寻找峰值（局部极值）
 *
 * 二分查找的变种题
 *
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 *
 * 示例2：
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *     或者返回索引 5， 其峰值元素为 6。
 *
 * 提示：
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 */
public class FindPeakElement {

    /**
     * 变种题：局部最大值
     * 无序array，任何相邻两个数不相等，查找array中任意一个局部最大值
     * 局部最大值定义：一个值大于相邻的两个值，即为局部最大值，如果这个值是端点值，那么它大于相邻的一个值即为局部最大值
     * 例如： 1， 2， 9， 8， 11， 10 这里面9， 11都是局部最大值
     * 要求时间复杂度，好于N，最好logN
     *
     * 例子：
     * 1，2，6，11，13，9，14，16，它的局部最大值就是13、16
     * 思路：如果起始终点两个端点不是局部最大值，且数组内一定存在局部最大值，那么数组两端的数值变化趋势一定是相反的，
     * 并且在两个端点中间一定存在局部最大值。因为将数组的值，看做一个变化曲线，两端趋势变化相同，中间一定存在某个点为拐点
     * 由此，我们可以二分，如果两罐变化趋势相同，则这两个端点间，就可能不存在拐点（也可能有拐点，例如变化两次方向，数值先升高，再降低，
     * 但我们不做考虑，因为会较大的提高复杂度），抛弃并选择另一段（另一段一定存在拐点），
     * 如果当前两端数值变化趋势相反，就接着二分，直至找到不同的最小趋势（三个数，中间比两边小）
     */

    public int solution(int[] nums){
        if (nums.length == 1){
            return 0;
        }
        if (nums.length < 1){
            throw new RuntimeException("数组过短");
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        if (nums[left] > nums[left + 1]){
            return 0;
        }
        if (nums[right] > nums[right - 1]){
            return right;
        }

        while (right != left){
            // 在业务中不要这么写，因为>>1和/2在奇负数的结果上是不一样的，-5/2=-2, -5>>1=-3
            int mid = (right + left) >> 1;
            if (right - left == 2 && !isSameDirection(nums, left, right)){
                return mid;
            }
            if (!isSameDirection(nums, mid, right)){
                left = mid;
            }else {
                // 注意二分的边界问题，左闭右开
                right = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 判断数组两个端点数值的变化趋势是否相同
     * 左侧端点变化趋势判定: n - (n + 1)
     * 右侧端点变化趋势判定: m - (m -1)
     * 例如：
     * 1,2,3,4,5   判断0,4的趋势是否相同 0位置是1->2  ,4位置是3->4,都是增大的，变化趋势相同
     */
    private boolean isSameDirection(int[] nums, int left, int right){
        System.out.println((nums[left + 1] - nums[left]) * (nums[right] - nums[right - 1]) > 0);
        return (nums[left + 1] - nums[left]) * (nums[right] - nums[right - 1]) > 0;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,2,1};
        FindPeakElement findPeakElement = new FindPeakElement();
        System.out.println(findPeakElement.solution(nums));
    }
}
