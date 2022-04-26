package com.practice.other.tree;

import com.practice.dataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: yyc
 * @Date: 2022/4/20 3:38 PM
 * @Description: 是否完全二叉树及满二叉树
 *
 * 此类的所有题，都可以使用一种递归思想来解决：
 * 所有的树，都递归拆分成仅有三个单元的子树，左树及左树包含的信息，当前节点，右树及右树包含的信息。
 * 我们针对不同的场景，需要自己去设计，一次递归所返回的信息，设计完后根据流程，先申请左/右的信息，再申请另一侧的信息，与当前节点比对处理
 * 这也是所有树型DP的解决思想。
 * 同时在解决不同的题的时候，要注意遍历的顺序，前中后序
 *
 * 树型DP，不会做了，就会回过头来，看看这个
 * 树型DP可以使用的前提是，当前节点的问题处理只关乎当前节点直接相连的节点，可以抽象成只有三个节点的最小二叉树，不关心其递归出来的"孙节点"逻辑
 */
public class IsCompletelyTree {

    /**
     * 是否是完全二叉树，当前树正在趋于完整，所有子树都是满的，或者最下层的最后一个节点之前所有子树及节点，都是满的
     * bfs
     * 1」右节点有值，左节点是空，非完全
     * 2』在1的基础上，如果当前节点的左右子节点有缺失，那么后面的节点的两个子节点必须都为空
     */
    public boolean isCompletelyTree(TreeNode root){
        if (root == null){
            return false;
        }

        TreeNode head = root;
        TreeNode left;
        TreeNode right;
        boolean defect = false;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            head = queue.poll();
            left = head.left;
            right = head.right;

            if ((right != null && left == null) || (defect & (left != null && right != null))){
                return false;
            }

            if (left != null){
                queue.add(left);
            }

            if (right != null){
                queue.add(right);
            }

            defect = left == null || right == null;
        }

        return true;
    }

    /**
     * 是否是满二叉树，二叉树的最低层，节点必须是满的
     * 最底层节点个数与层数关系: n = 2^l - 1
     * bfs
     * 层级遍历每一层，遍历到最后看是否满足上述关系
     */
    public boolean isFullTree(TreeNode root){
        if (root == null){return false;}
        FullReturnInfo info = getFullTreeInfo(root);
        return info.nodeCounts == 1 << info.treeHeight - 1;
    }

    private FullReturnInfo getFullTreeInfo(TreeNode node){
        FullReturnInfo res = new FullReturnInfo(0, 0);
        if (node == null){
            return res;
        }

        FullReturnInfo leftInfo = getFullTreeInfo(node.left);
        FullReturnInfo rightInfo = getFullTreeInfo(node.right);
        res.treeHeight = Math.max(leftInfo.treeHeight, rightInfo.treeHeight) + 1;
        res.nodeCounts = leftInfo.nodeCounts + rightInfo.nodeCounts + 1;
        return res;
    }

    /**
     * 是否是满二叉树的返回信息
     */
    static class FullReturnInfo{
        /**
         * 当前节点树高度
         */
        int treeHeight;
        /**
         * 当前节点共有节点数
         */
        int nodeCounts;

        public FullReturnInfo(int treeHeight, int nodeCounts){
            this.treeHeight = treeHeight;
            this.nodeCounts = nodeCounts;
        }
    }
    /**
     * 是否是平衡二叉树
     * 任何一个子树，左树和右树的高度差，不超过1
     * 要求：
     * 左树是平衡的，并且返回其高度
     * 右树也是平衡的，并且返回其高度
     * 左树和右树的高度，差值小于等于1
     * 递归
     */
    public boolean isBalanceTree(TreeNode root){
        return getBalanceTreeHeight(root) == -1;
    }

    int height = 0;
    /**
     * 如果是平衡的，返回二叉树高度，如果不平衡，返回 -1
     */
    private int getBalanceTreeHeight(TreeNode node){
        if (node == null){
            return 0;
        }

        int leftHeight = getBalanceTreeHeight(node.left);
        int rightHeight = getBalanceTreeHeight(node.right);
        if (leftHeight == -1 || rightHeight == -1){
            return -1;
        }
        height = Math.max(leftHeight, rightHeight) + 1;
        return Math.abs(leftHeight - rightHeight) < 2? height : -1;
    }

    /**
     * 是否是搜索二叉树
     * 任何一棵子树，左 < 根 < 右
     * 要求：
     * 左树是搜索的，且返回其最大值
     * 右树是搜索的，且返回其最小值
     * 且 左树最大值  < 当前节点值 < 右树最大值
     */
    public boolean isSearchTree(TreeNode root){
        if (root == null){
            return false;
        }
        return getIsSearchTreeInfo(root).isBST;
    }

    private SearchReturnInfo getIsSearchTreeInfo(TreeNode node){
        if (node == null){
            return null;
        }
        SearchReturnInfo res = new SearchReturnInfo(true, node.val, node.val);
        SearchReturnInfo leftInfo = getIsSearchTreeInfo(node.left);
        SearchReturnInfo rightInfo = getIsSearchTreeInfo(node.right);

        if (leftInfo != null){
            if (node.val <=  leftInfo.max || !leftInfo.isBST){
                res.isBST = false;
            }
            res.min = Math.min(leftInfo.min, node.val);
            res.max = Math.max(leftInfo.max, node.val);
        }

        if (rightInfo != null){
            if (node.val >=  rightInfo.min || !rightInfo.isBST){
                res.isBST = false;
            }
            res.min = Math.min(rightInfo.min, node.val);
            res.max = Math.max(rightInfo.max, node.val);
        }
        return res;
    }

    /**
     * 辅助判断是否是搜索二叉树的返回值信息
     */
    static class SearchReturnInfo{
        /**
         * 是否是搜索二叉树
         */
        boolean isBST;
        /**
         * 当前子树最大值
         */
        int max;
        /**
         * 当前子树最小值
         */
        int min;

        public SearchReturnInfo(boolean isBST, int max, int min){
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

}
