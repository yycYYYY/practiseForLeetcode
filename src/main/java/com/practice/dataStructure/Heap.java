package com.practice.dataStructure;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: yyc
 * @Date: 2022/4/15 5:12 PM
 * @Description: 堆
 * 堆结构其实就是数组实现的完全二叉树
 * 我们日常使用的优先级队列，就是堆结构   java 的小根堆 PriorityQueue<Integer> heap = new PriorityQueue<>();
 * 默认的PriorityQueue是小根堆，可以传入一个重写的比较器，改为大根堆
 * 日常可以直接使用PriorityQueue，来应对堆结构的场景，但是优先队列不支持，针对某一个特定位置的修改，
 * 以及特定位置修改造成的对结构的破坏的手动修复，也就是这个类中的heapify()方法
 *
 * 完全二叉树中，每颗树的顶点都是最大值的是大根堆，顶点是最小值的是小根堆
 * 完全二叉树：所有节点都是满的，或者最新的节点没满，但处于从左到右在变满的过程中，也属于完全二叉树
 *
 * 在数组中，每一个位置i都能找到预期对应的父子节点
 * 左子节点：2 * i + 1
 * 右子节点：2 * i + 2
 * 父节点：（i - 1）/ 2
 *
 * 如何保持堆的稳定，如果稳定的堆中有一个值变化了，且知道他的位置，那就让它先insert（向上插入），
 * 再heapify（向下调整），两者只有一个操作是有效的，如果都无效，证明改变后的值本身就是稳定的
 */
public class Heap {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int[] val;
    int heapSize = 0;

    public Heap(int[] val){
        this.val = val;
    }

    public int getHeapSize(){
        return heapSize;
    }

    public int getMax(){
        return val[0];
    }

    public int[] getVal(){
        return val;
    }

    /**
     * 时间复杂度：1~logN
     */
    public void insert(int index){
        heapSize++;
        while (val[index] > val[(index - 1) / 2]){
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public int removeMax(){
        int max = val[0];
        val[0] = val[heapSize - 1];
        heapSize--;
        heapify(0);
        return max;
    }

    /**
     * 将当前不规则的堆，规则化
     * 时间复杂度：1~logN
     * @param index 当前不规则元素所在位置
     */
    public void heapify(int index){
        int left = (2 * index) - 1;
        while (left < heapSize){
            // 获得左右两个孩子中较大的孩子的索引
            int largerIndex = left + 1 < heapSize && val[left + 1] > val[left] ?
                    left + 1 : left;
            // 比较父节点与子节点中较大的一个
            largerIndex = val[index] > val[largerIndex] ? index : largerIndex;
            if (largerIndex == index){
                break;
            }
            swap(largerIndex, index);
            // 向下迭代，将更大的元素浮到父节点上
            left = (index * 2) + 1;
        }
    }

    private void swap(int p1, int p2){
        int temp = val[p1];
        val[p1] = val[p2];
        val[p2] = val[temp];
    }

//    public static Heap build(int[] nums){
//        Heap heap = new Heap(nums.length);
//        for (int i : nums){
//            heap.insert(i);
//        }
//        return heap;
//    }
//
//    public static Heap build(List<Integer> nums){
//        Heap heap = new Heap(nums.size());
//        for (int i : nums){
//            heap.insert(i);
//        }
//        return heap;
//    }
}
