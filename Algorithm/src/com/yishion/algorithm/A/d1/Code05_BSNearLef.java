package com.yishion.algorithm.A.d1;

import com.yishion.algorithm.Common;

//�����������в���>=value �������λ��
public class Code05_BSNearLef extends Common {

	public static void main(String[] args) {
		int[] arr = generationArray(10, 90, 1000);
		insertionSort(arr);
		printArr(arr);
		int a = nearestIndex(arr, 300);
		System.out.println(a);
	}

	private static int nearestIndex(int[] arr, int value) {
		int L = 0;
		int R = arr.length - 1;
		int index = -1;
		while (L < R) {
			int mid = L + ((R - L) >> 1);

			if (arr[mid] >= value) {
				index = mid;
				R = mid - 1;
			} else if (arr[mid] < value) {
				L = mid + 1;
			}
		}

		return index;

	}

	public static void insertionSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;

		for (int i = 0; i < arr.length; i++) {
			// �����ǲ�Խ�磬����ǰһ��ֵ���ں�һ��ֵ
			for (int j = i; j - 1 >= 0 && arr[j] < arr[j - 1]; j--) {
				swap(arr, j - 1, j);
			}
		}

	}

}
