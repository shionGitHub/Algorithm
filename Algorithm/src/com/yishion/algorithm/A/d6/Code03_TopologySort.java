package com.yishion.algorithm.A.d6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ���������㷨 ���÷�Χ��
 * 
 * 
 * Ҫ������ͼ���������Ϊ0�Ľڵ㣬��û�л�
 * 
 */
public class Code03_TopologySort {

	// directed graph and no loop
	public static List<Node> sortedTopology(Graph graph) {

		HashMap<Node, Integer> inMap = new HashMap<>();// ��¼���
		Queue<Node> zeroSet = new LinkedList<>();// �洢���==0�ĵ�

		for (Node node : graph.nodes.values()) {// �����ڵ�
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
