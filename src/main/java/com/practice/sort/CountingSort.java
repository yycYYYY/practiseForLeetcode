package com.practice.sort;

/**
 * 计数排序
 * 非比较排序，按照词频排序
 * 时间复杂度：O[N]
 * @Author yuyongchao
 **/
public class CountingSort {

    /**
     * 计数排序是通过统计次品来实现的排序
     * 例如，对于员工的年龄进行排序，因为员工的年龄会强制的在16~110之间，我们可以通过数组的索引作为年龄项做统计
     * 比方说五个员工年龄，[33, 19, 22, 22, 22]就分别在数组的第 33 - 16、19 -16、 22 - 16位，加1加1加3
     * 最后还原的时候根据数组进行还原
     */
    public void sort(int[] nums){
        int[] counting = new int[10];
        // 按数组位置为key，统计数据出现次数
        for(int i : nums){
            counting[i]++;
        }

        // 将统计数组还原为排好序的数据数组
        for (int j = 0; j < counting.length; j++){
            int current = 0;
            while (counting[j] > 0){
                nums[current++] = j;
                counting[j]--;
            }
        }
    }

    public static void main(String[] args) {

    }
}
