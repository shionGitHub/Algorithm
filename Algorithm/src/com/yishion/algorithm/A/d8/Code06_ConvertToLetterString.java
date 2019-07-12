package com.yishion.algorithm.A.d8;

public class Code06_ConvertToLetterString {

	private static int convertToletterString(char[] chs, int index) {
		int res = 0;
		if (index == chs.length) {
			return 1;
		}

		if (chs[index] == '0') {// 当前字符不能转化了
			return 0;
		}

		if (chs[index] == '1') {// 当前是1----一个----两个

			res += convertToletterString(chs, index + 1);

			if (index + 1 < chs.length) {
				res += convertToletterString(chs, index + 2);
			}

			return res;
		}

		if (chs[index] == '2') {
			res += convertToletterString(chs, index);
			if (index + 1 < chs.length && chs[index + 1] <= '6') {
				res += convertToletterString(chs, index + 2);
			}
			return res;
		}

		// 一个字符一个字符的转化的情况 chs[index] ='3'~'9'
		res += convertToletterString(chs, index + 1);

		return res;
	}

	public static void main(String[] args) {

		String i = "111";
		char[] ch = i.toCharArray();
		System.out.println(convertToletterString(ch, 0));
	}

}
