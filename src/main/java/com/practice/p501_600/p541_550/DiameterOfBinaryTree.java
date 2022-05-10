package com.practice.p501_600.p541_550;

import com.practice.dataStructure.TreeNode;

/**
 * @Author: yyc
 * @Date: 2022/5/10 4:04 下午
 * @Description: lc easy 543 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class DiameterOfBinaryTree {
    int maxInstance = 0;
    public int solution(TreeNode root) {
        recursion(root, 0);
        return maxInstance;
    }

    /**
     * 深度遍历二叉树
     * 当当前节点有两个子节点的时候，判断左侧最深节点到当前位置的距离，加上右侧最大深度节点到当前位置的距离
     * 是否是最大深度，并且返回左树及右树两者中，最深的距离
     */
    public int recursion(TreeNode root, int depth){
        // 如果当前是null，返回这个null的父节点的depth
        if (root == null){
            return depth - 1;
        }
        // 如果没有子节点，直接返回其depth
        if (root.left == null && root.right == null){
            return depth;
        }
        // 计算左右最深节点的深度，并将两者与当前节点的距离相加，判断是否是最大深度
        int left = recursion(root.left, depth + 1);
        int right = recursion(root.right, depth + 1);
        maxInstance = Math.max(maxInstance, left + right - depth - depth);
        // 返回当前节点下的最大深度
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.left = node5;
        node4.right = node6;

        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        System.out.println(diameterOfBinaryTree.solution(node7));
    }
}
