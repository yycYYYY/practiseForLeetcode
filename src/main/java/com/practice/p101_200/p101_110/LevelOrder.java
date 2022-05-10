package com.practice.p101_200.p101_110;

import com.practice.dataStructure.TreeNode;

import java.util.*;

/**
 * @Author: yyc
 * @Date: 2022/4/19 9:28 PM
 * @Description: lc 102 mid LevelOrder 二叉树层序遍历
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 *
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */
public class LevelOrder {

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


    public List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        TreeNode head;
        int curLevel = 1;

        Map<TreeNode, Integer> nodeLevels = new HashMap<>();
        nodeLevels.put(root, 1);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> levelValues = new ArrayList<>(1);

        while (!queue.isEmpty()){
            head = queue.poll();
            if (nodeLevels.get(head) == curLevel){
                levelValues.add(head.val);
            }else {
                curLevel++;
                res.add(levelValues);
                levelValues = new ArrayList<>();
                levelValues.add(head.val);
            }

            if (head.left != null){
                nodeLevels.put(head.left, curLevel + 1);
                queue.add(head.left);
            }

            if (head.right != null){
                nodeLevels.put(head.right, curLevel + 1);
                queue.add(head.right);
            }
        }
        res.add(levelValues);
        return res;
    }

    public List<List<Integer>> solution2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode head;
        TreeNode curLevelLastNode = root;
        TreeNode nextLevelLastNode = null;

        List<Integer> levelValues = new ArrayList<>();

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
                levelValues.add(head.val);
                res.add(levelValues);
                levelValues = new ArrayList<>();
                curLevelLastNode = nextLevelLastNode;
            }else {
                levelValues.add(head.val);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        List<List<Integer>> res = levelOrder.solution2(node1);
        System.out.println(res);
    }
}
