package com.yishion.algorithm.A.d8;

public class Code01_Hanoi {

	public static void func(int N, String from, String to, String other) {
		if (N < 1) {
			return;
		} else {
			// 先把1~N-1个圆盘移到 左--->中
			func(N - 1, from, other, to);
			System.out.println("将第" + N + "个圆盘从: " + from + " 移动到: " + to);
			func(N - 1, other, to, from);
		}

	}

	public static void main(String[] args) {
		func(3, "左", "右", "中");
	}

}
