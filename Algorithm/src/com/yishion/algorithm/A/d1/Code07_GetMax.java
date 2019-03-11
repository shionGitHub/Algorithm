package com.yishion.algorithm.A.d1;

import com.yishion.algorithm.Common;

public class Code07_GetMax extends Common {

	public static void main(String[] args) {
		int[] arr = generationArray(10, 39, 300);
		printArr(arr);
		System.out.println(process(arr, 0, arr.length - 1));

	}

	private static int process(int[] arr, int L, int R) {
		if (L == R)
			return arr[L];

		int mid = L + ((R - L) >> 1);

		int left = process(arr, L, mid);
		int right = process(arr, mid + 1, R);

		return Math.max(left, right);

	}

}
