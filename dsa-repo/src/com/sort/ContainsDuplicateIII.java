package com.sort;

import java.util.TreeSet;

/*
220. Contains Duplicate III

You are given an integer array nums and two integers indexDiff and valueDiff.

Find a pair of indices (i, j) such that:

i != j,
abs(i - j) <= indexDiff.
abs(nums[i] - nums[j]) <= valueDiff, and
Return true if such pair exists or false otherwise.

Example 1:

Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
Output: true
Explanation: We can choose (i, j) = (0, 3).
We satisfy the three conditions:
i != j --> 0 != 3
abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0

TC: O(n * logk)
SC: O(k)
 */
public class ContainsDuplicateIII {

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,9,1,5,9};
        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(nums,2,3));
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();

        for(int i=0;i<nums.length;i++){
            Long num = 1L * nums[i];
            Long floorNum = set.floor(num);
            Long ceilNum = set.ceiling(num);

            if(floorNum!=null && Math.abs(floorNum- num) <=valueDiff){
                return true;
            }
            if(ceilNum!=null && Math.abs(ceilNum - num) <= valueDiff) {
                return true;
            }

            set.add(num);
            if(set.size()>indexDiff){
                set.remove(1L * nums[i-indexDiff]);
            }

        }

        return false;
    }
}
