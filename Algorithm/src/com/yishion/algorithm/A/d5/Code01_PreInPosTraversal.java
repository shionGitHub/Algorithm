package com.yishion.algorithm.A.d5;

import java.util.Stack;

public class Code01_PreInPosTraversal {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	// 前序遍历
	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	// 中序遍历
	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}

	// 后序遍历
	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value + " ");
	}

	// 前序遍历非递归
	public static void preOrderUnRecur(Node head) {
		if (head == null) {
			return;
		}

		Stack<Node> stack = new Stack<>();
		stack.push(head);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.print(node.value + " ");
			if (node.right != null) {
				stack.push(node.right);
			}

			if (node.left != null) {
				stack.push(node.left);
			}

		}

	}

	// 中序遍历非递归
	public static void inOrderUnRecur(Node head) {

		if (head != null) {
			Stack<Node> stacks = new Stack<>();
			while (!stacks.isEmpty() || head != null) {
				if (head != null) {
					stacks.push(head);
					head = head.left;
				} else {
					head = stacks.pop();
					System.out.print(head.value + " ");
					head = head.right;
				}
			}

		}

	}

	// 后序遍历非递归
	public static void posOrderUnRecur(Node head) {
		if (head == null) {
			return;
		}

		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack = new Stack<>();
		stack.push(head);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			stack1.add(node);
			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
		}
		while (!stack1.isEmpty()) {
			System.out.print(stack1.pop().value + " ");
		}

	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		preOrderRecur(head);
		System.out.println();
		inOrderRecur(head);
		System.out.println();
		posOrderRecur(head);
		System.out.println();
		System.out.println("||");
		preOrderUnRecur(head);
		System.out.println();
		inOrderUnRecur(head);
		System.out.println();
		posOrderUnRecur(head);
	}

}
