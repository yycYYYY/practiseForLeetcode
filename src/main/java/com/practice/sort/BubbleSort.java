package com.practice.sort;

/**
 * 冒泡：
 * 遍历位置，将大的数上浮到顶部，或将小的数下沉到底部
 * 时间复杂度 n'2
 * 最大时间复杂度 n'2
 * 最小时间复杂度 n
 * 空间复杂度 1
 * 稳定性 1
 * 稳定：如果a原本在b前面，而a=b，排序之后a仍然在b的前面；
 * 不稳定：如果a原本在b的前面，而a=b，排序之后a可能会出现在b的后面；
 * @Author yyc
 **/
public class BubbleSort {

    public int[] sort(int[] arrays){
        if (arrays == null || arrays.length <= 1){
            return arrays;
        }

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - 1 - i; j++) {
                if (arrays[j + 1] < arrays[j]){
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
        }
        return arrays;
    }
}
