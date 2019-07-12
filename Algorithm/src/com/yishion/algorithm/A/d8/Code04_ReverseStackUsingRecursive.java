package com.yishion.algorithm.A.d8;

import java.util.Stack;

public class Code04_ReverseStackUsingRecursive {

	private static void reverse(Stack<Integer> stack) {

		if (stack.isEmpty()) {
			return;
		} else {
			int i = getAndRemoveLastElement(stack);// 这里要保证是最底层的元素
			reverse(stack);
			stack.push(i);
		}

	}

	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int ii = stack.pop();
		if (stack.isEmpty()) {
			return ii;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(ii);
			return last;
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		reverse(stack);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

}
