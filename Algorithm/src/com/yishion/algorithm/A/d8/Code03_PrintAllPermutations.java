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

			String ch = list.get(i);// ѡ��һ���ַ�����0~~i-1����һ��

			List<String> copyList = new ArrayList<>(list);
			copyList.remove(i);// ���Ƶļ���ɾ����ǰ��λ�õ��ַ�

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
