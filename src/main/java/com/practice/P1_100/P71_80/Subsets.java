package com.practice.P1_100.P71_80;

import java.util.*;

/**
 * NO.78 子集
 * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 * @Author yuyongchao
 **/
public class Subsets {
    /**
     * 非常典型的dfs回溯剪枝去重
     * 回溯中，主要的难点就是1、递归操作2、剪枝操作
     * 这里的递归没什么好说的，就是深度遍历
     * 剪枝操作主要使用了三个技巧
     * 一个是used[]通过标记是否使用过，来避免统一子树下，相同数字本身的重复使用
     * 一个是通过每次递增的cur，保证在每个同级子树后续的遍历过程中，避免使用前一个树的根结点，作为后一个树遍历时的候补节点
     * 最后是，在递归时，path内新增的元素，必须保证大于path中的前一个元素，来避免出现异位词
     *
     * 这次回溯，做的总算不像之前那么慢了，但估计下次很久不看回溯之后，再看到自己写的答案，还是可能看不懂。。。。就像之前刷DP一样，
     * 最后终于可以独立不依靠答案，刷medium的DP了，两个月之后又全忘了，自己的答案都看不懂
     * 这个时候要记住，DP要找状态方程！！！就像是太极中的那条竖线，找到变化中的不变的那个动态的式子
     * 回溯就画树！！！！
     * 去重就排序！！！！或者记录路径！！！
     * 去重先排序！！！！！这个很重要，无论是这道题中的cur、、path最新元素大于前一个元素，还是全排列中的判断当前元素与上一个元素是否相等，
     * 都是依靠排序之后再做操作
     * @param nums
     * @return
     */
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        boolean[] used = new boolean[length];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(res, nums, path, used, length, 0, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, Deque<Integer> path,boolean[] used, int length, int depth, int cur){
        res.add(new ArrayList<>(path));
        if (depth == length){
            return;
        }
        for (int i = cur; i < length; i++) {
            if(!used[i]){
                //这里做一下去重，如果nums里没有重复元素，并且要求子集元素不能重复，那就保证不出现异位词即可。
                //由此，我们可以通过保证子集内部也是有序的，这个方式来避免出现重复子集。假如结果里有，123和132，那么132就是不被允许的，因为它不是有序的
                //这样可以避免异位词的出现，也就避免了重复子集的出现
                if (!path.isEmpty() && nums[i] < path.getLast()){
                    continue;
                }
                path.addLast(nums[i]);
                used[i] = true;
                dfs(res, nums, path, used, length, depth + 1, cur + 1);
                path.removeLast();
                used[i] = false;
                depth--;
                //注意此处应该有一个非0判断，这是因为cur的初始值是0，如果不判断，在回溯到源头时，可能出现cur = -1的情况，导致used[cur]数组溢出
                if (cur != 0){
                    cur--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] a = {1,2};
        List res = s.solution(a);
        System.out.println(res);
    }
}
