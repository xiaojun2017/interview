package com.xiaojun.interview.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class LinkListClient {

	public static void main(String[] args) {
		Node head = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(3);
		Node node7 = new Node(3);

		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;

		Node node = head;
		LinkedList link = new LinkedList();
		link.print(node);

		// node = link.deleteNode(head, head);
		// link.print(node);
		//
		// node = link.deleteValue1(head, 3);
		// link.print(node);

//		node = link.deleteValue3(head, 0);
//		link.print(node);
		
		node =link.filterNode(head);
		link.print(node);
	}

	public static class LinkedList {
		public void print(Node head) {
			if (head == null) {
				System.out.println("node is null;");
				return;
			}
			while (head.next != null) {
				System.out.print(head + "->");
				head = head.next;
			}
			System.out.print(head);
			System.out.println();
		}

		public Node deleteNode1(Node head, Node node) {
			return head;
		}

		/**
		 * 删除链表中指定节点
		 * 
		 * @param head
		 * @param node
		 * @return
		 */
		public Node deleteNode(Node head, Node node) {
			// 1,判断节点是否是尾节点, 找到尾节点的前一节点
			if (node.next == null) {
				while (head.next != node) {
					head = head.next;
				}
				head.next = null;
			}
			// 2,判断节点是头节点
			else if (head == node) {
				head = node.next;
			}
			// 3,即不是根节点，也不是尾节点
			else {
				Node q = node.next;
				node.data = q.data;
				node.next = q.next;
			}
			return head;
		}

		/**
		 * 删除链表中某个数字的节点
		 * <p>
		 * 方法1：利用stack把不需要删除的节点保存，再遍历stack组成新的链表
		 * 
		 * @param head
		 * @param num
		 * @return
		 */
		public Node deleteValue1(Node head, int num) {
			// 1,将不等于Num的节点压入stack
			Stack<Node> stack = new Stack<>();
			while (head != null) {
				if (head.data != num) {
					stack.push(head);
				}
				head = head.next;
			}

			// 2,遍历stack组成新的链表
			while (!stack.isEmpty()) {
				stack.peek().next = head;
				head = stack.pop();
			}
			return head;
		}

		/**
		 * 删除链表中某个数字的节点
		 * <p>
		 * 方法2：不用stack, 先找到第一个不等于num的节点作为头节点，再从该节点开始遍历
		 * 
		 * @param head
		 * @param num
		 * @return
		 */
		public Node deleteValue2(Node head, int num) {
			// 1,找到第一个不等于num的节点
			while (head != null) {
				if (head.data != num) {
					break;
				}
				head = head.next;
			}

			// 2,从该节点继续遍历链表
			Node pre = head;
			Node cur = head;
			while (cur != null) {
				if (cur.data == num) {
					pre.next = cur.next;
				} else {
					pre = cur;
				}
				cur = cur.next;
			}
			return head;
		}

		/**
		 * 删除链表中某个数字的节点
		 * <p>
		 * 方法3：遍历data等于Num的节点，然后调用deleteNode
		 * 
		 * @param head
		 * @param num
		 * @return
		 */
		public Node deleteValue3(Node head, int num) {
			// 1,遍历找到第一个节点
			Node cur = head;
			while (cur != null) {
				if (cur.data == num) {
					head = deleteNode(head, cur);
				}
				cur = cur.next;
			}
			return head;
		}
		
		/**
		 * 去除链表中重复的节点
		 * 
		 * @param head
		 * @return
		 */
		public Node filterNode(Node head) {
			Stack<Node> stack = new Stack<>();
			while (head != null) {
				if (!contains(stack, head.data)) {
					stack.push(head);
				}
				head = head.next;
			}
			while(!stack.isEmpty()) {
				stack.peek().next = head;
				head = stack.pop();
			}
			return head;
		}

		private boolean contains(Stack<Node> stack, int data) {
			for (Node node : stack) {
				if (node.data == data) {
					return true;
				}
			}
			return false;
		}
	}
}
