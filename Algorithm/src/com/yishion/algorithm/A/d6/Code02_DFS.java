package com.yishion.algorithm.A.d6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Stack;

public class Code02_DFS {

	public static void dfs(Node node) {
		if (node == null) {
			return;
		}

		Stack<Node> stack = new Stack<>();
		Set<Node> set = new HashSet<>();
		stack.push(node);
		set.add(node);
		System.out.print(node.value + " ");

		while (!stack.isEmpty()) {
			Node cur = stack.pop();

			List<Node> list = cur.nexts;

			for (Node n : list) {
				if (!set.contains(n)) {// Ã»ÓÐ×¢²á¹ý
					stack.push(cur);
					stack.push(n);
					set.add(n);
					System.out.print(n.value + " ");
					break;
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
			dfs(valueNode);
		}

	}

}
