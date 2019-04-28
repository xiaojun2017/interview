package com.xiaojun.interview.list;

import java.util.Arrays;
import java.util.Stack;

public class Temprature {
	// int T[] = { 73, 74, 75, 71, 69, 72, 76, 73 };
	// int P[] = { 1 , 1, 4, 2, 1, 1, 0, 0 };

	public static void main(String[] args) {
		// int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
		// { 73, 72, 71, 74, 75, 71, 69, 72, 76, 73 };
		// { 3, 2, 1, 1, 4, 2, 1, 1, 0, 0}

		// int[] T = { 73, 72, 71, 74, 75, 71, 69, 72, 76, 73 };
		int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] P = findDays2(T);

		System.out.println(Arrays.toString(P));
	}

	private static int[] findDays(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < b.length; i++) {
			for (int j = i; j < b.length; j++) {
				if (a[i] < a[j]) {
					b[i] = j - i;
					break;
				}
			}
		}
		return b;
	}

	// { 73, 72, 71, 74, 75, 71, 69, 72, 76, 73 };
	// { 3, 2, 1, 1, 4, 2, 1, 1, 0, 0}
	private static int[] findDays2(int[] a) {
		int[] b = new int[a.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < b.length; i++) {
			while (!stack.isEmpty() && a[i] > a[stack.peek()]) {
				int t = stack.pop();
				b[t] = i - t;
			}
			stack.push(i);
		}
		return b;
	}

	/**
	 * i=0, stack=[] i=1, stack=[0], a[i]=74,a[stack.peek()]=73 t=0, i-t=1 b[0]=1
	 * i=2, stack=[1], a[i]=75,a[stack.peek()]=73 t=0, i-t=1 b[0]=1
	 */
}
