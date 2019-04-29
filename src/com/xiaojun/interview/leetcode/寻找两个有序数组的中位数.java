package com.xiaojun.interview.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * leetcode 4
 * <p>
 * 
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3] nums2 = [2]
 * 
 * 则中位数是 2.0 示例 2:
 * 
 * nums1 = [1, 2] nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * @author xiaojun
 *
 */
public class 寻找两个有序数组的中位数 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return 0;
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++) {
			list.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			list.add(nums2[i]);
		}
		Collections.sort(list);

		double m = 0;
		if (list.isEmpty()) {
			return m;
		}
		if (list.size() % 2 == 0) {
			int start = list.size() / 2 - 1;
			int end = Math.min(list.size() / 2, list.size() - 1);
			m = (list.get(start) + list.get(end)) * 1.0 / 2;
		} else {
			m = list.get(list.size() / 2);
		}
		return m;
	}
}
