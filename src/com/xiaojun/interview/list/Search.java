package com.xiaojun.interview.list;

public class Search {

	public static void main(String[] args) {
		int a[] = { 1, 3, 5, 6, 8, 9, 10 };
		int k = binarySearch(a, 5);
		System.out.println(k);

		Integer A = 1;
		Integer B = 1;

		Integer C = 129;
		Integer D = 129;

		System.out.println((A == B) + "  " + (C == D));

		System.out.println(A.hashCode() + "  " + B.hashCode());
		System.out.println(C.hashCode() + "  " + D.hashCode());
	}

	private static int binarySearch(int[] a, int k) {
		int low = 0;
		int high = a.length - 1;
		while (low < high) {
			int m = (low + high) >> 1;
			if (k > a[m]) {
				low = m + 1;
			} else if (k < a[m]) {
				high = m - 1;
			} else {
				return m;
			}
		}

		return 0;
	}
}
