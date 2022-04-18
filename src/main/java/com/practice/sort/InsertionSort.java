package com.practice.sort;

/**
 * 插入排序：
 * 从前往后，依次保证部分子串有序，将后面遍历到的元素，插到前方子串中合适的位置
 * 比选择和冒泡稍好一点
 * 例如：
 * 3，2，1，9，7，11 -》 2，3，1，9，7，11 -》 1，2，3，9，7，11 -》1，2，3，7，9，11 -》 1，2，3，7，9，11
 * 时间复杂度 n'2
 * 最大时间复杂度 n'2
 * 最小时间复杂度 n
 * 空间复杂度 1
 * 稳定性 1
 * 稳定：如果a原本在b前面，而a=b，排序之后a仍然在b的前面；
 * 不稳定：如果a原本在b的前面，而a=b，排序之后a可能会出现在b的后面；
 * @Author yyc
 **/
public class InsertionSort {

    public int[] sort(int[] arrays){
        if (arrays == null || arrays.length <= 1){
            return arrays;
        }

        for (int i = 1; i < arrays.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arrays[j] > arrays[j - 1]){
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }else {
                    break;
                }
            }
        }
        return arrays;
    }
}
