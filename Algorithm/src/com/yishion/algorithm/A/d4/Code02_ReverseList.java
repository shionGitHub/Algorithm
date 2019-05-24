package com.yishion.algorithm.A.d4;

public class Code02_ReverseList {

	public static class Node {
		public int value;
		public Node next;

		public Node(int val) {
			this.value = val;
		}
	}

	// 单链表的反转
	public static Node reverseList(Node head) {
		if (head == null) {
			return head;
		}

		Node pre = null;
		Node next = null;

		while (head != null) {
			next = head.next;// 记住下一个Node
			head.next = pre;// 将下一个节点指向前一个

			pre = head;// 前一个节点指向头节点head
			head = next;// head头节点指向下一个节点next
		}

		return pre;
	}

	// 打印链表的节点
	private static void printList(Node head) {
		if (head == null)
			return;
		Node pHead = head;
		while (pHead != null) {
			System.out.println(pHead.value);
			pHead = pHead.next;
		}

	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);

		Node newHead = reverseList(head);
		printList(newHead);

		DoubleNode dNode = new DoubleNode(10);
		dNode.next = new DoubleNode(20);
		dNode.last = null;

		dNode.next.next = new DoubleNode(30);
		dNode.next.last = dNode;

		dNode.next.next.next = new DoubleNode(40);
		dNode.next.next.last = dNode.next;

		dNode.next.next.next.next = new DoubleNode(50);
		dNode.next.next.next.last = dNode.next;

		DoubleNode dHeadNode = reveserDoubleNode(dNode);
		printDoubleNode(dHeadNode);
	}

	public static class DoubleNode {

		public int value;
		public DoubleNode last;
		public DoubleNode next;

		public DoubleNode(int value) {
			this.value = value;
		}

	}

	public static DoubleNode reveserDoubleNode(DoubleNode head) {

		if (head == null) {
			return head;
		}

		DoubleNode pre = null;
		DoubleNode next = null;

		while (head != null) {
			next = head.next;
			head.next = pre;
			head.last = next;

			pre = head;
			head = next;
		}
		return pre;

	}

	private static void printDoubleNode(DoubleNode head) {
		if (head == null) {
			return;
		}

		DoubleNode pHead = head;
		DoubleNode pEnd = null;
		while (pHead != null) {
			System.out.println(pHead.value);
			pEnd = pHead;
			pHead = pHead.next;
		}
		System.out.println("|");

		while (pEnd != null) {
			System.out.println(pEnd.value);
			pEnd = pEnd.last;
		}

	}

}
