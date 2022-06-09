package com.practice.p101_200.p111_120;

import com.practice.dataStructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: yyc
 * @Date: 2022/6/9 2:21 下午
 * @Description: lc mid NO.114 二叉树展开为链表
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 * 提示：
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 */
public class Flatten {

    /**
     * 前序遍历，存到一个队列里，然后再遍历拼接
     */
    public void solution1(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<>();
        recursion(root, queue);
        TreeNode cur = queue.removeFirst();
        while (!queue.isEmpty()){
            cur.right = queue.removeFirst();
            cur = cur.right;
        }
    }

    private void recursion(TreeNode root, Deque<TreeNode> queue){
        if (root != null){
            queue.addLast(root);
            recursion(root.left, queue);
            recursion(root.right, queue);
        }
    }

    /**
     * 在每次递归时，原地修改
     */
    public void solution2(TreeNode root){
        if (root == null){
            return;
        }
        recursion2(root);
    }


    private TreeNode recursion2(TreeNode node){
        if (node == null){
            return null;
        }
        TreeNode cur = node;

        TreeNode left = recursion2(node.left);
        TreeNode right = recursion2(node.right);

        cur.left = null;
        if (left != null){
            cur.right = left;
            // 移动指针至左子树及根节点转换成的链表最后一位
            while (cur.right != null){
                cur = cur.right;
            }
        }

        if (right != null){
            cur.right = right;
        }

        return node;
    }
}
