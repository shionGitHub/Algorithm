package com.yishion.algorithm.A.d2;

import java.util.PriorityQueue;

import com.yishion.algorithm.Common;

public class Code04_SortArrayDistanceLessK extends Common {

	public static void main(String[] args) {
		//int[] arr = new int[] { 7, 8, 9, 0, 1 };

	}

	public void sortedArrDistanceLessK(int[] arr, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

		int index = 0;
		for (; index < k; index++) {
			queue.add(arr[index]);
		}
		int i = 0;
		for (; index < arr.length; index++) {
			queue.add(arr[index]);
			arr[i++] = queue.poll();
		}

		while (!queue.isEmpty()) {
			arr[i++] = queue.poll();
		}

	}

}
