package com.yishion.algorithm.A.d5;

//ÊÇ·ñÊÇËÑË÷¶þ²æÊ÷
public class Code04_IsBST {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int value) {
			this.value = value;
		}

	}

	public static class ReturnType {
		public boolean isBST;
		public int max;
		public int min;

		public ReturnType(boolean isBST, int max, int min) {
			this.isBST = isBST;
			this.max = max;
			this.min = min;
		}
	}

	private static ReturnType process(Node head) {
		if (head == null) {
			return new ReturnType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		ReturnType leftData = process(head.left);
		ReturnType rightData = process(head.right);
		int max = Math.max(head.value, Math.max(leftData.max, rightData.max));
		int min = Math.min(head.value, Math.min(leftData.min, rightData.min));

		boolean isBst = leftData.isBST && rightData.isBST
				&& (leftData.max < head.value) && (rightData.min > head.value);
		return new ReturnType(isBst, max, min);
	}

	public static boolean isBSTTree(Node head) {
		return process(head).isBST;
	}

	public static void main(String[] args) {
		Node head = new Node(4);
		head.left = new Node(2);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right = new Node(6);
		head.right.left = new Node(5);
		head.right.right = new Node(7);
		System.out.println(isBSTTree(head));

	}

}
