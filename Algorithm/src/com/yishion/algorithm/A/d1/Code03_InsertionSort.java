package com.yishion.algorithm.A.d1;

import com.yishion.algorithm.Common;

/**
 * ��������
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
			// �����ǲ�Խ�磬����ǰһ��ֵ���ں�һ��ֵ
			for (int j = i; j - 1 >= 0 && arr[j] > arr[j - 1]; j--) {
				swap(arr, j - 1, j);
			}
		}

	}

}
