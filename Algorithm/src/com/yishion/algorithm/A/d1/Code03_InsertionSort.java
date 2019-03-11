package com.yishion.algorithm.A.d1;

import com.yishion.algorithm.Common;

/**
 * 插入排序
 * 
 * @author Administrator
 * 
 */
public class Code03_InsertionSort extends Common {

	public static void main(String[] args) {
		int[] arr = generationArray(5, 1, 1000);
		printArr(arr);
		insertionSort(arr);
		printArr(arr);
	}

	public static void insertionSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;

		for (int i = 0; i < arr.length; i++) {
			// 条件是不越界，并且前一个值大于后一个值
			for (int j = i; j - 1 >= 0 && arr[j] > arr[j - 1]; j--) {
				swap(arr, j - 1, j);
			}
		}

	}

}
