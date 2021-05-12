package com.practice.sort;

/**
 * 冒泡：
 * 时间复杂度 n'2
 * 最大时间复杂度 n'2
 * 最小时间复杂度 n
 * 空间复杂度 1
 * 稳定性 1
 * 稳定：如果a原本在b前面，而a=b，排序之后a仍然在b的前面；
 * 不稳定：如果a原本在b的前面，而a=b，排序之后a可能会出现在b的后面；
 * @Author yuyongchao
 **/
public class BubbleSort {

    public int[] solution(int[] arrays){
        if (arrays == null || arrays.length == 0){
            return arrays;
        }

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - 1 - j; j++) {
                if (arrays[j] > arrays[j + 1]){
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
        }
        return arrays;
    }
}
