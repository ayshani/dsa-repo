package com.array;

import java.util.HashSet;
import java.util.Set;

/*

287. Find the Duplicate Number

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
 */
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,3,4,2};
        System.out.println(new FindTheDuplicateNumber().findDuplicate(nums));
    }
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(!set.add(num))
                return num;
        }

        return -1;
    }
}
