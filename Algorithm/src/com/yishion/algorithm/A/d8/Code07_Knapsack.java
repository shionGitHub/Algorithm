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
		// 要i号货物
		int res = Math.max(
				knapsack(w, v, areadlyW + w[i], areadlyV + v[i], bag, i + 1),
				// 不要i好货物
				knapsack(w, v, areadlyW, areadlyV, bag, i + 1));
		return res;

	}

	public static void main(String[] args) {

		int[] weights = { 2, 3, 4, 5, 6 };// 重量
		int[] values = { 6, 7, 8, 9, 100 };// 价值

		int bag = 10;// 不超过这个重量，求最大的价值

		System.out.println(knapsack(weights, values, 0, 0, bag, 0));

	}

}
