package com.xiaojun.interview.list;

import java.util.Arrays;

public class Fablj {

	public static void main(String[] args) {
		System.out.println(f1(5));

		System.out.println(f2(5));

		System.out.println(f3(5));
	}

	public static int f1(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else {
			return f1(n - 1) + f1(n - 2);
		}
	}

	public static long f2(int n) {
		long a[] = new long[n + 1];
		a[0] = 1;
		a[1] = 1;
		for (int i = 2; i <= n; i++) {
			a[i] = a[i - 1] + a[i - 2];
		}
		return a[n];
	}

	public static int f3(int n) {
		int a0 = 1;
		int a1 = 1;
		int an = 0;
		for (int i = 2; i <= n; i++) {
			an = a1 + a0;
			a0 = a1;
			a1 = an;
		}
		return an;
	}
}
