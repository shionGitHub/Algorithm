package com.yishion.algorithm.A.d4;

public class Code05_SmallerEqualBigger {

	public static class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	private static void printLinkedList(Node head) {

		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();

	}

	// ��һ�ַ�ʽ С���� ������ ������ ����partition
	private static Node listPartition1(Node head, int pivot) {// ͷ�ڵ�ͻ���ֵ
		if (head == null || head.next == null) {
			return head;
		}

		int i = 0;
		Node pHead = head;
		while (pHead != null) {
			i++;
			pHead = pHead.next;
		}

		Node[] nodeArr = new Node[i];
		pHead = head;
		for (i = 0; i < nodeArr.length; i++) {
			nodeArr[i] = pHead;
			pHead = pHead.next;
		}

		arrPartition(nodeArr, pivot);

		// ��ʣ�µ����еĽڵ㴮������
		for (i = 1; i < nodeArr.length; i++) {
			nodeArr[i - 1].next = nodeArr[i];// 0--1//1--2//2--3
		}
		// i������nodeArr.length
		nodeArr[i - 1].next = null;

		return nodeArr[0];
	}

	private static Node[] arrPartition(Node[] arr, int pivot) {
		int less = -1;
		int more = arr.length;
		int index = 0;

		while (index < more) {
			if (arr[index].value > pivot) {// ��ǰֵ���ڻ���ֵ
				// ��ǰλ�ò��䣬�ʹ�����ǰһ��λ�ý���������������
				swap(arr, index, --more);
			} else if (arr[index].value == pivot) {// ��ǰֵ���ڻ���ֵ
				index++;
			} else {
				swap(arr, ++less, index++);
			}
		}

		return arr;
	}

	private static void swap(Node[] arr, int l, int r) {
		Node temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}

	// �ڶ��ַ�ʽ С���� ������ ������ ����partition
	private static Node listPartition2(Node head, int pivot) {// ͷ�ڵ�ͻ���ֵ
		if (head == null || head.next == null) {
			return head;
		}

		Node sH = null;
		Node sT = null;

		Node eH = null;
		Node eT = null;

		Node mH = null;
		Node mT = null;

		Node next = null;
		Node pHead = head;

		while (pHead != null) {

			if (pHead.value < pivot) {// С��������
				System.out.println(pHead.value + " ");
				if (sH == null) {
					sH = pHead;
					sT = pHead;
				} else {
					sT.next = pHead;
					sT = pHead;
				}
			} else if (pHead.value == pivot) {// ����������
				if (eH == null) {
					eH = pHead;
					eT = pHead;
				} else {
					eT.next = pHead;
					eT = pHead;
				}
			} else if (pHead.value > pivot) {// ����������
				if (mH == null) {
					mH = pHead;
					mT = pHead;
				} else {
					mT.next = pHead;
					mT = pHead;
				}
			}
			next = pHead.next;
			pHead.next = null;
			pHead = next;
		}

		printLinkedList(sH);
		printLinkedList(eH);
		printLinkedList(mH);

		if (sT != null) {
			sT.next = eH;
			eT = (eT != null) ? eT : sT;
		}

		if (eT != null) {
			eT.next = mH;
		}

		return sH != null ? sH : (eH != null ? eH : mH);

	}

	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);
		printLinkedList(head1);
		// 7 9 1 8 5 2 5
		head1 = listPartition1(head1, 5);
		// printLinkedList(head1);
		Node head = listPartition2(head1, 5);
		printLinkedList(head);
	}

}
