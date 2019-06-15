package com.yishion.algorithm.A.d5;

//是否是搜索二叉树----------------->某一颗子树是不是搜索二叉树
public class Code04_IsBST {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int value) {
			this.value = value;
		}

	}

	private static class RT {
		public boolean isBst;
		public int max;
		public int min;

		public RT(boolean isBst, int max, int min) {
			this.isBst = isBst;
			this.max = max;
			this.min = min;
		}

	}

	public static RT isBST(Node head) {
		if (head == null) {
			return new RT(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		RT leftData = isBST(head.left);
		RT rightData = isBST(head.right);

		boolean isBst = leftData.isBst && rightData.isBst
				&& (leftData.max < head.value) && (rightData.min > head.value);
		int max = Math.max(Math.max(rightData.max, leftData.max), head.value);
		int min = Math.min(Math.min(rightData.min, leftData.min), head.value);

		return new RT(isBst, max, min);
	}

	public static void main(String[] args) {
		Node head = new Node(100);

		head.left = new Node(2);
		head.right = new Node(6);

		head.left.left = new Node(1);
		head.left.right = new Node(3);

		head.right.left = new Node(5);
		head.right.right = new Node(7);

		System.out.println(isBST(head).isBst);

	}

}
