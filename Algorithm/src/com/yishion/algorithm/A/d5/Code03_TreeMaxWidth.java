package com.yishion.algorithm.A.d5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//二叉树宽度优先遍历
public class Code03_TreeMaxWidth {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static int getMaxWidth(Node head) {

		if (head == null) {
			return 0;
		}

		LinkedList<Node> list = new LinkedList<>();
		list.add(head);

		Map<Node, Integer> map = new HashMap<>();// 记录当前节点在那一层
		map.put(head, 1);
		int currLevel = 0;// 当前所在的层，还没开始所以在第0层
		int currLevelMaxNodeNum = 0;// 某一层最大的节点的个数，没有开始所以0个
		int currLevelNum = 0;
		while (!list.isEmpty()) {
			Node node = list.pop();
			System.out.print(node.value + "  ");

			int level = map.get(node);// 获取节点所在层数
			if (currLevel != level) {// 当前层不等于节点这一层，新的一层开始了
				currLevel = level;// 记住最新开始的一层
				currLevelMaxNodeNum = Math.max(currLevelMaxNodeNum,
						currLevelNum);// 上一层的总个数和这一层总个数比较，取得最大值
				currLevelNum = 1;// 开始新的一层统计
			} else {
				currLevelNum++;
			}

			if (node.left != null) {
				list.add(node.left);
				map.put(node.left, level + 1);
			}

			if (node.right != null) {
				list.add(node.right);
				map.put(node.right, level + 1);
			}

		}
		System.out.println();
		System.out.println("-------统计层数最大宽度: " + currLevelMaxNodeNum);
		return currLevelMaxNodeNum;
	}

	public static void main(String[] args) {
		Node head = new Node(1);

		head.left = new Node(2);
		head.right = new Node(3);

		head.left.left = new Node(4);
		head.left.right = new Node(5);

		head.right.left = new Node(6);
		head.right.right = new Node(7);

		head.right.left.left = new Node(8);
		head.right.left.right = new Node(9);

		getMaxWidth(head);

	}

}
