package com.yishion.algorithm.A.d4;

import java.util.HashMap;
import java.util.Map;

public class Code06_CopyListWithRandom {

	public static class Node {
		public int value;
		public Node next;
		public Node rand;

		public Node(int data) {
			this.value = data;
		}
	}

	// 复制含有随机指针的单链表,使用哈希表
	public static Node copyListWithRand1(Node node) {
		Map<Node, Node> map = new HashMap<>();

		Node head = node;
		while (head != null) {
			map.put(head, new Node(head.value));// 克隆出一个相同的节点Node
			head = head.next;
		}

		head = node;
		while (head != null) {
			map.get(head).next = map.get(head.next);
			map.get(head).rand = map.get(head.rand);
			head = head.next;
		}

		return map.get(node);
	}

	public static Node copyListWithRand2(Node node) {
		if (node == null) {
			return node;
		}
		Node head = node;
		Node next = null;
		while (head != null) {// 在每个节点之间复制一个辅助节点
			next = head.next;// 记住下一个节点
			head.next = new Node(head.value);// 头节点指向克隆节点
			head.next.next = next;// 克隆节点指向下一个节点
			head = next;// 移动到下一个节点
		}

		head = node;
		while (head != null) {// 操作随机指针的位置
			next = head.next;
			next.rand = (head.rand != null) ? (head.rand.next) : null;
			head = next.next;
		}

		head = node;
		Node res = head.next;
		Node copyNode = null;
		// 1--1--2--2--3--3--4--4
		while (head != null) {// 分解节点
			next = head.next.next;// 记住下一个二级节点
			copyNode = head.next;
			head.next = next;
			copyNode.next = next.next;
			head = next;

		}

		return res;
	}

	private static void printLinkedList(Node node) {

		Node head = node;
		System.out.println("-----------value || ---------------");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		head = node;
		System.out.println();
		System.out.println("-----------rand || ----------------");
		while (head != null) {
			System.out.print(head.rand != null ? head.rand.value + " "
					: "null ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(3);
		head.next = new Node(6);
		head.next.next = new Node(1);
		head.next.next.next = new Node(500);
		head.next.next.next.next = new Node(16);
		head.next.next.next.next.next = new Node(7);

		head.rand = head.next.next;
		head.next.rand = head;
		head.next.next.rand = head.next.next.next;
		head.next.next.next.rand = head.next.next.next.next.next;
		head.next.next.next.next.rand = null;
		head.next.next.next.next.next.rand = head.next.next.next.next;

		printLinkedList(head);
		// Node n1 = copyListWithRand1(head);
		// printLinkedList(n1);
		Node n2 = copyListWithRand1(head);
		printLinkedList(n2);

	}

}
