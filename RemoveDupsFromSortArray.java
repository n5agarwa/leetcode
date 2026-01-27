package com.leetcode.easy;


public class RemoveDupsFromSortArray {

	public int removeDuplicates(int[] nums) {
		int counter = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[counter]) {
				nums[++counter] = nums[j];
			}
		}
		return counter + 1;
	}
}
