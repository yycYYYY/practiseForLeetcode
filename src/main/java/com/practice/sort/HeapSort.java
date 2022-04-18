package com.practice.sort;

/**
 * 堆排序：
 * 堆结构其实就是数组实现的完全二叉树
 * 完全二叉树中，每颗树的顶点都是最大值的是大根堆，顶点是最小值的是小根堆
 * 完全二叉树：所有节点都是满的，或者最新的节点没满，但处于从左到右在变满的过程中，也属于完全二叉树
 * @Author yyc
 **/
public class HeapSort {

    /**
     * 利用heap的性质，先构造出一个最大/小堆，然后依次取出最值（根节点），然后重新稳定，再取出根节点
     * 稳定的方式：将最底层的右侧子节点，放回根节点，然后向下heapify，获得稳定
     * 时间复杂度：O[N * logN] + O[N * logN] 也就是O[N * logN]
     * 空间复杂度: O[1]自始至终没有开辟新内存，就是使用本身的数组进行排序
     */
    public int[] sort(int[] arrays){
        if (arrays == null || arrays.length <= 1){
            return arrays;
        }
        for (int i = 0; i < arrays.length; i++){
            // O[logN]
            insert(arrays, i);
        }

        int heapSize = arrays.length - 1;
        // 生成大根堆的优化方法
//        for (int i = arrays.length - 1; i >= 0; i--){
//            heapify(arrays, i, heapSize);
//        }

        while (heapSize > 0) {
            // O[logN]
            heapify(arrays, 0, heapSize);
            // O[1]
            swap(arrays, 0, --heapSize);
        }

        return arrays;
    }

    public void insert(int[] val, int index){
        while (val[index] > val[(index - 1) / 2]){
            swap(val, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void heapify(int[] val, int index, int heapSize){
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
            swap(val, largerIndex, index);
            // 向下迭代，将更大的元素浮到父节点上
            left = (index * 2) + 1;
        }
    }

    private void swap(int[] val, int p1, int p2){
        int temp = val[p1];
        val[p1] = val[p2];
        val[p2] = val[temp];
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        System.out.println(heapSort.sort(new int[]{2,1}));
    }
}
