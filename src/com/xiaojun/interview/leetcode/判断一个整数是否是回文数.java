package com.xiaojun.interview.leetcode;

import java.util.Stack;

public class 判断一个整数是否是回文数 {
	public static void main(String[] args) {
		int x = 121;
		boolean result = isPalindrome(x);
		System.out.println(result);
	}
	
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		String str = String.valueOf(x);
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			stack1.push(str.charAt(i));
			stack2.push(str.charAt(str.length() - i - 1));
		}
		while(!stack1.isEmpty()) {
			if (stack1.pop() != stack2.pop()) {
				return false;
			}
		}
		return true;
	}
}
