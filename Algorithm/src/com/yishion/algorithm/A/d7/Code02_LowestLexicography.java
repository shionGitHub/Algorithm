package com.yishion.algorithm.A.d7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Code02_LowestLexicography {

	public static class MyComparator implements Comparator<String> {

		@Override
		public int compare(String a, String b) {
			return (a + b).compareTo(b + a);
		}

	}

	public static String lowestLexicography(String[] arr) {
		if (arr == null) {
			return "";
		}

		Arrays.sort(arr, new MyComparator());
		String res = "";
		for (int i = 0; i < arr.length; i++) {
			res += arr[i];
		}
		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {

		String[] strs1 = { "jibw", "xyu", "jp", "bw", "123" };
		// 第一种解法暴力解
		ArrayList<String> list = new ArrayList<>();
		printA(Arrays.asList(strs1), "", list);
		Collections.sort(list);
		String s = list.get(0);
		System.out.println(s);

		// 脑补出的一个贪心策略， 使用对数器验证他是对的
		lowestLexicography(strs1);

		// String[] strs2 = { "ba", "b" };

	}

	private static void printA(List<String> list, String str,
			ArrayList<String> demoList) {
		if (list.size() == 0) {
			// System.out.println(str);
			demoList.add(str);
			return;
		}
		StringBuffer sb = new StringBuffer();
		// ----------------------------------1
		for (int i = 0; i < list.size(); i++) {
			sb.setLength(0);
			ArrayList<String> arrayList = new ArrayList<>(list);// 每一次循环复制一份
			String currString = arrayList.remove(i);// 拿出当前的
			sb.append(str);// 拼接原来的字符串
			sb.append(currString);// 拼接当前
			printA(arrayList, sb.toString(), demoList);
		}

	}

}
