package com.yishion.algorithm.A.d2;

import com.yishion.algorithm.Common;

public class Code02_SmallSum extends Common {

	public static void main(String[] args) {
		int[] arr = generationArray(5, 2, 10);
		printArr(arr);  
		int sum = merge(arr, 0, arr.length - 1);
		printArr(arr);
		System.out.println("Sum : " + sum);
	}

	private static int merge(int[] arr, int l, int r) {
		if (l == r) {
			return 0;
		}

		int mid = l + ((r - l) >> 1);

		int s1 = merge(arr, l, mid);
		int s2 = merge(arr, mid + 1, r);
		int s3 = mergeSort(arr, l, mid, r);
		return s1 + s2 + s3;

	}

	private static int mergeSort(int[] arr, int l, int mid, int r) {
		int sum = 0;

		int p1 = l;
		int p2 = mid + 1;
		int[] help = new int[r - l + 1];
		int i = 0;
		while (p1 <= mid && p2 <= r) {
			sum += ((arr[p1] < arr[p2]) ? (arr[p1] * (r - p2 + 1)) : 0);
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
			
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
		return sum;
	}
}
