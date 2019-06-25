package com.yishion.algorithm.A.d6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 拓扑排序算法 适用范围：
 * 
 * 
 * 要求有向图，且有入度为0的节点，且没有环
 * 
 */
public class Code03_TopologySort {

	// directed graph and no loop
	public static List<Node> sortedTopology(Graph graph) {

		HashMap<Node, Integer> inMap = new HashMap<>();// 记录入度
		Queue<Node> zeroSet = new LinkedList<>();// 存储入度==0的点

		for (Node node : graph.nodes.values()) {// 遍历节点
			inMap.put(node, node.in);
			if (node.in == 0) {
				zeroSet.add(node);
			}
		}

		List<Node> result = new ArrayList<Node>();

		while (!zeroSet.isEmpty()) {
			Node node = zeroSet.poll();
			result.add(node);
			
			for (Node n : node.nexts) {
				inMap.put(n, --n.in);
				if (inMap.get(n) == 0) {
					zeroSet.add(n);
				}
			}

		}

		return result;
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

		List<Node> list = sortedTopology(graph);

		for (Node node : list) {
			System.out.print(node.value + " ");
		}
		System.out.println();

	}
}
