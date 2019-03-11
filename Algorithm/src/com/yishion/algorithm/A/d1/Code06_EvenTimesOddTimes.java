package com.yishion.algorithm.A.d1;

public class Code06_EvenTimesOddTimes {

	// 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到这一个数
	private static void printOddTimesNum(int[] arr) {
		int e0 = 0;
		for (int i = 0; i < arr.length; i++) {
			e0 ^= arr[i];// 异或运算
		}
		System.out.println(e0);
	}

	// 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两个数

	private static void printOddTimesNum2(int[] arr) {
		// 得到这两个数的异或的数值
		int e0 = 0;
		for (int i = 0; i < arr.length; i++) {
			e0 ^= arr[i];
		}

		// 两个数不相等，肯定某个位置是1和0，找到这个位置
		int rightOne = e0 & (~e0 + 1);// 获得e0位置最右边的数值1，其余都是0
		int a = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & rightOne) == rightOne) {
				a ^= arr[i];
			}
		}
		int b = a ^ e0;
		System.out.println("a : " + a + " b: " + b);
	}

	public static void main(String[] args) {
		int[] arr = { 2, 2, 2, 9, 9 };
		printOddTimesNum(arr);
		
		int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
		printOddTimesNum2(arr2);
		
	}

	
	
	
	
	
	
	
	
	
	
}
