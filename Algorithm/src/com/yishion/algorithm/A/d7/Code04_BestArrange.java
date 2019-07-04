package com.yishion.algorithm.A.d7;

import java.util.Arrays;
import java.util.Comparator;

public class Code04_BestArrange {

	public static class Program {
		public int start;
		public int end;

		public Program(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static class ProgramComparator implements Comparator<Program> {

		@Override
		public int compare(Program o1, Program o2) {
			return o1.end - o2.end;
		}

	}

	public static int bestArrange(Program[] programs, int start) {
		Arrays.sort(programs, new ProgramComparator());
		int result = 0;
		// 按结束时间从小到大排序
		for (int i = 0; i < programs.length; i++) {
			if (programs[i].start > start) {// 项目开始时间在当前时间的以后
				result++;
				start = programs[i].end;// 以当前项目的结束时间为下个项目的参考
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
