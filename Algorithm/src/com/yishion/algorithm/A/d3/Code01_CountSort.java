package com.yishion.algorithm.A.d3;

import com.yishion.algorithm.Common;

public class Code01_CountSort extends Common {

	public static void main(String[] args) {
		int[] arr = { 1, 9, 0, 3, 1, 1, 1, 3, 3, 9 };
		countSort(arr);
		printArr(arr);
	}

	public static void countSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}

		int[] bucket = new int[max + 1];

		for (int i = 0; i < arr.length; i++) {
			bucket[arr[i]]++;
		}

		int j = 0;
		for (int i = 0; i < bucket.length; i++) {
			while (bucket[i]-- > 0) {
				arr[j++] = i;
			}

		}

	}
}
