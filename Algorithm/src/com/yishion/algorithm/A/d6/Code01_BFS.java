package com.yishion.algorithm.A.d6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class Code01_BFS {

	public static void bfs(Node node) {
		if (node == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		HashSet<Node> set = new HashSet<>();
		queue.add(node);
		set.add(node);

		while (!queue.isEmpty()) {
			Node n = queue.poll();
			System.out.print(n.value + " ");
			for (Node nn : n.nexts) {// 邻接的节点
				if (!set.contains(nn)) {
					set.add(nn);
					queue.add(nn);
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] intArr =

		{

		{ 0, 1, 2 },

		{ 0, 1, 3 },

		{ 0, 1, 6 },

		{ 0, 2, 4 },

		{ 0, 3, 4 },

		{ 0, 4, 5 },

		{ 0, 6, 5 }

		};

		Graph graph = GraphGenerator.createGraph(intArr);

		Set<Entry<Integer, Node>> entrySet = graph.nodes.entrySet();

		for (Iterator<Entry<Integer, Node>> iterator = entrySet.iterator(); iterator
				.hasNext();) {
			Entry<Integer, Node> entry = (Entry<Integer, Node>) iterator.next();
			Node valueNode = entry.getValue();
			bfs(valueNode);
		}
	}

}
