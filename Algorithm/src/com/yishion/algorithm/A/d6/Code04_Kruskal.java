package com.yishion.algorithm.A.d6;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * kruskal算法
 * 
 * 适用范围：要求无向图 解决最小连通图的 求最小权重
 * 
 */

// undirected graph only
public class Code04_Kruskal {

	public static class MySets {

		public HashMap<Node, Set<Node>> nodesFindSet;

		public MySets(Collection<Node> list) {
			nodesFindSet = new HashMap<Node, Set<Node>>();
			for (Node node : list) {
				HashSet<Node> set = new HashSet<>();
				set.add(node);
				nodesFindSet.put(node, set);
			}
		}

		public boolean isSameSet(Node a, Node b) {
			return nodesFindSet.get(a) == nodesFindSet.get(b);
		}

		public void mergeSet(Node a, Node b) {
			Set<Node> aSet = nodesFindSet.get(a);
			Set<Node> bSet = nodesFindSet.get(b);

			for (Node node : bSet) {
				aSet.add(node);
				nodesFindSet.put(node, aSet);
			}

		}

	}

	public static Set<Edge> kruskalMST(Graph graph) {
		MySets mySets = new MySets(graph.nodes.values());

		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(
				new EdgeCompartor());

		priorityQueue.addAll(graph.edges);

		Set<Edge> set = new HashSet<>();
		while (!priorityQueue.isEmpty()) {

			Edge edge = priorityQueue.poll();

			if (!mySets.isSameSet(edge.fromNode, edge.toNode)) {
				set.add(edge);
				mySets.mergeSet(edge.fromNode, edge.toNode);
			}

		}

		return set;
	}

	public static class EdgeCompartor implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}

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

		Set<Edge> set = kruskalMST(graph);
		for (Edge edge : set) {
			System.out.println(edge.weight + " ");
		}

	}

}
