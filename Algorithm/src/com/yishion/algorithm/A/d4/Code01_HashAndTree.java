package com.yishion.algorithm.A.d4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Code01_HashAndTree {

	// public static class Node implements Comparable<Node> {
	// public int value;
	// public Node next;
	//
	// public Node(int val) {
	// value = val;
	// }
	//
	// @Override
	// public int compareTo(Node other) {
	// return this.value - other.value;
	// }
	//
	// }

	public static class Node {
		public int value;
		public Node next;

		public Node(int val) {
			value = val;
		}

	}

	public static class NodeCompare implements Comparator<Node> {

		// ���ظ�����ʱ��,��һ����������ǰ��
		// ����������ʱ��,��һ���������ں���
		@Override
		public int compare(Node o1, Node o2) {
			System.out.println("o1:" + o1 + "o2:" + o2 + "------��ֵ:"
					+ (o2.value - o1.value));
			return o2.value - o1.value;
		}

	}

	public static void main(String[] args) {
		Node nodeA = null;
		Node nodeB = null;
		Node nodeC = null;

		// hashSet1��key�ǻ�������->int����
		HashSet<Integer> hashSet1 = new HashSet<>();
		hashSet1.add(3);
		System.out.println(hashSet1.contains(3));
		hashSet1.remove(3);
		System.out.println(hashSet1.contains(3));
		System.out.println("========1=========");

		// hashSet2��key�Ƿǻ�������->Node����
		nodeA = new Node(1);
		nodeB = new Node(1);
		HashSet<Node> hashSet2 = new HashSet<>();
		hashSet2.add(nodeA);
		System.out.println(hashSet2.contains(nodeA));
		System.out.println(hashSet2.contains(nodeB));
		hashSet2.remove(nodeA);
		System.out.println(hashSet2.contains(nodeA));
		System.out.println("========2=========");

		// hashMap1��key�ǻ�������->String����
		HashMap<String, Integer> hashMap1 = new HashMap<>();
		String str1 = "key";
		String str2 = "key";
		hashMap1.put(str1, 1);
		System.out.println(hashMap1.containsKey(str1));
		System.out.println(hashMap1.containsKey(str2));
		System.out.println(hashMap1.get(str1));
		System.out.println(hashMap1.get(str2));

		hashMap1.put(str2, 2);
		System.out.println(hashMap1.containsKey(str1));
		System.out.println(hashMap1.containsKey(str2));
		System.out.println(hashMap1.get(str1));
		System.out.println(hashMap1.get(str2));

		hashMap1.remove(str1);
		System.out.println(hashMap1.containsKey(str1));
		System.out.println(hashMap1.containsKey(str2));
		System.out.println(hashMap1.get(str1));
		System.out.println(hashMap1.get(str2));
		System.out.println("========3=========");

		// hashMap2��key�Ƿǻ�������->Node����
		nodeA = new Node(1);
		nodeB = new Node(1);
		HashMap<Node, String> hashMap2 = new HashMap<>();
		hashMap2.put(nodeA, "A�ڵ�");
		System.out.println(hashMap2.containsKey(nodeA));
		System.out.println(hashMap2.containsKey(nodeB));
		System.out.println(hashMap2.get(nodeA));
		System.out.println(hashMap2.get(nodeB));

		hashMap2.put(nodeB, "B�ڵ�");
		System.out.println(hashMap2.containsKey(nodeA));
		System.out.println(hashMap2.containsKey(nodeB));
		System.out.println(hashMap2.get(nodeA));
		System.out.println(hashMap2.get(nodeB));
		System.out.println("========4=========");

		// treeSet��key�Ƿǻ�������->Node����
		nodeA = new Node(7);
		nodeB = new Node(6);
		nodeC = new Node(5);

		TreeSet<Node> treeSet = new TreeSet<>(new NodeCompare());
		// ���µĴ���ᱨ����Ϊû���ṩNode���͵ıȽ���
		try {
			treeSet.add(nodeA);
			treeSet.add(nodeB);
			treeSet.add(nodeC);
			while (!treeSet.isEmpty()) {
				System.out.println(treeSet.pollLast().value);
			}
		} catch (Exception e) {
			System.out.println("������Ϣ��" + e.getMessage());
		}
		System.out.println("========5=========");

		// չʾ������ò���
		TreeMap<Integer, String> treeMap1 = new TreeMap<>();
		treeMap1.put(7, "����7");
		treeMap1.put(5, "����5");
		treeMap1.put(4, "����4");
		treeMap1.put(3, "����3");
		treeMap1.put(9, "����9");
		treeMap1.put(2, "����2");
		System.out.println(treeMap1.containsKey(5));
		System.out.println(treeMap1.get(5));
		System.out.println(treeMap1.firstKey() + ", ����С");
		System.out.println(treeMap1.lastKey() + ", �����");
		System.out.println(treeMap1.floorKey(8) + ", �ڱ�������<=8�����У�����8���");
		System.out.println(treeMap1.ceilingKey(8) + ", �ڱ�������>=8�����У�����8���");
		System.out.println(treeMap1.floorKey(7) + ", �ڱ�������<=7�����У�����7���");
		System.out.println(treeMap1.ceilingKey(7) + ", �ڱ�������>=7�����У�����7���");
		treeMap1.remove(5);
		System.out.println(treeMap1.get(5) + ", ɾ�˾�û����Ŷ");

		System.out.println("========6=========");

	}

}
