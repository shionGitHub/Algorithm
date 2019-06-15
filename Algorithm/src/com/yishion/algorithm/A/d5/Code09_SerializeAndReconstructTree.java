package com.yishion.algorithm.A.d5;

import java.util.LinkedList;
import java.util.Queue;

//二叉树序列化和反序列化
public class Code09_SerializeAndReconstructTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}

	}

	// 二叉树前序序列化
	public static String serialByPre(Node head) {
		if (head == null) {
			return "#_";
		}
		String res = head.value + "_";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}

	// 二叉树前序反序列化
	public static Node reconByPreString(String preStr) {
		if (preStr == null) {
			return null;
		}
		String[] arr = preStr.split("_");
		LinkedList<String> txts = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			txts.add(arr[i]);
		}
		return reconPreOrder(txts);
	}

	public static Node reconPreOrder(Queue<String> queue) {
		String txt = queue.poll();
		if (txt.equals("#")) {
			return null;
		}

		Node head = new Node(Integer.parseInt(txt));
		head.left = reconPreOrder(queue);
		head.right = reconPreOrder(queue);
		return head;

	}

	// 二叉树按层序列化
	public static String serialByLevel(Node head) {
		if (head == null) {
			return "#_";
		}

		LinkedList<Node> nodes = new LinkedList<>();
		nodes.push(head);
		String str = head.value + "_";
		while (!nodes.isEmpty()) {
			Node n = nodes.pop();
			if (n.left != null) {
				nodes.add(n.left);
				str += n.left.value + "_";
			} else {
				str += "#_";
			}
			if (n.right != null) {
				nodes.add(n.right);
				str += n.right.value + "_";
			} else {
				str += "#_";
			}
		}

		return str;
	}

	// 二叉树按层反序列化
	public static Node reconByLevelString(String levelStr) {

		String[] arr = levelStr.split("_");
		int index = 0;
		Node head = generateNodeByString(arr[index++]);
		Queue<Node> queue = new LinkedList<>();
		if (head != null) {
			queue.add(head);
		}

		Node node = null;
		while (!queue.isEmpty()) {
			node = queue.poll();
			node.left = generateNodeByString(arr[index++]);
			node.right = generateNodeByString(arr[index++]);

			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}

		}

		return head;
	}

	public static Node generateNodeByString(String val) {
		if (val.equals("#")) {
			return null;
		}
		return new Node(Integer.valueOf(val));
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.left = new Node(5);
		head.right.right = new Node(6);
		head.left.left.right = new Node(7);

		// System.out.println(serialByPre(head));
		// printTree(reconByPreString(serialByPre(head)));
		System.out.println(serialByLevel(head));
		printTree(reconByLevelString(serialByLevel(head)));

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

}
