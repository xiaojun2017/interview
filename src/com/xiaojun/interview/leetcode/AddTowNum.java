package com.xiaojun.interview.leetcode;

/**
 * leetcode 2
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * 
 * @author xiaojun
 */
public class AddTowNum {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node = null;
		ListNode head = null;

		int m = 0;
		while (l1 != null || l2 != null) {
			int val1 = 0;
			int val2 = 0;
			if (l1 != null) {
				val1 = l1.val;
			}
			if (l2 != null) {
				val2 = l2.val;
			}

			int sum = val1 + val2 + m;
			int value = sum % 10;
			m = sum / 10;

			ListNode tem = new ListNode(value);
			if (head == null) {
				head = tem;
			}
			if (node != null) {
				node.next = tem;
				node = node.next;
			} else {
				node = tem;
			}
			System.out.print(node.val);
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (m == 1) {
			node.next = new ListNode(1);
		}
		return head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
