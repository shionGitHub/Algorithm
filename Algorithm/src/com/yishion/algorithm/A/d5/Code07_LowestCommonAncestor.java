package com.yishion.algorithm.A.d5;

public class Code07_LowestCommonAncestor {

	public static class Node {

		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}

	}

	public static Node lowestAncestor(Node head, Node o1, Node o2) {
		if (head == null || head == o1 || head == o2) {
			return head;
		}

		Node leftNode = lowestAncestor(head.left, o1, o2);
		Node rightNode = lowestAncestor(head.right, o1, o2);
		if (leftNode != null && rightNode != null) {
			return head;
		}
		return leftNode != null ? leftNode : rightNode;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		head.right.right.left = new Node(8);

		System.out.println("===============");

		Node o1 = head.left.right;
		Node o2 = head.right.left;

		System.out.println("o1 : " + o1.value);
		System.out.println("o2 : " + o2.value);
		System.out.println("ancestor : " + lowestAncestor(head, o1, o2).value);
		System.out.println("===============");
	}

}
