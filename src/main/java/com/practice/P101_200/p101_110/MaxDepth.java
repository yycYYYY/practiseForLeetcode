package com.practice.P101_200.p101_110;

import com.practice.dataStructure.TreeNode;

import java.util.*;

/**
 * @Author: yyc
 * @Date: 2022/4/19 10:04 PM
 * @Description: lc 104 easy 二叉树的最大深度
 * 也就是深度遍历（前序遍历）
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度3 。
 */
public class MaxDepth {

    /**
     * 迭代算法，真滴难写，当前的实现效率有点低，肯定可以再优化
     */
    public int solution1(TreeNode root) {
        int max = 0;
        if (root == null){
            return 0;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode head;
        stack.push(root);
        int curLevel = 1;
        Map<TreeNode, Integer> nodeLevels = new HashMap<>();
        nodeLevels.put(root, 1);

        while (!stack.isEmpty()){
            head = stack.pop();
            curLevel = nodeLevels.get(head);
            max = Math.max(max, curLevel);

            if (head.right != null){
                stack.push(head.right);
                nodeLevels.put(head.right, curLevel + 1);
            }

            if (head.left != null){
                stack.push(head.left);
                nodeLevels.put(head.left, curLevel + 1);
            }
        }
        return max;
    }

    /**
     * 递归算法，比较简单
     */
    public int solution2(TreeNode root) {
        if (root == null){
            return 0;
        }
        return dfs(root, 1);
    }

    private int dfs(TreeNode node, int curLevel){
        if (node == null){
            return curLevel - 1;
        }
        int leftLevel = dfs(node.left, curLevel + 1);
        int rightLevel = dfs(node.right, curLevel + 1);
        return Math.max(leftLevel, rightLevel);
    }

    /**
     * 精简版
     */
    public int solution3(TreeNode root) {
        return root == null ? 0 : (Math.max(solution3(root.left), solution3(root.right)) + 1);
    }

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        int level = maxDepth.solution1(node1);
        System.out.println(level);
    }
}
