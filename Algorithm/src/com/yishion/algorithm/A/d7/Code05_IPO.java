package com.yishion.algorithm.A.d7;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code05_IPO {

	public static class Node {
		public int p;
		public int c;

		public Node(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}

	public static class MinCostComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o1.c - o2.c;
		}

	}

	public static class MaxProfitComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o2.p - o1.p;
		}

	}

	public static int findMaximizedCapital(int k, int W, int[] Profits,
			int[] Capital) {
		Node[] nodes = new Node[Profits.length];
		for (int i = 0; i < Profits.length; i++) {
			nodes[i] = new Node(Profits[i], Capital[i]);
		}

		PriorityQueue<Node> costPriorityQueue = new PriorityQueue<>(
				new MinCostComparator());
		PriorityQueue<Node> profitsPriorityQueue = new PriorityQueue<>(
				new MaxProfitComparator());
		for (int i = 0; i < nodes.length; i++) {
			costPriorityQueue.add(nodes[i]);
		}

		for (int i = 0; i < k; i++) {

			while (costPriorityQueue != null && costPriorityQueue.peek().c <= W) {
				profitsPriorityQueue.add(costPriorityQueue.poll());
			}

			while (!profitsPriorityQueue.isEmpty()) {
				W += profitsPriorityQueue.poll().p;
			}

		}

		return W;
	}

	public static void main(String[] args) {

	}

}
