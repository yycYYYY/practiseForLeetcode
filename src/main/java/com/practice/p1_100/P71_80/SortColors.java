package com.practice.p1_100.P71_80;

/**
 * NO.75 颜色分类
 * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 *
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[0]
 *
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *
 * @Author yuyongchao
 **/
public class SortColors {
    /**
     * 这不就是排序么？直接Arrays.sort()哈哈哈哈哈
     * 原地排序，那就双指针，比较swap
     * 三指针逐位判断，大于1放到后面，小于1放到前面
     * @param nums
     */
    public void solution(int[] nums){
        if (nums == null || nums.length == 0 || nums.length == 1){
            return;
        }
        int length = nums.length;
        int min = 0;

        //例子0，0， 1， 2， 2， 1， 2， 0， 2， 2
        //找到最小的位置，然后把最小指针指向下一位，在例子中min指向第三位
        while (min < length && nums[min] == 0){
            min++;
        }

        //找到最大位置，然后把最大的指针指向上一位，在例子中max指向倒数第三位
        while (length > 0 && nums[length - 1] > 1){
            length--;
        }

        //因为min是最小值的下一位，所以遍历开始位置cur设为min，从最小位的下一位开始
        int cur = min;
        //大于1，就放到最后，并去掉最后一位，不再遍历；小于1，就放到最前面，min加一；最后cur+1，逐位判断
        while (cur < length){
            if (nums[cur] < 1){
                swap(nums, cur ,min);
                min++;
            }else if (nums[cur] > 1){
                swap(nums, cur, length - 1);
                length--;
                //直接continue，此时无法判断当前cur也就是上一个max的值是什么？所以要continue，再判断一下cur的值
                continue;
            }
            cur++;
        }
    }

    public void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
//        nice！速度上打败100%的人
        int[] a = {2, 0, 2, 1, 1, 0};
        int[] b = {2, 0, 1};
        SortColors s = new SortColors();
        s.solution(b);
        System.out.println(b);
    }
}
