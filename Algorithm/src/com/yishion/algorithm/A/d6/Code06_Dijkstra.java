package com.yishion.algorithm.A.d6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

/**
 * ��һ���ڵ㵽��һ���ڵ����̾���
 * 
 * @author Administrator
 * 
 */
// no negative weight
public class Code06_Dijkstra {

	public static HashMap<Node, Integer> dijkstra1(Node head) {
		// head�ڵ㵽����ڵ�ľ���
		HashMap<Node, Integer> distanceMap = new HashMap<>();
		distanceMap.put(head, 0);
		HashSet<Node> selectSet = new HashSet<>();
		Set<Node> set = new HashSet<>();
		set.add(head);

		while (head != null) {
			selectSet.add(head);// ��Ӿ�����С�Ľڵ�
			int distance = distanceMap.get(head);// ���������̾���

			// ���������С��������ӵ������ܱߵĵ�
			for (Edge edge : head.edges) {
				if (!set.contains(edge.toNode)) {
					set.add(edge.toNode);
					distanceMap.put(edge.toNode, edge.weight);
				}

				int s = Math.min(distanceMap.get(edge.toNode),
						(distance + edge.weight));
				distanceMap.put(edge.toNode, s);
			}

			head = getMinDistanceAndUnselectedNode(distanceMap, selectSet);

		}

		return distanceMap;
	}

	// �ҳ�����ڵ������� ------>��һ���ڵ�(��С��) && ����û��ѡ�й���
	public static Node getMinDistanceAndUnselectedNode(
			HashMap<Node, Integer> minDistanceMap, Set<Node> selectSet) {
		int minDistance = Integer.MAX_VALUE;
		Node minNode = null;
		for (Entry<Node, Integer> entry : minDistanceMap.entrySet()) {
			Node node = entry.getKey();
			int distance = entry.getValue();
			if (!selectSet.contains(node) && (distance < minDistance)) {
				minNode = node;
				minDistance = distance;
			}
		}
		return minNode;
	}

	public static void main(String[] args) {
		int[][] intArr =

		{

		{ 16, 1, 4 }, { 16, 4, 1 },

		{ 12, 1, 3 }, { 12, 3, 1 },

		{ 7, 1, 2 }, { 7, 2, 1 },

		{ 2, 2, 3 }, { 2, 3, 2 },

		{ 5, 4, 3 }, { 5, 3, 4 },

		{ 7, 4, 5 }, { 7, 5, 4 },

		{ 100, 2, 5 }, { 100, 5, 2 },

		};

		Graph graph = GraphGenerator.createGraph(intArr);

		HashMap<Node, Integer> map = dijkstra1(graph.nodes.get(1));

		for (Entry<Node, Integer> entry : map.entrySet()) {
			System.out.println("�ڵ㣺 " + entry.getKey().value + "--------���룺 "
					+ entry.getValue());
		}

	}

}
