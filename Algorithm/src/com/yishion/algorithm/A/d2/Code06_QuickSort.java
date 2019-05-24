package com.yishion.algorithm.A.d2;

import com.yishion.algorithm.Common;

public class Code06_QuickSort extends Common {

	public static void main(String[] args) {
		int[] arr = generationArray(6, 0, 200);
		printArr(arr);
		quickSort(arr, 0, arr.length - 1);
		printArr(arr);
	}

	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			int[] p = partition(arr, l, r);
			quickSort(arr, l, p[0] - 1);// 排小于区
			quickSort(arr, p[1] + 1, r);// 排大于区
		}

	}

	// partition外排序的过程
	private static int[] partition(int[] arr, int l, int r) {

		int less = l - 1;// 小于区的边界
		int more = r;// 大于区的边界
		int p = arr[r];// 以最后一个数组的值作为划分值
		int index = l;// 当前的下标

		while (index < more) {
			if (arr[index] > p) {// 如果当前值大于划分值p
				// 当前数和大于区前一个数交换,more左移一位,index位置不变
				swap(arr, index, --more);
			} else if (arr[index] == p) {// 如果当前值等于划分值p
				// 当前数直接跳下一个
				index++;
			} else {// 如果当前值小于划分值p
				// 当前数和小于区前一个位置交换,less右移一位,index向右移动一位
				swap(arr, index++, ++less);
			}
		}
		// 这个时候除了最后一位没有处理其他的都处理了，最后一位是划分值和大于区第一个数交换即是等于区
		swap(arr, more, r);
		// 返回的等于区[]
		return new int[] { less + 1, more };
	}

}
