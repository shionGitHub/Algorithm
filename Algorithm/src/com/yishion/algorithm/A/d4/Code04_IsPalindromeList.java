package com.yishion.algorithm.A.d4;

import java.util.Stack;

public class Code04_IsPalindromeList {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	// 第一种方式验证回文链表 空间复杂度O(n)
	public static boolean isPalindrome1(Node node) {
		Stack<Node> stack = new Stack<>();
		Node pHead = node;
		while (pHead != null) {
			stack.push(pHead);
			pHead = pHead.next;
		}
		while (!stack.isEmpty()) {
			if (stack.pop().value != node.value) {
				return false;
			}
			node = node.next;
		}

		return true;
	}

	// 第二种方式验证回文链表的 空间复杂度O(n/2)
	public static boolean isPalindrome2(Node head) {
		if (head == null || head.next == null) {
			return true;
		}

		Node k = head;// 快指针---》指向头节点
		Node m = head.next;// 慢指针---》指向第二个节点

		while (k.next != null && k.next.next != null) {// 快指针有没有两部让你跳
			m = m.next;// 慢指针走一步
			k = k.next.next;// 快指针走两步
		}

		// 这个时候把慢指针的剩余部分加入到Stack中
		Stack<Node> stack = new Stack<>();
		while (m != null) {
			stack.add(m);
			m = m.next;
		}
		while (!stack.isEmpty()) {
			if (stack.pop().value != head.value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	// 第三种方式验证回文链表 空间复杂度O(1)
	public static boolean isPalindrome3(Node head) {
		if (head == null || head.next == null) {
			return true;
		}

		Node k = head;// 快指针
		Node m = head;// 慢指针
		while (k.next != null && k.next.next != null) {// 快指针有没有2步跳
			k = k.next.next;// 快指针走2步
			m = m.next;// 慢指针走1步
		}

		// 结束的时候，慢指针开始从此处进行链表的逆序
		Node mm = m;// 记住慢指针的当前位置

		// 开始进行链表的逆序
		Node curr = m.next;// 要逆序的链表
		Node per = null;// 前一个节点
		Node next = null;// 下一个节点
		while (curr != null) {
			next = curr.next;// 记住下一个节点
			curr.next = per;// 当前节点指向前一个节点
			per = curr;// 前一个节点移动到当前节点
			curr = next;// 当前节点移动到下一个节点处
		}
		// 最后当前节点为null的时候，per走到了最后(新链表的头部)
		// 此时开始两个链表的比较
		Node newNode = per;// 新的链表
		Node oldNode = head;// 旧的链表
		boolean isRight = true;
		while (newNode != null) {
			if (oldNode.value != newNode.value) {
				isRight = false;
				break;
			}
			newNode = newNode.next;
			oldNode = oldNode.next;// 旧链表
		}

		// 这个时候再把链表逆序回去

		Node c = per;
		Node p = null;
		Node n = null;

		while (c != null) {
			n = c.next;// 记住下一个节点
			c.next = p;// 指向前一个节点
			p = c;// 前一个节点移到当前节点
			c = n;// 当前节点移到下一个
		}

		mm.next = p;// 指向下一个节点
		return isRight;
	}

	private static void printLinkedList(Node node) {
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Node head = null;
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

	}

}
