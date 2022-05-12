package com.practice.p101_200.p101_110;

import com.practice.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yyc
 * @Date: 2022/5/10 5:44 下午
 * @Description: lc mid 105 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 示例 1:
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 *
 * 示例 2:
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 *
 * 提示:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder和inorder均 无重复 元素
 * inorder均出现在preorder
 * preorder保证 为二叉树的前序遍历序列
 * inorder保证 为二叉树的中序遍历序列
 */
public class BuildTree {

    Map<Integer, Integer> posInInorder = new HashMap<>();

    /**
     * 例如满二叉树
     *              1
     *            2   3
     *           4 5 6 7
     *
     * 前序遍历pre【中右左】：1 2 4 5 3 6 7 --->其中隐含信息pre[0] 根节点，pre[1]第一个左子树的根节点,pre[len - 1]
     * 中序遍历in【左中右】：4 2 5 1 6 3 7 --->若已知1（in[3]）是根节点，左侧所有数是左树节点，且左树最后一个节点（最右子节点）是in[3-1]，
     * 右侧是右树节点，且右树根节点是in[3 + 1]，右树的最后一个节点（最右子节点）是in[len - 1]
     * 由此，我们可以递归构造二叉树
     * 1     245       367   :
     * root-pos    leftInStart（inStart + 1）   leftInEnd(inStart + rightNodeCounts)  rightPreStart(inENd - rightNodeCounts + 1)    rightPreEnd(inEnd)
     *
     * 425    1    637    :
     * leftPreStart(preStart)    leftPreEnd(root-pos - 1)     root-pos（遍历查找或者map查找）     rightPreStart(root-pos + 1)    rightPreEnd(preEnd)
     *
     */
    public TreeNode solution1(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            posInInorder.put(inorder[i], i);
        }
        return recursion(preorder, inorder, 0, inorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * 不新建数组，利用preorder和inorder的索引位置，来构造当前的根节点
     * @param preorder
     * @param inorder
     * @param inStart
     * @param inEnd
     * @param preStart
     * @param preEnd
     * @return
     */
    private TreeNode recursion(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart, int preEnd){
        if (inStart == inEnd){
            return new TreeNode(inorder[inStart]);
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootInIndex = posInInorder.get(rootVal);

        // 当中序遍历和中序遍历的第一个值相同时，证明没有左树节点;反之，有左子树
        if (inorder[inStart] != preorder[preStart]){
            // 左树节点数
            int leftNodeCounts = rootInIndex - inStart;
            // leftInStart
            // leftInEnd
            // leftPreStart
            // leftPreEnd
            root.left = recursion(preorder, inorder,
                    inStart, rootInIndex - 1,
                    preStart + 1, preStart + leftNodeCounts);
        }

        // 当中序遍历中，最后一位是根节点时，证明没有右树节点；反之，有右子树
        if (rootInIndex != inEnd){
            // 右树节点数
            int rightNodeCounts = inEnd - rootInIndex;
            // rightInStart
            // rightInEnd
            // rightPreStart
            // rightPreEnd
            root.right = recursion(preorder, inorder,
                    rootInIndex + 1, inEnd,
                    preEnd - rightNodeCounts + 1, preEnd);
        }

        return root;
    }

    public static void main(String[] args) {
        BuildTree b = new BuildTree();
        int[] in = new int[]{3,2,1,4,5};
        int[] pre = new int[]{1,2,3,4,5};
        TreeNode root = b.solution1(pre, in);
        System.out.println(root);
    }
}
