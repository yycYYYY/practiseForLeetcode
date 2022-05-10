package com.practice.p201_P300.p231_240;

import com.practice.dataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: yyc
 * @Date: 2022/4/20 8:25 PM
 * @Description: lc 236 mid 寻找最近公共祖先lowestCommonAncestor
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 *
 * 示例 2：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *
 * 提示：
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 */
public class LowestCommonAncestor {

    /**
     * 思路，先深度遍历，找到两个节点，同时将两个节点的路径存储到双向链表里，此时两个链表内的第一个一定是相同的，然后迭代判断，
     * 找到两个链表的最后一个相同值，即最近的公共祖先
     */
    public TreeNode solution1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        Deque<TreeNode> pPath = getTreeNodePath(root, p);
        Deque<TreeNode> qPath = getTreeNodePath(root, q);
        if (pPath.isEmpty() || qPath.isEmpty()){
            return null;
        }

        while (!pPath.isEmpty() && !qPath.isEmpty()){
            TreeNode p1 = qPath.poll();
            TreeNode q1 = pPath.poll();
            if (p1 == q1){
                ancestor = p1;
            }else {
                break;
            }
        }
        return ancestor;
    }

    /**
     * 有点问题，应该使用递归法，然后把path放进去
     * TODO
     * @param root
     * @param target
     * @return
     */
    private Deque<TreeNode> getTreeNodePath(TreeNode root, TreeNode target){
        Deque<TreeNode> path = new ArrayDeque<>();
        TreeNode head = root;
        path.add(head);

        while (!path.isEmpty()){
            head = path.pop();
            if (head == target){
                path.add(head);
                return path;
            }

            if (head.right != null){
                path.add(head.right);
            }

            if (head.left != null){
                path.add(head.left);
            }
        }
        return path;
    }

    /**
     * 使用hash表，先存储所有节点及其父节点的map关系
     * TODO
     * 然后map不断回溯p节点的父节点，爷节点，祖节点....，把它所有父节点放到一个set里
     * 然后再通过mao回溯q节点的父节点，爷节点，祖节点....并判断，每一个父节点是否在set里，第一个发现的就是最近公共节点
     */
    public TreeNode solution2(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    /**
     * 树型DP法，真的牛逼，真是想不到
     * 得到结果的情况有了；两种：
     * 1、q和p在一条树下，一个节点是另外一个节点的祖先
     * 2、q和p在两个子树下，汇聚到p和q之外的一个节点为公共祖先
     *
     * 然后我们当前节点，向左树要答案也就是找q或者找p，找到谁都行，没找到就返回null
     * 同理向右树要答案，也是找q或者p，没找到就返回null
     * 针对上面所有解的情况，如果是1，那么左右给出的答案一定是左/右给p，另一个方向给null，所以我们得到公共节点就是p
     * 如果是2情况，那么左右分别返回q和p，当前节点就是公共祖先，然后依次向上return
     *
     * 这个解法确实屌，但是不可能直接写的出来，一定是通过大量的分析及优化，才得到的题解，所以面试过程中能得到这个解的几率有点小
     */
    public TreeNode solution3(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q){
            return root;
        }

        TreeNode left = solution3(root.left, p, q);
        TreeNode right = solution3(root.right, p, q);

        if (left != null && right != null){
            return root;
        }

        return left == null ? right : left;
    }
}
