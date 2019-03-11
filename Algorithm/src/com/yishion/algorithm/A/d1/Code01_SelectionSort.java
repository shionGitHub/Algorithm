package com.yishion.algorithm.A.d1;

import com.yishion.algorithm.Common;

/**
 * —°‘Ò≈≈–Ú
 * 
 * @author Administrator
 * 
 */
public class Code01_SelectionSort extends Common {

	public static void main(String[] args) {
		int[] arr1 = generationArray(10, 1, 10);
		int[] arr2 = copyArray(arr1);
		selectionSort(arr1);
		compare(arr2);
		boolean success = true;
		if (!isEqual(arr1, arr2)) {
			printArr(arr1);
			printArr(arr2);
			success = false;
		}
		System.out.println(success ? "Ok!" : "Error!");

	}

	private static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;

		for (int i = 0; i < arr.length; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[index] > arr[j]) {
					index = j;
				}
			}
			swap(arr, index, i);
		}

	}

}
