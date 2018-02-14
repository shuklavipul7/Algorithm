package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums1 = { 4, 1, 2 };
		int[] nums2 = { 1, 3, 4, 2 };

		int[] result = (solution.nextGreaterElement(nums1, nums2));
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		Map<Integer, Integer> map1 = new LinkedHashMap<>();

		for (int i = 0; i < nums2.length; i++) {
			map1.put(nums2[i], i);
		}

		for (int i = 0; i < nums1.length; i++) {
			if (map1.containsKey(nums1[i])) {
				int index = map1.get(nums1[i]);
				if (index == (nums2.length - 1)) {
					result[i] = -1;
				} else {
					for (int j = index + 1; j < nums2.length; j++) {
						if (nums2[j] > nums1[i]) {
							result[i] = nums2[j];
							break;
						} else {
							result[i] = -1;
						}
					}
				}
			}

		}
		return result;
	}
}