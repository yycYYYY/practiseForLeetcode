package com.practice.P1_100.P51_60;

import java.util.ArrayList;
import java.util.List;

/**
 * NO.56 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class Merge {
    /**
     * 看到题的第一思路，将二维数组里每个子数组按照starti排序，然后遍历如果第二个数组的starti处于第一个数据的区间中，
     * 则合并两个数组，首先是这个排序，怎么排比较好，先写个最简单爷最熟悉的冒泡/选择吧，整体写完了再换效率高的排序
     * @param intervals
     * @return
     */
    public int[][] solution(int[][] intervals) {
        if (intervals == null || intervals.length <= 1){
            return intervals;
        }
        int length = intervals.length;
        List<int[]> res = new ArrayList<>();

        //这个冒泡，我猜会超时。还行，没超时，换个写法，换成下面的重写Arrays.sort()
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (intervals[j + 1][0] < intervals[j][0]){
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }

        for (int i = 1; i < length; i++) {
            if (intervals[i][0] > intervals[i - 1][1]){
                res.add(intervals[i - 1]);
                continue;
            }
            intervals[i][0] = intervals[i - 1][0];
            if (intervals[i][1] < intervals[i - 1][1]){
                intervals[i][1] = intervals[i - 1][1];
            }
        }
        res.add(intervals[length - 1]);

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] nums = {{4, 5}, {1, 5}, {0, 1}, {15, 18}};
        Merge m = new Merge();
        int[][] res = m.solution(nums);
        System.out.println(res);
    }
}
