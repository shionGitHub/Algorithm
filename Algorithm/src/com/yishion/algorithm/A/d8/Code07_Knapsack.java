package com.yishion.algorithm.A.d8;


public class Code07_Knapsack {

	private static int knapsack(int[] w, int[] v, int areadlyW, int areadlyV,
			int bag, int i) {

		if (areadlyW > bag) {
			return 0;
		}

		if (i == w.length) {
			return areadlyV;
		}
		// Ҫi�Ż���
		int res = Math.max(
				knapsack(w, v, areadlyW + w[i], areadlyV + v[i], bag, i + 1),
				// ��Ҫi�û���
				knapsack(w, v, areadlyW, areadlyV, bag, i + 1));
		return res;

	}

	public static void main(String[] args) {

		int[] weights = { 2, 3, 4, 5, 6 };// ����
		int[] values = { 6, 7, 8, 9, 100 };// ��ֵ

		int bag = 10;// ��������������������ļ�ֵ

		System.out.println(knapsack(weights, values, 0, 0, bag, 0));

	}

}
