package com.yishion.algorithm.A.d5;

//打印二叉树
public class Code02_PrintBinaryTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static void printTree(Node node) {
		System.out.println("Binary Tree:");
		printInOrder(node, 0, "H", 17);
		System.out.println();

	}

	private static void printInOrder(Node node, int hight, String flag, int len) {
		if (node == null) {
			return;
		}
		printInOrder(node.right, hight + 1, "↓", len);

		// 文本内容
		String v = flag + node.value + flag;

		int lenL = (len - v.length()) / 2;
		int lenR = len - lenL - v.length();
		// Node的到左边的距离
		String space = getSpace(hight * len);
		String vv = space + getSpace(lenL) + v + getSpace(lenR);
		System.out.println(vv);

		printInOrder(node.left, hight + 1, "↑", len);

	}

	private static String getSpace(int n) {
		String space = "";
		for (int i = 0; i < n; i++) {
			space += " ";
		}
		return space;
	}

	public static void main(String[] args) {
		// Node head = new Node(1);
		// head.left = new Node(2);
		// head.right = new Node(3);
		// head.left.left = new Node(4);
		// head.right.left = new Node(5);
		// head.right.right = new Node(6);
		// head.left.left.right = new Node(7);
		//
		// printTree(head);

		Node head = new Node(1);
		head.left = new Node(-222222222);
		head.right = new Node(3);
		head.left.left = new Node(Integer.MIN_VALUE);
		head.right.left = new Node(55555555);
		head.right.right = new Node(66);
		head.left.left.right = new Node(777);
		printTree(head);

	}

}
