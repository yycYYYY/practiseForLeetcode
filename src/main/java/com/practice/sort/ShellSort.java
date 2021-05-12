package com.practice.sort;

import java.util.Arrays;

/**
 * 冒泡：
 * 时间复杂度 n'2
 * 最大时间复杂度 n'2
 * 最小时间复杂度 n'2
 * 空间复杂度 1
 * 稳定性 0
 * @Author yuyongchao
 **/
public class ShellSort {
    public int[] solution(int[] arrays){
        if (arrays == null || arrays.length == 0){
            return arrays;
        }

        for (int i = 0; i < arrays.length; i++) {
            int min = arrays[i];
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[j] < min){
                    arrays[i] = arrays[j];
                    arrays[j] = min;
                    min = arrays[i];
                }
            }
        }
        return arrays;
    }


    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        System.out.println(Arrays.toString(sort.solution(new int[]{4, 6, 3, 2, 1})));
    }
}
