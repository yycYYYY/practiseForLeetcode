package com.practice.other.graph;

import com.practice.dataStructure.Graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yyc
 * @Date: 2022/4/21 5:52 PM
 * @Description: 图的遍历
 * 图像对于二叉树可能是有环的，所以相对于二叉树，仅是多了一个是否进过栈/队列的记录，避免在环中陷入死循环
 */
public class GraphTraversal {

    /**
     * 宽度优先
     * 使用队列
     * 1、从源节点开始依次按照宽度进入队列，然后弹出
     * 2、每弹出一个点，把所有没进过队列的邻接节点放入队列
     * 3、直到队列为空
     */
    public void bfs(Graph.Node node){
        if (node == null){
            return;
        }
        Deque<Graph.Node> queue = new ArrayDeque<>();
        Set<Graph.Node> hasAccessedQueue = new HashSet<>();
        queue.add(node);
        hasAccessedQueue.add(node);

        while (!queue.isEmpty()){
            Graph.Node cur = queue.poll();
            // 处理节点
            System.out.println(cur.value);
            for (Graph.Node next : cur.nexts){
                if (!hasAccessedQueue.contains(next)){
                    queue.add(next);
                    hasAccessedQueue.add(next);
                }
            }
        }
    }

    /**
     * 深度优先
     * 使用栈
     * 1、从源节点开始依次按照节点的深度，压入栈，然后弹出
     * 2、每弹出一个节点，压入该节点下一个没有进过栈的邻接点
     * 3、直到栈变空
     */
    public void dfs(Graph.Node node){
        if (node == null){
            return;
        }
        Deque<Graph.Node> stack = new ArrayDeque<>();
        Set<Graph.Node> hasAccessedStack = new HashSet<>();
        stack.add(node);
        hasAccessedStack.add(node);
        // 处理节点,注意和广度不同，深度是往里压的时候，处理节点
        System.out.println(node.value);
        while (!stack.isEmpty()){
            Graph.Node cur = stack.pop();

            for (Graph.Node next : cur.nexts){
                if (!hasAccessedStack.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    hasAccessedStack.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
