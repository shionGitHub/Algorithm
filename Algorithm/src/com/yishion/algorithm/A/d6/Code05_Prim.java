package com.yishion.algorithm.A.d6;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * prim算法
 * 
 * 
 * 适用范围：要求无向图 解决最小连通图的 求最小权重
 * 
 * @author Administrator
 * 
 */
// undirected graph only
public class Code05_Prim {

	public static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}

	}

	public static Set<Edge> primMST(Graph graph) {

		Set<Edge> edgeSet = new HashSet<>();
		Set<Node> set = new HashSet<>();

		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(
				new EdgeComparator());
		for (Node node : graph.nodes.values()) {
			if (!set.contains(node)) {
				set.add(node);
				priorityQueue.addAll(node.edges);// 解锁这个点连接的所有的边
				while (!priorityQueue.isEmpty()) {
					Edge edge = priorityQueue.poll();
					Node toNode = edge.toNode;
					if (!set.contains(toNode)) {
						set.add(toNode);
						edgeSet.add(edge);
						priorityQueue.addAll(toNode.edges);// 解锁这个点连接的所有的边
					}
				}
			}
		}
		return edgeSet;
	}

	public static void main(String[] args) {
		int[][] intArr =

		{

		{ 1, 2, 3 }, { 1, 3, 2 },

		{ 3, 1, 2 }, { 3, 2, 1 },

		{ 5, 1, 3 }, { 5, 3, 1 },

		{ 12, 1, 4 }, { 12, 4, 1 },

		{ 16, 4, 3 }, { 16, 3, 4 }

		};

		Graph graph = GraphGenerator.createGraph(intArr);

		Set<Edge> set = primMST(graph);

		for (Edge edge : set) {
			System.out.println(edge.weight + " ");
		}

	}

}
