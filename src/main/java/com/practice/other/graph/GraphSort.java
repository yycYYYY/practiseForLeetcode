package com.practice.other.graph;

import com.practice.dataStructure.Graph;

import java.util.*;

/**
 * @Author: yyc
 * @Date: 2022/4/21 6:20 PM
 * @Description: TODO:
 */
public class GraphSort {
    /**
     * 拓扑排序算法
     * 找到入度（in）为0的点a，拿出来，然后删掉所有与a相关的edge，减掉所有与a相关的in（
     * 不需要减其他节点out，因为a入度为0，没有其他点的out与a相关），找下一个in为0的点，重复上述操作，最终获得
     */
    public List<Graph.Node> sortedTopology(Graph graph){
        List<Graph.Node> res = new ArrayList<>(graph.nodes.size());
        /**
         * key为节点
         * value为节点的入度(in)
         */
        Map<Graph.Node, Integer> inMap = new HashMap<>(graph.nodes.size());
        /**
         * 入度为0的点才能进入的队列
         */
        Deque<Graph.Node> inZeroQueue = new ArrayDeque<>();
        for (Graph.Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0){
                inZeroQueue.add(node);
            }
        }

        // 找到入度（in）为0的点a，拿出来，然后删掉所有与a相关的edge，减掉所有与a相关的in
        while (!inZeroQueue.isEmpty()){
            Graph.Node cur = inZeroQueue.poll();
            res.add(cur);
            for (Graph.Node next: cur.nexts) {
                // 注意不要在这里直接该next的in，虽然也可以实现功能，但会破会原有的图结构数据
               inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0){
                    inZeroQueue.add(next);
                }
            }
        }

        return res;
    }


    /**
     * kruskal算法，用以构建最小生成树(保证原有连通性下，去掉冗余的边，确保征留下的边权重最小)
     * 仅适用于无向图
     * 以边出发
     * 按照边的权重遍历，依次向途中添加边，如果添加这条边构成环了，则不添加，如果不构成环，则添加
     *
     * 可以使用并查集，这是一个非常优秀的集合查询，但是难理解，目前先不管
     */
    public Set<Graph.Edge> kruskalMST(Graph graph){
        Set<Graph.Edge> res = new HashSet<>();
        UnionQuerySetEasy<Graph.Node> unionSet = new UnionQuerySetEasy<>(graph.nodes.values());
        // 使用优先队列（最小堆），将边排序,注意需要重写edge的比较器，或者新写一个比较器的类
        PriorityQueue<Graph.Edge> sortEdges = new PriorityQueue<>();
        for (Graph.Edge edge : graph.edges){
            sortEdges.add(edge);
        }
        while (!sortEdges.isEmpty()){
            Graph.Edge edge = sortEdges.poll();
            if (unionSet.isSameSet(edge.from, edge.to)){
                res.add(edge);
            }
        }
        return res;
    }


    /**
     * prim算法
     * 仅适用于无向图
     * 以点出发
     * 从任意一个点a开始，解锁与之相连的边，从中选取权重最小的边，判断这个边的另一个端点b，有没有被使用过，没使用过选择b，作为下次循环的点
     * 如果端点b被使用过，废弃掉这个边，选择下一个权重最小的边，在判断这个端点c有没有被使用过，没被使用过，重复上面的操作
     */
    public Set<Graph.Edge> primMST(Graph graph){
        Set<Graph.Edge> res = new HashSet<>();
        // 使用优先队列（小根堆），将边排序,注意需要重写edge的比较器，或者新写一个比较器的类
        Set<Graph.Node> usedNode = new HashSet<>();
        PriorityQueue<Graph.Edge> sortEdges = new PriorityQueue<>();
        // 这个for循环用以处理森林问题，即这个表图里可能所有点不一定都是连通的，可能是两片图
        // 将所有的点的最小路径都放一遍，所以会出现某些边放了好几次的问题（但是不会真的放，只是判断一下，因为有userNode做限制，会直接跳过）。
        for (Graph.Node node : graph.nodes.values()) {
            if (!usedNode.contains(node)){
                // 将这个点的所有边放到小根堆，表示这个点相连的边都已解锁
                for (Graph.Edge edge : node.edges) {
                    sortEdges.add(edge);
                }

                while (!sortEdges.isEmpty()){
                    Graph.Edge shortestEdge = sortEdges.poll();
                    Graph.Node to = shortestEdge.to;
                    // 如果这个to没有被使用过，作为有效的最短路径添加进来
                    if (!usedNode.contains(to)){
                        res.add(shortestEdge);
                        usedNode.add(to);
                        // 解锁to端点的所有边
                        for (Graph.Edge edge : to.edges) {
                            sortEdges.add(edge);
                        }
                    }
                }

            }
        }
        return res;
    }

    /**
     * dijkstra算法
     * 单元最短路径算法，不适用于这种场景：某一条边权值为负数，导致其相关的某个路径环为负数
     * 规定一个出发点，求解出发点到所有的点的最小权重，不可达的点距离为正无穷或系统最大值
     * 一个点到另外一个点，权重上最小的路径
     */
    public Map<Graph.Node, Integer> dijkstra(Graph.Node head){
        /**
         * 以head为起始点出发到所有点的距离
         * key：终点端点
         * value：从head到key的最小距离
         * 如果在表中没有节点T的记录，表示head到T的距离是正无穷
         */
        Map<Graph.Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        // 已经处理完的节点，这里的节点，之后不会在distanceMap中修改它的最小距离
        Set<Graph.Node> selectedNodes = new HashSet<>();
        Graph.Node minDistanceNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);

        while (minDistanceNode != null){
            int distance = distanceMap.get(minDistanceNode);
            for (Graph.Edge edge : minDistanceNode.edges){
                Graph.Node to = edge.to;
                if (!distanceMap.containsKey(to)){
                    distanceMap.put(to, distance + edge.weight);
                }else {
                    distanceMap.put(to, Math.min(distanceMap.get(to), distance + edge.weight));
                }
            }
            selectedNodes.add(minDistanceNode);
            minDistanceNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public Graph.Node getMinDistanceAndUnselectedNode(Map<Graph.Node, Integer> distanceMap,
                                                      Set<Graph.Node> selectedNodes){
        Graph.Node minDistanceNode = null;
        int minDistance = Integer.MAX_VALUE;

        for (Map.Entry<Graph.Node, Integer> entry: distanceMap.entrySet()){
            if (!selectedNodes.contains(entry.getKey()) && entry.getValue() < minDistance){
                minDistanceNode = entry.getKey();
                minDistance = entry.getValue();
            }
        }
        return minDistanceNode;
    }

    /**
     * 简易的并查集
     * 在当前场景用以判断，多个节点是否有环
     */
    public static class UnionQuerySetEasy<E>{
        public Map<E, List<E>> nodeMap = new HashMap<>();

        public UnionQuerySetEasy(){}

        /**
         * 一开始每个节点，对应的集合，都在自己的集合里，集合里仅有自己一个元素
         * @param nodes 节点集合
         */
        public UnionQuerySetEasy(Collection<E> nodes){
            for (E node : nodes) {
                List<E> nodeList = new ArrayList<>();
                nodeList.add(node);
                nodeMap.put(node, nodeList);
            }
        }

        public boolean isSameSet(E node1, E node2){
            List<E> list1 = nodeMap.get(node1);
            List<E> list2 = nodeMap.get(node2);
            return list1 == list2;
        }

        public void union(E node1, E node2){
            List<E> list1 = nodeMap.get(node1);
            List<E> list2 = nodeMap.get(node2);

            for (E node : list1){
                list2.add(node);
                nodeMap.put(node, list2);
            }
        }
    }
}
