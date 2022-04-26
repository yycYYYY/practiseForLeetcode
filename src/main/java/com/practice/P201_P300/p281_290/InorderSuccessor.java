package com.practice.P201_P300.p281_290;

import com.practice.dataStructure.TreeNode;

/**
 * @Author: yyc
 * @Date: 2022/4/20 9:37 PM
 * @Description: lc 285 mid 二叉树的中序后继节点
 */
public class InorderSuccessor {

    /**
     * 中序遍历的后继节点，可以整理优化为另种情况
     * TODO
     * 1、当前节点x, 有右树，后继节点是右树中的最左节点
     * 2、当前节点x，没有右树，后继节点是它的向上逐级，父级a不是更上一层的父级节点b的右子节点时，更上一级的父级节点b就是后继节点
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return null;
    }
}
