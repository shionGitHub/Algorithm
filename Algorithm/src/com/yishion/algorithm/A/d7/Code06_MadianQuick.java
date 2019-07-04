package com.yishion.algorithm.A.d7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code06_MadianQuick {

	public static class MaxHeapComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			if (o2 > o1) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	public static class MinHeapComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			if (o2 < o1) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	public static class MedianHolder {
		static PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(
				new MaxHeapComparator());
		static PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>(
				new MinHeapComparator());

		public static void reset() {
			minPriorityQueue.clear();
			maxPriorityQueue.clear();
		}

		public static int getMedian(int[] arr) {

			for (int i = 0; i < arr.length; i++) {
				addNumber(arr[i]);
			}
			if (maxPriorityQueue.size() == minPriorityQueue.size()) {
				return (maxPriorityQueue.peek() + minPriorityQueue.peek()) / 2;
			} else if (maxPriorityQueue.size() > minPriorityQueue.size()) {
				return maxPriorityQueue.peek();
			} else {
				return minPriorityQueue.peek();
			}

		}

		public static void addNumber(int num) {
			if (maxPriorityQueue.isEmpty()) {
				maxPriorityQueue.add(num);
				return;
			}

			if (maxPriorityQueue.peek() >= num) {// 大根堆的堆顶值大于当前值
				maxPriorityQueue.add(num);
			} else {
				minPriorityQueue.add(num);
			}

			modifyPriority();

		}

		private static void modifyPriority() {
			if (maxPriorityQueue.size() == minPriorityQueue.size() + 2) {
				minPriorityQueue.add(maxPriorityQueue.poll());
			}
			if (minPriorityQueue.size() == maxPriorityQueue.size() + 2) {
				maxPriorityQueue.add(minPriorityQueue.poll());
			}
		}

	}

	public static int[] getRandomArray(int maxLen, int maxValue) {

		int[] arr = new int[(int) (maxLen * Math.random()) + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue * Math.random()) + 1);
		}
		return arr;
	}

	private static int getMedianNum(int[] arr) {
		int[] newArr = Arrays.copyOf(arr, arr.length);
		Arrays.sort(newArr);
		int medium = (newArr.length - 1) / 2;
		if (((newArr.length) & 1) == 0) {// 偶数
			return (newArr[medium] + newArr[medium + 1]) / 2;
		} else {
			return newArr[medium];
		}
	}

	private static void printArray(int[] arr) {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		boolean err = false;
		int testTimes = 200000;

		for (int i = 0; i < testTimes; i++) {
			int len = 30;
			int maxValue = 10000;
			int[] array = getRandomArray(len, maxValue);
			MedianHolder.reset();
			if (MedianHolder.getMedian(array) != getMedianNum(array)) {
				err = true;
				System.out.println(MedianHolder.getMedian(array));
				printArray(array);
				System.out.println(getMedianNum(array));
				break;
			}
		}
		System.out.println(err ? "Oops..what a fuck!"
				: "today is a beautiful day^_^");
	}
}
