package com.yishion.algorithm.A.d8;

public class Code08_CardsInLine {

	private static int f(int[] arr, int L, int R) {

		if (L == R) {
			return arr[L];
		}

		int l = arr[L];

		if (L + 2 == R) {
			l += 0;
		} else {
			if (L + 2 < R) {
				l += Math.min(f(arr, L + 2, R), f(arr, L + 1, R - 1));
			}
		}

		int r = arr[R];

		if (L + 2 == R) {
			r += 0;
		} else {
			if (L + 2 < R) {
				r += Math.min(f(arr, L, R - 2), f(arr, L + 1, R - 1));
			}
		}

		return Math.max(l, r);

	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 100, 4 };
		System.out.println(f(arr, 0, 3));

	}

}
