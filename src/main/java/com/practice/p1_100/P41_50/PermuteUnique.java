package com.practice.p1_100.P41_50;

import java.util.*;

/**
 * NO.47 全排列2
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。（相对于NO.46，输入nums可能包含重复数字）
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 */
public class PermuteUnique {

    /**
     * 相比于NO46的全排列，需要有一个去重的操作，也就是下方
     * @param nums
     * @return
     */
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        int length = nums.length;
        Deque<Integer> path =  new ArrayDeque<>(length);
        boolean[] used = new boolean[length];

        Arrays.sort(nums);
        dfs(nums, 0, length, path, res, used);
        return res;
    }

    public void dfs(int[] nums, int depth, int length, Deque path, List res, boolean[] used){
        //添加了一个判重逻辑，如果重复，就不往res里加。这种方式虽然简单，不需要思考，但实际上如果这么弄
        //这个解法就不是回溯了，完全是DFS（遍历了所有情况，在到达叶子节点时，判断是否增加至结果集）了
        //回溯的话，我们需要剪枝操作，在树路径向下遍历的某处位置，下面的路径都不符合条件，就直接剪掉，不再进行遍历
        if(depth == length){

//            使用非回溯的方法，遍历所有情况
//            List<Integer> pathRes = new ArrayList<>(path);
//            if(!res.contains(pathRes)){
//                res.add(new ArrayList(path));
//            }

            res.add(new ArrayList(path));
        }

        for(int i = 0;i < length;i++){

            //非常巧妙的剪枝方式，看了答案，才明白
            //排序后，重复的数字都是挨着的，第一次遇到两个重复的数字后，正常加到res，第二次遇到重复的数字，就判断他的值是不是和前面的值一样，
            //如果一样，就剪枝（画下树型图，自己走一下路径，就特别清晰了）
            //举个例子，1，2，【2】；第一次遍历得到1，2，【2】，第二次遍历路径是1，【2】，？此时判断used数组是[1,0,1]，【2】的值等于2，
            // 并且2（第一个2），没有被添加，此时就不需要添加了，直接剪枝，因为res已经存在和1，【2】，2相同的1，2，【2】了

            // 剪枝条件即：和前一个元素值相同（此处隐含这个元素的index>0），并且前一个元素还没有被使用过

            //考虑重复元素一定要优先排序，将重复的都放在一起，便于找到重复元素和剪枝！！！
            //推广至 --> 如果涉及考虑重复元素，或者大小比较的情况，对列表排序是一个不错的选择

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            if(!used[i]){
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, depth + 1, length, path, res, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
