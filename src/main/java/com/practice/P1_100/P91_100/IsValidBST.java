package com.practice.P1_100.P91_100;

import com.practice.dataStructure.TreeNode;

/**
 * @Author: yyc
 * @Date: 2022/4/20 12:15 PM
 * @Description: lc 98 mid 验证搜索二叉树
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1：
 * 输入：root = [2,1,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 *
 * 提示：
 * 树中节点数目范围在[1, 104] 内
 * -231 <= Node.val <= 231 - 1
 */
public class IsValidBST {

    long preVal = Long.MIN_VALUE;
    public boolean solution(TreeNode root) {
        return isBST(root);
    }

    /**
     * 中序遍历之后，得到的数组是否是稳定升序，如果是搜索二叉树，一定是稳定升序的，有降序就不是搜索二叉树
     */
    public boolean isBST(TreeNode root){
        if (root == null){
            return true;
        }
        boolean isLeftBst = isBST(root.left);
        if (!isLeftBst){
            return false;
        }
        if (root.val <=  preVal){
            return false;
        }
        preVal = root.val;
        return isBST(root.right);
    }

    /**
     * 迭代方法
     */
    public boolean isBSTIteration(TreeNode root){

        return false;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
//        node1.right = node3;
        IsValidBST isValidBST = new IsValidBST();
        boolean isBst = isValidBST.solution(node1);
        System.out.println(isBst);
    }
}
