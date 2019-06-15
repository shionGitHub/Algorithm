package com.yishion.algorithm.A.d5;


//是否是平衡二叉树----------------->某一颗子树是不是平衡二叉树
public class Code06_IsBalancedTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int value) {
			this.value = value;
		}

	}

	private static class ReturnType {

		public boolean isBLT;
		public int high;// 树的高度

		public ReturnType(boolean isBLT, int high) {
			this.isBLT = isBLT;
			this.high = high;
		}

	}

	private static ReturnType isBalanced(Node head) {

		if (head == null) {
			return new ReturnType(true, 0);
		}

		ReturnType leftData = isBalanced(head.left);
		ReturnType rightData = isBalanced(head.right);

		boolean isBLT = leftData.isBLT && rightData.isBLT
				&& Math.abs((leftData.high - rightData.high)) < 2;
		int height = Math.max(leftData.high, rightData.high) + 1;

		return new ReturnType(isBLT, height);
	}

	public static void main(String[] args) {
		Node head = new Node(1);

		head.left = new Node(2);
		head.right = new Node(3);

		head.left.left = new Node(4);
		head.left.right = new Node(5);

		head.right.left = new Node(6);
		head.right.right = new Node(7);

		// head.right.left.left = new Node(8);
		head.right.left.right = new Node(9);
		head.right.left.right.left = new Node(10);

		System.out.println(isBalanced(head).high);

	}

}
