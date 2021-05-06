package com.practice.P1_100.P41_50;

import java.util.*;

/**
 * 46.全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @author
 */
public class Permute {

    /**
     * 深度遍历的解法（回溯），关于全排列问题，我们需要找到一个状态规则，把这个排列。定义为一个数，在回溯过程中，我们会有以下几个状态因素
     * 路径path：深度遍历的路径
     * 深度depth：遍历的深度，当我们遍历到最深的时候（到达叶子节点），就是我们结束递归的时候
     * @param nums
     * @return
     */
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if ( nums == null || nums.length == 0){
            return res;
        }

        int length = nums.length;
        Deque path = new ArrayDeque(length);
        boolean[] used = new boolean[length];

        dfs(nums, res, 0, length, path, used);

        return res;
    }

    /**
     * 要记住，dfs的实现不能背的太死，在之前的书中看到，在树的遍历时，我们需要定义一个候选列表
     * dfs的候选列表由栈实现，每遍历到一个节点，就将其子节点，添加至候补列表，由于栈是后进先出，所以在回溯时，
     * 下一个遍历的节点一定是以深度优先的（因为上一层的候补节点，是先添加至列表中的，先进后出，而本层的节点是后添加至列表的，会先出）
     * 上面所说的是，记录没走的节点，作为标记
     * 而这个实现，是记录走过的节点path，作为标记
     * @param nums 源数组
     * @param res 结果集
     * @param depth 遍历的深度
     * @param length 数组长度
     * @param path 遍历路径
     * @param used 当前数组的标识位，是否被遍历走过
     */
    public void dfs(int[] nums, List res, int depth, int length, Deque path, boolean[] used){
        //如果遍历到叶子节点，就证明用完了所有的数，就used[]里所有都是true，将path添加至result
        if (depth == length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0;i < length;i++){
            //如果这一位没被遍历过，就添加到path里；如果已经被遍历过，就直接continue至下一位
            if (!used[i]){
                path.addLast(nums[i]);
                used[i] = true;
                //其实这里的意思就是，每一层递归，都是一个回溯点，当我们dfs到最底层或者遇到剪枝的时候，就回溯到递归的上一层
                dfs(nums, res, depth + 1, length, path ,used);
                //由于我们已经从本层调用的下一层dfs，跳回到本层中了，那么为了下一层dfs所做的状态变更就需要还原，也就是回溯过程
                //把路径中，最后一步走的节点删除，同时把used中对应的标记置为false
                path.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permute p = new Permute();
        int[] a = {1,2,3};
        List<List<Integer>> res = p.solution(a);
        for (List temp: res){
            System.out.println(temp.toString());
        }
    }
}
