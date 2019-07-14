package com.yishion.algorithm.A.d6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 从一个节点到另一个节点的最短距离
 * 
 * @author Administrator
 * 
 */
// no negative weight
public class Code06_Dijkstra {

	public static HashMap<Node, Integer> dijkstra1(Node head) {
		// head节点到这个节点的距离
		HashMap<Node, Integer> distanceMap = new HashMap<>();
		distanceMap.put(head, 0);
		HashSet<Node> selectSet = new HashSet<>();
		Set<Node> set = new HashSet<>();
		set.add(head);

		while (head != null) {
			selectSet.add(head);// 添加距离最小的节点
			int distance = distanceMap.get(head);// 到这个点最短距离

			// 解锁这个最小距离点连接的所有周边的点
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

	// 找出这个节点相连的 ------>下一个节点(最小的) && 从来没有选中过的
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
			System.out.println("节点： " + entry.getKey().value + "--------距离： "
					+ entry.getValue());
		}

		NodeHeap nodeHeap = new NodeHeap(graph.nodes.size());

		Node head = graph.nodes.get(1);

		nodeHeap.addOrupdateOrIgnore(head, 0);

		Map<Node, Integer> result = new HashMap<>();

		while (!nodeHeap.isEmpty()) {
			RecordItem item = nodeHeap.pop();
			Node node = item.node;
			int distance = item.distance;
			result.put(node, distance);
			for (int i = 0; i < node.edges.size(); i++) {
				Edge edge = node.edges.get(i);
				nodeHeap.addOrupdateOrIgnore(edge.toNode, edge.weight
						+ item.distance);
			}
		}

		for (Entry<Node, Integer> entry : result.entrySet()) {
			System.out.println("节点： " + entry.getKey().value + "--------距离： "
					+ entry.getValue());
		}

	}

	public static class RecordItem {
		public Node node;
		public int distance;

	}

	public static class NodeHeap {
		private Node[] nodes;
		public Map<Node, Integer> nodeIndexMap;
		public Map<Node, Integer> distanceMap;
		public int size;

		public NodeHeap(int size) {
			nodes = new Node[size];
			nodeIndexMap = new HashMap<>();
			distanceMap = new HashMap<>();
			this.size = 0;
		}

		public boolean isEmpty() {
			return this.size == 0;
		}

		public void addOrupdateOrIgnore(Node node, int distance) {

			if (!isEnter(node)) {
				nodeIndexMap.put(node, size);
				distanceMap.put(node, distance);
				nodes[size++] = node;
				heapInsert(size - 1);
				return;
			}

			if (inHeap(node)) {
				int dis = distanceMap.get(node);
				if (dis > distance) {
					distanceMap.put(node, distance);
					int index = nodeIndexMap.get(node);
					heapify(index, size);
				}

			}

		}

		public RecordItem pop() {
			RecordItem item = new RecordItem();
			item.node = nodes[0];
			item.distance = distanceMap.get(nodes[0]);
			distanceMap.remove(nodes[0]);
			swap(0, size - 1);
			nodeIndexMap.put(nodes[size - 1], -1);
			nodes[size - 1] = null;
			heapify(0, --size);
			return item;
		}

		private boolean isEnter(Node node) {
			return nodeIndexMap.containsKey(node);
		}

		public boolean inHeap(Node node) {
			return isEnter(node) && nodeIndexMap.get(node) != -1;
		}

		public void heapInsert(int index) {
			while (distanceMap.get(nodes[index]) < distanceMap
					.get(nodes[(index - 1) / 2])) {
				swap(index, (index - 1) / 2);
				index = (index - 1) / 2;
			}

		}

		public void heapify(int index, int size) {
			int left = 2 * index + 1;

			while (left < size) {
				int smallest;
				int right = left + 1;

				if (right >= size) {
					smallest = left;
				} else {
					if (distanceMap.get(nodes[left]) < distanceMap
							.get(nodes[right])) {
						smallest = left;
					} else {
						smallest = right;
					}
				}

				if (distanceMap.get(nodes[index]) < distanceMap
						.get(nodes[smallest])) {
					break;
				}
				swap(index, smallest);
				index = smallest;
				left = 2 * index + 1;
			}

		}

		private void swap(int i, int j) {
			nodeIndexMap.put(nodes[i], j);
			nodeIndexMap.put(nodes[j], i);
			Node tempNode = nodes[i];
			nodes[i] = nodes[j];
			nodes[j] = tempNode;
		}

	}

}
