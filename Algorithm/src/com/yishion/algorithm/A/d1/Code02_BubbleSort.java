package com.yishion.algorithm.A.d1;

import com.yishion.algorithm.Common;

/**
 * ц╟ещеепР
 * 
 * @author Administrator
 * 
 */
public class Code02_BubbleSort extends Common {

	public static void main(String[] args) {
		int[] arr = generationArray(5, 1, 100);
		printArr(arr);
		bubbleSort(arr);
		printArr(arr);

	}

	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;

		for (int i = arr.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}

	}

}
