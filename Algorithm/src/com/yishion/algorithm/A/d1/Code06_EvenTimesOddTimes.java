package com.yishion.algorithm.A.d1;

public class Code06_EvenTimesOddTimes {

	// һ����������һ���������������Σ���������������ż���Σ���ô�ҵ���һ����
	private static void printOddTimesNum(int[] arr) {
		int e0 = 0;
		for (int i = 0; i < arr.length; i++) {
			e0 ^= arr[i];// �������
		}
		System.out.println(e0);
	}

	// һ���������������������������Σ���������������ż���Σ���ô�ҵ���������

	private static void printOddTimesNum2(int[] arr) {
		// �õ�����������������ֵ
		int e0 = 0;
		for (int i = 0; i < arr.length; i++) {
			e0 ^= arr[i];
		}

		// ����������ȣ��϶�ĳ��λ����1��0���ҵ����λ��
		int rightOne = e0 & (~e0 + 1);// ���e0λ�����ұߵ���ֵ1�����඼��0
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
