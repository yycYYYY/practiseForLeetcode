package com.practice.sort;

/**
 * 选择排序：
 * 每次选择最大的或者最小的，进行排序
 * 时间复杂度 n'2
 * 最大时间复杂度 n'2
 * 最小时间复杂度 n
 * 空间复杂度 1
 * 稳定性 1
 * @Author yuyongchao
 **/
public class SelectionSort {

    public int[] sort(int[] arrays){
        if (arrays == null || arrays.length <= 1){
            return arrays;
        }

        for (int i = 0; i < arrays.length; i++) {
            int min = i ;
            for (int j = i; j < arrays.length; j++) {
                if (arrays[j] < arrays[min]){
                    min = j;
                }
            }
            int temp = arrays[min];
            arrays[min] = arrays[i];
            arrays[i] = temp;
        }
        return arrays;
    }
}
