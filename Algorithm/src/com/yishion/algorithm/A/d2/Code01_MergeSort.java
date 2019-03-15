package com.yishion.algorithm.A.d2;

import com.yishion.algorithm.Common;

public class Code01_MergeSort extends Common {

	public static void main(String[] args) {
		int[] arr = generationArray(10, 1, 1000);
		printArr(arr);
		merge(arr, 0, arr.length - 1);
		printArr(arr);
	}

	private static void merge(int[] arr, int l, int r) {
		if (arr == null || arr.length < 2)
			return;

		if (l == r) {
			return;
		}

		int mid = l + ((r - l) >> 1);
		merge(arr, l, mid);
		merge(arr, mid + 1, r);

		mergeSort(arr, l, mid, r);
	}

	private static void mergeSort(int[] arr, int l, int mid, int r) {
		int p1 = l;
		int p2 = mid + 1;
		int[] help = new int[r - l + 1];
		int i = 0;
		while (p1 <= mid && p2 <= r) {
			help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
		}

		while (p1 <= mid) {
			help[i++] = arr[p1++];
		}

		while (p2 <= r) {
			help[i++] = arr[p2++];
		}

		for (int j = 0; j < help.length; j++) {
			arr[l + j] = help[j];
		}

	}

}
