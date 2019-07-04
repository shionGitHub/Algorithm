package com.yishion.algorithm.A.d7;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Code03_LessMoneySplitGold {

	public static int lessMoney(Integer[] arr) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		priorityQueue.addAll(Arrays.asList(arr));

		int sum = 0;
		int temp = 0;
		while (priorityQueue.size() > 1) {
			temp = priorityQueue.poll() + priorityQueue.poll();
			sum += temp;
			priorityQueue.add(temp);
		}
		return sum;
	}

	public static void main(String[] args) {
		Integer[] arr = { 10, 20, 30 };
		System.out.println(lessMoney(arr));
	}

}
