package com.yishion.algorithm.A.d1;

import com.yishion.algorithm.Common;

//��һ�������������ҳ�ĳ�����Ƿ����
public class Code04_BSExist extends Common {

	public static void main(String[] args) {
		int[] arr = generationArray(100, 1, 1000);
		insertionSort(arr);
		printArr(arr);
		exist(arr, 10000);
	}

	// ��arr�в���value�Ƿ����,���ϵĶ��ֲ���
	public static boolean exist(int[] arr, int value) {

		int L = 0;
		int R = arr.length - 1;
		int mid = 0;
		while (L < R) {// ���ֵ����L == R

			mid = L + ((R - L) >> 1);

			if (arr[mid] > value) {
				R = mid - 1;
			} else if (arr[mid] < value) {
				L = mid + 1;
			} else {// ����
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
			// �����ǲ�Խ�磬����ǰһ��ֵ���ں�һ��ֵ
			for (int j = i; j - 1 >= 0 && arr[j] > arr[j - 1]; j--) {
				swap(arr, j - 1, j);
			}
		}

	}

}
