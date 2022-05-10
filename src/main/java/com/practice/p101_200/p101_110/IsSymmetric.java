package com.practice.p101_200.p101_110;

import com.practice.dataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yyc
 * @Date: 2022/4/25 1:51 PM
 * @Description: lc 101 easy 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class IsSymmetric {
    /**
     * 递归
     */
    public boolean solution1(TreeNode root) {
        if (root == null){
            return true;
        }

        return isEquals(root.left, root.right);
    }

    private boolean isEquals(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }
        if ((node1 == null || node2 == null) || node1.val != node2.val){
            return false;
        }


        boolean leftTree = isEquals(node1.left, node2.right);
        boolean rightTree = isEquals(node1.right, node2.left);

        return leftTree && rightTree;
    }

    /**
     * 迭代
     */
    public boolean solution2(TreeNode root){
        if (root == null){
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode leftHead;
        TreeNode rightHead;
        Deque<TreeNode> leftStack = new ArrayDeque<>();
        Deque<TreeNode> rightStack = new ArrayDeque<>();
        Set<TreeNode> leftHasSeen = new HashSet<>();
        Set<TreeNode> rightHasSeen = new HashSet<>();
        while (left != null){
            leftStack.push(left);
            leftHasSeen.add(left);
            left = left.left;
        }
        while (right != null){
            rightStack.push(right);
            rightHasSeen.add(right);
            right = right.right;
        }

        while (!leftStack.isEmpty() && !rightStack.isEmpty()){
            leftHead = leftStack.pop();
            rightHead = rightStack.pop();
            if (leftHead.val != rightHead.val){
                return false;
            }
            if (leftHead.left != null && !leftHasSeen.contains(leftHead.left)){
                leftStack.push(leftHead.left);
                leftHasSeen.add(leftHead.left);
            }
            if (leftHead.right != null && !leftHasSeen.contains(leftHead.right)){
                leftStack.push(leftHead.right);
                leftHasSeen.add(leftHead.right);
            }

            if (rightHead.right != null && !rightHasSeen.contains(rightHead.right)){
                rightStack.push(rightHead.right);
                rightHasSeen.add(rightHead.right);
            }

            if (rightHead.left != null && !rightHasSeen.contains(rightHead.left)){
                rightStack.push(rightHead.left);
                rightHasSeen.add(rightHead.left);
            }
        }

        return leftStack.isEmpty() && rightStack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        IsSymmetric isSymmetric = new IsSymmetric();
        System.out.println(isSymmetric.solution2(node1));
    }
}
