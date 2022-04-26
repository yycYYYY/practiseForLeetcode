package com.practice.other.tree;

import com.practice.dataStructure.TreeNode;

import java.util.*;

/**
 * @Author: yyc
 * @Date: 2022/4/19 8:12 PM
 * @Description: TODO:
 */
public class GetTreeWidth {
    /**
     * 获取二叉树最大宽度
     * 额外空间复杂度是N
     */
    public int solution(TreeNode root){
        if (root == null){
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();

        TreeNode head = root;
        queue.add(head);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = -1;
        Map<TreeNode, Integer> nodeLevels = new HashMap<>();
        nodeLevels.put(root, 1);

        while (!queue.isEmpty()){
            head = queue.poll();
            if (nodeLevels.getOrDefault(head, 0) == curLevel){
                curLevelNodes++;
            }else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }

            if (head.left != null){
                queue.add(head.left);
                nodeLevels.put(head.left, curLevel + 1);
            }

            if (head.right != null){
                queue.add(head.right);
                nodeLevels.put(head.right, curLevel + 1);
            }
        }
        return max;
    }

    /**
     * 额外空间复杂度为1的解法
     */
    public int solution2(TreeNode root){
        if (root == null){
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();

        TreeNode head = root;
        queue.add(head);
        TreeNode curLevelLastNode = head;
        TreeNode nextLevelLastNode = null;
        int curLevelNodesCount = 0;
        int max = 0;

        while (!queue.isEmpty()){
            head = queue.poll();

            if (head.left != null){
                queue.add(head.left);
                nextLevelLastNode = head.left;
            }

            if (head.right != null){
                queue.add(head.right);
                nextLevelLastNode = head.right;
            }

            if (head == curLevelLastNode){
                max = Math.max(max, ++curLevelNodesCount);
                curLevelNodesCount = 0;
                curLevelLastNode = nextLevelLastNode;
            }else {
                curLevelNodesCount++;
            }

        }
        return max;
    }

    /**
     * 在lc答案区，发现一个最优写法，优雅，易懂
     */
    public List<List<Integer>> solution3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }

        return res;
    }

}
