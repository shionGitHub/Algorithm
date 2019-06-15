package com.yishion.algorithm.A.d5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//������������ȱ���
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

		Map<Node, Integer> map = new HashMap<>();// ��¼��ǰ�ڵ�����һ��
		map.put(head, 1);
		int currLevel = 0;// ��ǰ���ڵĲ㣬��û��ʼ�����ڵ�0��
		int currLevelMaxNodeNum = 0;// ĳһ�����Ľڵ�ĸ�����û�п�ʼ����0��
		int currLevelNum = 0;
		while (!list.isEmpty()) {
			Node node = list.pop();
			System.out.print(node.value + "  ");

			int level = map.get(node);// ��ȡ�ڵ����ڲ���
			if (currLevel != level) {// ��ǰ�㲻���ڽڵ���һ�㣬�µ�һ�㿪ʼ��
				currLevel = level;// ��ס���¿�ʼ��һ��
				currLevelMaxNodeNum = Math.max(currLevelMaxNodeNum,
						currLevelNum);// ��һ����ܸ�������һ���ܸ����Ƚϣ�ȡ�����ֵ
				currLevelNum = 1;// ��ʼ�µ�һ��ͳ��
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
		System.out.println("-------ͳ�Ʋ��������: " + currLevelMaxNodeNum);
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
