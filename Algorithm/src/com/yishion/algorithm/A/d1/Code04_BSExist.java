package com.yishion.algorithm.A.d1;

import com.yishion.algorithm.Common;

//在一个有序数组中找出某个数是否存在
public class Code04_BSExist extends Common {

	public static void main(String[] args) {
		int[] arr = generationArray(100, 1, 1000);
		insertionSort(arr);
		printArr(arr);
		exist(arr, 10000);
	}

	// 在arr中查找value是否存在,不断的二分查找
	public static boolean exist(int[] arr, int value) {

		int L = 0;
		int R = arr.length - 1;
		int mid = 0;
		while (L < R) {// 二分到最后L == R

			mid = L + ((R - L) >> 1);

			if (arr[mid] > value) {
				R = mid - 1;
			} else if (arr[mid] < value) {
				L = mid + 1;
			} else {// 存在
				return true;
			}
			System.out.println("L: " + L + " mid: " + mid + " R: " + R);
		}

		return arr[L] == value;

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
