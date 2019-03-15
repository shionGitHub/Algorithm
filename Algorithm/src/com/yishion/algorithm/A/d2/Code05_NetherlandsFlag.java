package com.yishion.algorithm.A.d2;

import com.yishion.algorithm.Common;

public class Code05_NetherlandsFlag extends Common {

	public static void main(String[] args) {
		int[] arr = generationArray(5, 0, 20);
		// int[] arr = { 5, 18, 20, 3, 0 };

		int num = 12;
		printArr(arr);
		partition(arr, 0, arr.length - 1, num);
		printArr(arr);

	}

	
	
	private static void partition(int[] arr, int L, int R, int p) {

		int less = L - 1;
		int more = R + 1;
		int i = L;

		while (i < more) {
			if (arr[i] > p) {
				swap(arr, i, --more);
			} else if (arr[i] < p) {
				swap(arr, i++, ++less);
			} else {
				i++;
			}
		}

		System.out.println("less: " + less + "  more: " + more);

	}

}
