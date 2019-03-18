package com.yishion.algorithm.A.d3;

import com.yishion.algorithm.Common;

public class Code02_RadixSort extends Common {

	public static void main(String[] args) {
		int[] arr = { 106, 98, 5, 13, 10 };
		radixSort(arr);
		printArr(arr);
	}

	private static void radixSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}

		radixSort(arr, 0, arr.length - 1, maxbits(arr));
	}

	private static int maxbits(int[] arr) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}

		int res = 0;

		while (max != 0) {
			res++;
			max /= 10;
		}

		return res;
	}

	private static void radixSort(int[] arr, int start, int end, int maxbits) {
		int radix = 10;
		int i = 0, j = 0;

		int[] bucket = new int[end - start + 1];
		for (int d = 1; d <= maxbits; d++) {
			int[] count = new int[radix];

			for (i = start; i <= end; i++) {
				j = getDigit(arr[i], d);
				count[j]++;
			}

			for (i = 1; i < radix; i++) {
				count[i] = count[i] + count[i - 1];
			}

			for (i = end; i >= start; i--) {
				j = getDigit(arr[i], d);
				bucket[--count[j]] = arr[i];
			}

			for (i = start, j = 0; i <= end; i++, j++) {
				arr[i] = bucket[j];
			}

		}

	}

	// 提取某个数值的某个位上的数字
	public static int getDigit(int x, int d) {
		// Math.pow(x,y)这个函数是求x的y次方
		return ((x / ((int) Math.pow(10, d - 1))) % 10);
	}

}
