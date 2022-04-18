package com.practice.other;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: yyc
 * @Date: 2022/4/15 10:36 PM
 * @Description: 堆结构扩展题
 *
 * 一直一个几乎有序的数组，几乎有序是指，如果把数组排好序，每个元素移动的距离可以不超过K，并且K相对于数组来说比较小。
 * 请选择一个合适的排序算法对这个数据进行排序，要求复杂度比较低
 */
public class HeadExtend implements Comparator<HeadExtend> {

    long age;

    /**
     * 这个题，光看题干很难理解，举个例子看会简单很多
     * 例子：
     * nums = [3,2,1,4,5,8,6,7,20,9], distance = 5
     * 上面的例子中，排好序后每一个元素最大移动距离不会超过5. 也就意味着，整体看，他是"分片有序"的，0~4位置的数，一定小于5~9的数
     * 5~9的数一定小于10~14的数。 因此我们可以构建heapSize为5的小根堆，复杂度为log5. 这5个数后面的数，一定大于当前堆中的根节点，
     * 所以我们往堆里添加第6个数，同时poll出根节点，这两个操作的复杂度都是log5. 此时的最小堆size仍然是5，同理，
     * 第7个数也一定大于当前堆的根节点，重复上面的操作。
     * 所有的操作复杂度为2 * N * logK ，K 远小于N， 优于其他的 N * logN排序算法
     *
     * @param nums 待排序数组
     * @param distance 每个元素需要移动的距离不超过K
     */
    public void sortArrayDistanceLessK(int[] nums, int distance){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index < Math.min(nums.length, distance); index++){
            heap.add(nums[index]);
        }

        int i = 0;
        for (; index < nums.length; i ++, index++){
            heap.add(nums[index]);
            nums[i] = heap.poll();
        }

        while (!heap.isEmpty()){
            nums[i++] = heap.poll();
        }
    }


    @Override
    public int compare(HeadExtend o1, HeadExtend o2) {
        return o1.age > o2.age ? -1 : 1;
    }

}
