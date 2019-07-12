package com.yishion.algorithm.A.d8;

import java.util.ArrayList;
import java.util.List;

public class Code03_PrintAllPermutations {

	private static void process(List<String> list, String preStr) {

		if (list.size() == 0) {
			System.out.println(preStr);
			return;
		}

		for (int i = 0; i < list.size(); i++) {

			String ch = list.get(i);// 选出一个字符，从0~~i-1都走一遍

			List<String> copyList = new ArrayList<>(list);
			copyList.remove(i);// 复制的集合删除当前的位置的字符

			process(copyList, preStr + ch);

		}

	}

	public static void main(String[] args) {
		String str = "abc";

		List<String> list = new ArrayList<>();

		for (int i = 0; i < str.length(); i++) {
			list.add(String.valueOf(str.charAt(i)));
		}

		process(list, "");
	}

}
