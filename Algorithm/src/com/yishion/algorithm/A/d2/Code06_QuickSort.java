package com.yishion.algorithm.A.d2;

import com.yishion.algorithm.Common;

public class Code06_QuickSort extends Common {

	public static void main(String[] args) {
		int[] arr = generationArray(5, 0, 20);
		printArr(arr);
		quickSort(arr, 0, arr.length - 1);
		printArr(arr);
	}

	public static void quickSort(int[] arr, int l, int r) {

		if (l < r) {//
			swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
			int[] p = partition(arr, l, r);// O(n)
			quickSort(arr, l, p[0] - 1);
			quickSort(arr, p[1] + 1, r);
		}

	}

	private static int[] partition(int[] arr, int l, int r) {

		int less = l - 1;
		int more = r;

		int i = l;

		while (i < more) {
			if (arr[i] < arr[r]) {
				swap(arr, i++, ++less);
			} else if (arr[i] > arr[r]) {
				swap(arr, i, --more);
			} else {
				i++;
			}
		}
		swap(arr, more, r);
		return new int[] { less + 1, more };

	}
}
