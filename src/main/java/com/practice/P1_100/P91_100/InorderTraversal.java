package com.practice.P1_100.P91_100;

import com.practice.dataStructure.ListNode;
import com.practice.dataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * N0.94 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[2,1]
 *
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 进阶:递归算法很简单，你可以通过迭代算法完成吗？
 * @author admin
 */
public class InorderTraversal {
    public List<Integer> solution(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        inOrderTraverse(root, res);
        return res;
    }

    /**中序遍历*/
    public void inOrderTraverse(TreeNode node, List<Integer> res){
        if (node != null){
            inOrderTraverse(node.left, res);
            res.add(node.val);
            inOrderTraverse(node.right, res);
        }
    }

    /**
     * 前序遍历
     * */
    public void preOrderTraverse(TreeNode node, List<Integer> res){
        if (node != null){
            res.add(node.val);
            preOrderTraverse(node.left, res);
            preOrderTraverse(node.right, res);
        }
    }

    /**
     * 后序遍历
     * */
    public void postOrderTraverse(TreeNode node, List<Integer> res){
        if (node != null){
            postOrderTraverse(node.left, res);
            postOrderTraverse(node.right, res);
            res.add(node.val);
        }
    }

    /**非递归的前序遍历*/
    public Deque<TreeNode> preOrderTraverse1(TreeNode root){
        Deque<TreeNode> res = new ArrayDeque<>();

        if (root == null){
            return res;
        }
        TreeNode pre = root;
        while (pre != null || !res.isEmpty()){
            if (pre != null){
                res.push(pre);
                pre = pre.left;
            }else {
                TreeNode temp = res.pop();
                pre = temp.right;
            }
        }

        return res;
    }

}
