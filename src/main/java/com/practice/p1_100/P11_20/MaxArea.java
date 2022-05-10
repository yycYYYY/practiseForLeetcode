package com.practice.p1_100.P11_20;

public class MaxArea {
    /*
    NO.11   盛水最多的容器
     给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
     在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0)。
     找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。

    说明：你不能倾斜容器，且n的值至少为 2。
     */

    /*
    看到本题的第一思路，就是双指针，pre从1开始cur从2开始，cur到最后一位结束，取一个max记录当前的值。
    每次max = max > pre*cur？直至遍历结束

    看了题解，也是双指针，pre指向第一位，cur指向最后一位，每次移动较小的那个数，每次比较max，最终求得最大体积。
    这才叫双指针握草。
    影响容积有两个因子，x轴y轴，这个思路直接取x最大的情况，逐步缩小，避免了遍历浪费计算路径
     */
    int solution1(int[] height){
        if (height.length < 2) return 0;
        int begin = 0,end = height.length-1;
        int max = 0,h = 0;
        while (end - begin > 0){
            h = Math.min(height[begin],height[end]);
            max = Math.max(max,(end-begin)*h);
            if (height[begin] > height[end]){
                end = end -1;
            }else {
                begin = begin +1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxArea m = new MaxArea();
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(m.solution1(a));
    }
}
