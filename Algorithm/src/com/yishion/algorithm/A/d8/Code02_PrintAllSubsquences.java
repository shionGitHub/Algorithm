package com.yishion.algorithm.A.d8;

public class Code02_PrintAllSubsquences {

	private static void process(char[] chs, int i, String preStr) {
		if (i >= chs.length) {
			System.out.println(preStr);
			return;
		}

		char c = chs[i];// 取出当前的字符
		process(chs, i + 1, preStr + c);
		process(chs, i + 1, preStr);

	}

	public static void main(String[] args) {

		String str = "abc";
		char[] chs = str.toCharArray();
		process(chs, 0, "");

	}

}
