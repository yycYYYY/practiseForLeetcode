package com.practice.P1_100.P91_100;

import com.practice.dataStructure.ListNode;
import com.practice.dataStructure.TreeNode;

import java.util.*;

/**
 * N0.94 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * 前中后序，指的是头结点的处理顺序：
 * 前： 头左右
 * 中： 左头右
 * 后： 左右头
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
public class TreeTraversal {
    public List<Integer> solution(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        inOrderTraverse(root, res);
        return res;
    }

    /**
     * 中序遍历
     * 顺序： 左 右 头
     * */
    public void inOrderTraverse(TreeNode node, List<Integer> res){
        if (node != null){
            inOrderTraverse(node.left, res);
            res.add(node.val);
            inOrderTraverse(node.right, res);
        }
    }

    /**
     * 前序遍历
     *
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
     * 头 左 右
     * */
    public void postOrderTraverse(TreeNode node, List<Integer> res){
        if (node != null){
            postOrderTraverse(node.left, res);
            postOrderTraverse(node.right, res);
            res.add(node.val);
        }
    }

    /**
     * 非递归的前序遍历: 头左右
     * 1、栈中弹出一个当前node
     * 2、打印或处理当前nbode
     * 3、压入子节点，先右后左，如果有的话
     * 4、循环
     * */
    public Deque<TreeNode> preOrderTraverse1(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();

        if (root == null){
            return stack;
        }
        TreeNode head = root;
        stack.add(head);
        while (!stack.isEmpty()){
            head = stack.pop();
            System.out.println(head.val);
            if (head.right != null){
                stack.add(head.right);
            }
            if (head.left != null){
                stack.add(head.left);
            }
        }
        return stack;
    }

    /**
     * 非递归的中序遍历：左头右
     * 每颗子树左节点进栈
     * 1、整棵树左边界节点入栈
     * 2、依次弹出，打印，以当前弹出节点的右节点为顶点的子树重复每颗子树左节点进栈
     * 3、重复
     */
    public Deque<TreeNode> inOrderTraverse1(TreeNode root){
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
                System.out.println(temp.val);
                pre = temp.right;
            }
        }
        return res;
    }


    /**
     * 非递归的后序遍历：左右头
     * 非递归的后序稍微有些特殊，不太好做
     * 可以正常的遍历压栈不太好做，所以借鉴前序的方法，前序先压右侧后压左侧，得到头左右
     * 我们可以按谦虚的实现方式，先压左侧后压右侧，得到头右左，再将头右左逆序输出，得到左右头
     */
    public Deque<TreeNode> postOrderTraverse1(TreeNode root){
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();

        if (root == null){
            return stack1;
        }
        TreeNode head = root;
        stack1.add(head);
        while (!stack1.isEmpty()){
            head = stack1.pop();
            stack2.push(head);
            System.out.println(head.val);
            if (head.left != null){
                stack1.add(head.left);
            }
            if (head.right != null){
                stack1.add(head.right);
            }
        }
        while (!stack2.isEmpty()){
            System.out.println(stack1.pop().val);
        }
        return stack2;
    }

    /**
     * 深度优先遍历
     * 二叉树的深度优先遍历，就是先序遍历
     * 使用栈
     */
    public void dfs(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();

        if (root == null){
            return;
        }
        TreeNode head = root;
        stack.add(head);
        while (!stack.isEmpty()){
            head = stack.pop();
            System.out.println(head.val);
            if (head.right != null){
                stack.add(head.right);
            }
            if (head.left != null){
                stack.add(head.left);
            }
        }
        return;
    }

    /**
     * 广度优先遍历（层级遍历）
     * 使用队列
     */
    public void bfs(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<>();

        if (root == null){
            return;
        }
        TreeNode head = root;
        queue.addFirst(head);
        while (!queue.isEmpty()){
            head = queue.pollFirst();
            System.out.println(head.val);
            if (head.right != null){
                queue.addFirst(head.right);
            }
            if (head.left != null){
                queue.addFirst(head.left);
            }
        }
        return;
    }
}
