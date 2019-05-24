package com.yishion.algorithm.A.d4;

public class Code03_PrintCommonPart {

	public static class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
		}

	}

	public static void printLinkedList(Node node) {
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void printCommonPart(Node node1, Node node2) {
		while (node1 != null && node2 != null) {
			if (node1.value < node2.value) {
				node1 = node1.next;
			} else if (node1.value > node2.value) {
				node2 = node2.next;
			} else {
				System.out.print(node1.value + " ");
				node1 = node1.next;
				node2 = node2.next;
			}
		}
	}

	public static void main(String[] args) {

		Node n1 = new Node(3);
		n1.next = new Node(5);
		n1.next.next = new Node(6);
		n1.next.next.next = new Node(10);
		n1.next.next.next.next = new Node(100);

		Node n2 = new Node(1);
		n2.next = new Node(3);
		n2.next.next = new Node(5);
		n2.next.next.next = new Node(59);
		n2.next.next.next.next = new Node(100);
		printLinkedList(n1);
		printLinkedList(n2);
		printCommonPart(n1, n2);

	}
	
	

}
