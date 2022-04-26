package com.practice.dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * @Author: yyc
 * @Date: 2022/4/21 4:59 PM
 * @Description:
 * 图的存储方式
 * 邻接表法： 以每个点作为单位，点后列举直接邻居
 * 邻接矩阵法
 * 图的这一块，需要反复的看
 */
public class Graph {

    /**
     * 点集： int 为点的编号， node为实际的点
     */
    public HashMap<Integer, Node> nodes;
    /**
     * 边集： edge为边
     */
    public HashSet<Edge> edges;

    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

    /**
     * 边矩阵转图
     * @param matrix edgeMatrix ,在二维数组中，每一条一维数组都是一条边的描述，矩阵中每一个节点的值都不能重复
     * like [
     *          [from(node), to(node), weight(int)],
     *          [from(node), to(node), weight(int)],
     *          [始点, 终点, 当前边的权值]
     *      ]
     * @return graph
     */
    public static Graph build(int[][] matrix){
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++){
            Integer from = matrix[i][0];
            Integer to = matrix[i][0];
            Integer weight = matrix[i][0];

            if (!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)){
                graph.nodes.put(to, new Node(to));
            }

            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            graph.edges.add(newEdge);

            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            toNode.edges.add(newEdge);
        }
        return graph;
    }


    public static class Node{
        /**
         * 点上的值
         */
        public int value;
        /**
         * 被指向的个数，这个点被3个点指向进入，那这个点就是3
         */
        public int in;
        /**
         * 这个点指向其他点的个数，这个点指向5个点，out就是5
         */
        public int out;
        /**
         * 指向的点的集合
         */
        public ArrayList<Node> nexts;
        /**
         * 相连的边的集合（以当前点为端点的边）
         */
        public ArrayList<Edge> edges;

        public Node(int val){
            this.value = val;
            this.in = 0;
            this.out = 0;
            this.nexts = new ArrayList<>();
            this.edges = new ArrayList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value && in == node.in && out == node.out && Objects.equals(nexts, node.nexts) && Objects.equals(edges, node.edges);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, in, out, nexts, edges);
        }
    }

    public static class Edge{

        /**
         * 边的权重
         */
        public int weight;
        /**
         * 边的始端点
         */
        public Node from;
        /**
         * 边的终端点
         */
        public Node to;

        public Edge(int weight, Node from, Node to){
            this.weight = weight;
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return weight == edge.weight && Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(weight, from, to);
        }
    }
}
