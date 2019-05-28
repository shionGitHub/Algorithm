package com.yishion.algorithm.A.d4;

public class Code07_FindFirstIntersectNode {

	public static class Node {

		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}

	}

	// 获取链表有环的第一个入环的节点
	public static Node getLoopNode(Node node) {
		if (node == null || node.next == null || node.next.next == null) {
			return null;
		}

		Node m = node.next;// 慢指针
		Node k = node.next.next;// 快指针

		while (k != m) {// 相等的时候退出
			if (k.next == null || k.next.next == null) {
				return null;
			}
			k = k.next.next;// 快指针走2步
			m = m.next;// 慢指针走1步
		}
		// 快指针移动到头节点,开始走一步,慢指针不动
		k = node;
		while (k != m) {
			k = k.next;
			m = m.next;
		}
		// 返回相遇的节点
		return m;
	}

	// 两个无环链表相交
	public static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		int n = 0;
		Node res1 = head1;
		while (res1.next != null) {
			n++;
			res1 = res1.next;
		}

		Node res2 = head2;
		while (res2.next != null) {
			n--;
			res2 = res2.next;
		}

		if (res2 != res1) {
			return null;// 两个链表不相交
		} else {
			Node curr1 = (n > 0) ? head1 : head2;// 长的链表
			Node curr2 = (curr1 == head1) ? head2 : head1;// 短链表

			n = Math.abs(n);

			while (n > 0) {
				curr1 = curr1.next;
				n--;
			}

			while (curr1 != curr2) {
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
			return curr1;
		}
	}

	// 两个有环链表的相交
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node curr1 = head1;
		Node curr2 = head2;
		int n = 0;
		if (loop1 == loop2) {
			while (curr1.next != loop1) {
				curr1 = curr1.next;
				n++;
			}

			while (curr2.next != loop2) {
				curr2 = curr2.next;
				n--;
			}

			curr1 = n > 0 ? head1 : head2;// 长的链表
			curr2 = (curr1 == head1) ? head2 : head1;// 短的链表
			n = Math.abs(n);
			while (n > 0) {
				curr1 = curr1.next;
				n--;
			}

			while (curr1 != curr2) {
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
			return curr1;
		} else {
			curr1 = loop1.next;
			while (curr1 != loop1) {// 一直转到loop1
				if (curr1 == loop2) {// 中间遇loop2，返回loop2
					return loop2;
				}
				curr1 = curr1.next;
			}
			return null;
		}

	}

	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6

		// System.out.println(noLoop(head1, head2).value + " ");

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		System.out.println(bothLoop(head1, loop1, head2, loop2).value + " ");

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6

		loop1 = getLoopNode(head1);
		loop2 = getLoopNode(head2);
		System.out.println(bothLoop(head1, loop1, head2, loop2).value + " ");

	}

}
