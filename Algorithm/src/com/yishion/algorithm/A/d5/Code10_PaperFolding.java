package com.yishion.algorithm.A.d5;

public class Code10_PaperFolding {

	public static void main(String[] args) {
		printProcess(1, 3, true);
	}

	private static void printProcess(int index, int N, boolean isUp) {
		if (index > N) {
			return;
		}

		printProcess(index + 1, N, true);
		System.out.println(isUp ? "°¼" : "Í¹");
		printProcess(index + 1, N, false);

	}

}
