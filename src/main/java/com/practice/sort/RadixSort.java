package com.practice.sort;

/**
 * 基数排序
 * 桶排序
 * 例如对[013,100,017,072,025]进行排序，由于最大数有三位（百十个），准备十个桶，进出三轮
 * 桶内先进先出
 * 第一轮，根据个位数进桶出桶
 * 进桶：
 * 0桶 100； 1桶无； 2桶 072; 3桶 013；...；5桶 015; ... ;  7桶 017 ;...;9桶 无
 * 出桶：
 * [100, 072, 013, 025, 017]
 *
 * 第二轮，根据十位进桶出桶
 * 进桶：
 * 0桶 100； 1桶 013、 017； 2桶 025; 3桶 无；...；5桶 无; ... ;  7桶 072 ;...;9桶 无
 * 出桶：
 * [100, 013, 017, 025, 072]
 *
 * 第三轮，根据百位进桶出桶
 * 进桶：
 * 0桶  013, 017, 025, 072； 1桶 100； 2桶 无; 3桶 无；...；5桶 无; ... ;  7桶 无 ;...;9桶 无
 * 出桶：
 * [013, 017, 025, 072, 100]
 *
 * 排序完成
 * @Author yuyongchao
 **/
public class RadixSort {

    /**
     * 这个实现非常吊，如果忘记了可以回头看
     * @param array 待排序数组
     * @param L 需要排序的起始位，左端
     * @param R 需要排序的终止位，右端
     * @param digit 包含的数据的最大数值的进制位，最大数11，两位，最大数1111四位，最大数是123456就是6位
     */
    public void sort(int[] array, int L, int R, int digit){
        final int radix = 10;
        int i, j;
        int[] bucket = new int[R - L + 1];
        // 最大数进制位有多少，就需要进桶出桶多少次
        for (int d = 0; d < radix; d++){
            // count[0~9]是个空间
            // count[0] 当前位(d位)是0的数字有多少个
            // count[1] 当前位(d位)是0~1的数字有多少个
            // count[2] 当前位(d位)是0~2的数字有多少个
            // count[3] 当前位(d位)是0~3的数字有多少个
            int[] count = new int[radix];

            // 进桶
            for (i = L; i <= R; i++){
                j = getDigit(array[i], d);
                count[j]++;
            }
            // 分片，count[i]表示当前位小于等于i的总个数，这样的好处是，在出桶给bucket辅助空间赋值的时候，好定位
            // 例如，count[0] = 11, count[1] = 23, count[2] = 59，可知，个位数是0的数在bucket数组中的位置是0~10
            // 个位数是0的数在bucket数组中的位置是11~22，个位数是0的数在bucket数组中的位置是23~58
            // 这样在出桶赋值寻址时，可以快速定位，每次桶弹出一个元素，桶内的数值减一，例如2桶弹出来一个，23 - 1 》 22
            // 下次再弹的时候，直接拿就好了， 优雅
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            for (i = R; i >= L; i--){
                j = getDigit(array[i], d);
                bucket[count[j] - 1] = array[i];
                count[j]--;
            }

        }

        for (i = L, j = 0; i <= R; i++, j++){
            array[i] = bucket[j];
        }
    }

    private int getDigit(int num, int d){
        return ((num / (int)Math.pow(10, d - 1)) % 10);
    }
}
