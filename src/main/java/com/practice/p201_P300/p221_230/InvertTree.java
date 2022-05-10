package com.practice.p201_P300.p221_230;

import com.practice.dataStructure.TreeNode;

/**
 * @Author: yyc
 * @Date: 2022/5/6 5:39 下午
 * @Description: lc easy 226 反转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 示例 2：
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 *
 * 提示：
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class InvertTree {

    /**
     * 递归反转，所有二叉树递归都是一个套路，二叉树的递归和迭代需要偶尔看一下，时间久了，容易忘
     */
    public TreeNode solution(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode left = solution(root.left);
        root.left = solution(root.right);
        root.right = left;
        return root;
    }
}
