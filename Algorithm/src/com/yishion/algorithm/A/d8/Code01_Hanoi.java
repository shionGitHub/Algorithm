package com.yishion.algorithm.A.d8;

public class Code01_Hanoi {

	public static void func(int N, String from, String to, String other) {
		if (N < 1) {
			return;
		} else {
			// �Ȱ�1~N-1��Բ���Ƶ� ��--->��
			func(N - 1, from, other, to);
			System.out.println("����" + N + "��Բ�̴�: " + from + " �ƶ���: " + to);
			func(N - 1, other, to, from);
		}

	}

	public static void main(String[] args) {
		func(3, "��", "��", "��");
	}

}
