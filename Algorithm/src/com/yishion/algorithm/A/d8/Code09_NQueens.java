package com.yishion.algorithm.A.d8;

public class Code09_NQueens {

	private static int queen(int N) {
		if (N <= 0) {
			return 0;
		}

		int[] queen = new int[N];// 索引下标代表是行值，值代表是列值
		return process(queen, 0);
	}

	private static int process(int[] queen, int line) {
		if (line == queen.length) {
			return 1;
		}
		int res = 0;
		for (int j = 0; j < queen.length; j++) {
			if (isVaildQueen(queen, line, j)) {
				res += process(queen, line + 1);
			}
		}

		return res;
	}

	private static boolean isVaildQueen(int[] queen, int line, int comlun) {

		for (int i = 0; i < line; i++) {

			int x1 = i;
			int y1 = queen[i];

			int x2 = line;
			int y2 = comlun;
			if ((x1 == x2) || (y1 == y2)
					|| Math.abs(x2 - x1) == Math.abs(y2 - y1)) {
				return false;
			}
		}
		queen[line] = comlun;
		return true;
	}

	public static void main(String[] args) {
		// System.out.println(queen(1));
		// System.out.println(queen(2));
		// System.out.println(queen(3));
		// System.out.println(queen(8));

		System.out.println(queen_1(8));
	}

	private static int queen_1(int N) {

		int limit = N < 32 ? ((1 << N) - 1) : -1;

		return process_1(limit, 0, 0, 0);
	}

	private static int process_1(int limit, int c, int l, int r) {

		if (c == limit) {
			return 1;
		}
		
		int pos = limit & (~(c | l | r));

		int res = 0;

		while (pos != 0) {// 从-------->第1个位置-------->第8个位置

			int mostRightOne = pos & (~pos + 1);

			pos = pos - mostRightOne;

			res += process_1(limit, c | mostRightOne, (l | mostRightOne) << 1,
					(r | mostRightOne) >>> 1);

		}

		return res;
	}

	private static void toBinaryString(int pos) {
		System.out.println(Integer.toBinaryString(pos));
	}

}
