package com.yishion.algorithm;

import java.util.Arrays;

public class Common {

	public static void printArr(int[] arr) {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();
	}

	public static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static int[] generationArray(int size, int min, int max) {

		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = min + (int) ((max - min + 1) * Math.random());
		}
		return arr;
	}

	public static int[] copyArray(int[] arr) {
		if (arr == null)
			return null;
		int[] arr1 = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			arr1[i] = arr[i];
		}
		return arr1;
	}

	// ÉýÐò
	public static void compare(int[] arr) {
		Arrays.sort(arr);
	}

	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr2 == null && arr1 != null)) {
			return false;
		}

		if (arr1 == null && arr2 == null) {
			return true;
		}

		if (arr1.length != arr2.length) {
			return false;
		}

		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}

		return true;
	}

}
