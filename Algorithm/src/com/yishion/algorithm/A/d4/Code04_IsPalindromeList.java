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

	// ��һ�ַ�ʽ��֤�������� �ռ临�Ӷ�O(n)
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

	// �ڶ��ַ�ʽ��֤��������� �ռ临�Ӷ�O(n/2)
	public static boolean isPalindrome2(Node head) {
		if (head == null || head.next == null) {
			return true;
		}

		Node k = head;// ��ָ��---��ָ��ͷ�ڵ�
		Node m = head.next;// ��ָ��---��ָ��ڶ����ڵ�

		while (k.next != null && k.next.next != null) {// ��ָ����û������������
			m = m.next;// ��ָ����һ��
			k = k.next.next;// ��ָ��������
		}

		// ���ʱ�����ָ���ʣ�ಿ�ּ��뵽Stack��
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

	// �����ַ�ʽ��֤�������� �ռ临�Ӷ�O(1)
	public static boolean isPalindrome3(Node head) {
		if (head == null || head.next == null) {
			return true;
		}

		Node k = head;// ��ָ��
		Node m = head;// ��ָ��
		while (k.next != null && k.next.next != null) {// ��ָ����û��2����
			k = k.next.next;// ��ָ����2��
			m = m.next;// ��ָ����1��
		}

		// ������ʱ����ָ�뿪ʼ�Ӵ˴��������������
		Node mm = m;// ��ס��ָ��ĵ�ǰλ��

		// ��ʼ�������������
		Node curr = m.next;// Ҫ���������
		Node per = null;// ǰһ���ڵ�
		Node next = null;// ��һ���ڵ�
		while (curr != null) {
			next = curr.next;// ��ס��һ���ڵ�
			curr.next = per;// ��ǰ�ڵ�ָ��ǰһ���ڵ�
			per = curr;// ǰһ���ڵ��ƶ�����ǰ�ڵ�
			curr = next;// ��ǰ�ڵ��ƶ�����һ���ڵ㴦
		}
		// ���ǰ�ڵ�Ϊnull��ʱ��per�ߵ������(�������ͷ��)
		// ��ʱ��ʼ��������ıȽ�
		Node newNode = per;// �µ�����
		Node oldNode = head;// �ɵ�����
		boolean isRight = true;
		while (newNode != null) {
			if (oldNode.value != newNode.value) {
				isRight = false;
				break;
			}
			newNode = newNode.next;
			oldNode = oldNode.next;// ������
		}

		// ���ʱ���ٰ����������ȥ

		Node c = per;
		Node p = null;
		Node n = null;

		while (c != null) {
			n = c.next;// ��ס��һ���ڵ�
			c.next = p;// ָ��ǰһ���ڵ�
			p = c;// ǰһ���ڵ��Ƶ���ǰ�ڵ�
			c = n;// ��ǰ�ڵ��Ƶ���һ��
		}

		mm.next = p;// ָ����һ���ڵ�
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
