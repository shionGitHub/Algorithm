package com.yishion.algorithm.A.d5;

import java.util.LinkedList;

//�Ƿ�����ȫ����������������
public class Code05_IsCBT {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int value) {
			this.value = value;
		}

	}

	// ��ȫ������
	public static boolean isCompleteBinaryTree(Node node) {
		if (node == null) {
			return false;
		}

		LinkedList<Node> queues = new LinkedList<>();
		queues.add(node);
		boolean isCBT = false;
		while (!queues.isEmpty()) {
			Node head = queues.pop();
			if (head.left != null) {
				queues.add(head.left);
			}
			if (head.right != null) {
				queues.add(head.right);
			}

			if (head.right != null && head.left == null) {// ��������������
				return false;
			}

			if (!isCBT && !(head.left != null && head.right != null)) {// ������һ����˫ȫ�ڵ�
				isCBT = true;
				continue;
			}

			if (isCBT) {// �жϲ���˫ȫ�ڵ����Ľڵ�------>ȫ����Ҫ��Ҷ�ӽڵ�
				if (head.left == null && head.right == null) {

				} else {
					isCBT = false;// �ҵ�һ������Ҷ�ӽڵ㣬����ֹͣ��
					break;
				}
			}

		}

		return isCBT;
	}

	public static class ReturnFBT {
		public int num;// ����
		public int high;// �߶�

		public ReturnFBT(int high, int num) {
			this.high = high;
			this.num = num;
		}

	}

	// ��������
	public static ReturnFBT isFullBinaryTree(Node node) {
		if (node == null) {
			return new ReturnFBT(0, 0);
		}

		ReturnFBT leftData = isFullBinaryTree(node.left);
		ReturnFBT rightData = isFullBinaryTree(node.right);

		int high = Math.max(leftData.high, rightData.high) + 1;
		int numb = leftData.num + rightData.num + 1;

		return new ReturnFBT(high, numb);

	}

	public static void main(String[] args) {
		Node head1 = new Node(1);

		head1.left = new Node(2);
		head1.right = new Node(3);

		head1.left.left = new Node(4);
		head1.left.right = new Node(5);

		head1.right.left = new Node(6);
		head1.right.right = new Node(7);

		System.out.println(isCompleteBinaryTree(head1));

		ReturnFBT returnFBT = isFullBinaryTree(head1);
		System.out.println(returnFBT.high);
		System.out.println(returnFBT.num);
		System.out.println(1 << (returnFBT.high));// 2��high�η�

		System.out.println((1 << (returnFBT.high)) == (1 + returnFBT.num));

	}

}
