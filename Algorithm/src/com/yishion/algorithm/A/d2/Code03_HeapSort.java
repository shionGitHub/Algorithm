package com.yishion.algorithm.A.d2;

import com.yishion.algorithm.Common;

public class Code03_HeapSort extends Common {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			int[] arr = generationArray(5, 30, 100);

			heapSort(arr);
			printArr(arr);
		}

	}

	private static void heapSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}

		int heapSize = arr.length;

		while (heapSize > 0) {
			swap(arr, 0, --heapSize);
			heapify(arr, 0, heapSize);
		}

	}

	private static void heapInsert(int[] arr, int index) {

		int p = (index - 1) / 2;
		while (arr[index] > arr[p]) {
			swap(arr, p, index);
			index = p;
			p = (index - 1) / 2;
		}

	}

	private static void heapify(int[] arr, int index, int heapSize) {

		int L = 2 * index + 1;

		while (L < heapSize) {

			int largest = (((L + 1) >= heapSize) || (arr[L] > arr[L + 1])) ? L
					: (L + 1);

			largest = arr[index] > arr[largest] ? index : largest;
			if (largest == index) {
				break;
			}

			swap(arr, largest, index);
			index = largest;
			L = 2 * index + 1;

		}

	}
}
