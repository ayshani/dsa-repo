package com.array;
/*
3392. Count Subarrays of Length Three With a Condition

Given an integer array nums, return the number of subarrays of length 3 such that the sum of the first and third numbers equals exactly half of the second number.



Example 1:

Input: nums = [1,2,1,4,1]

Output: 1

Explanation:

Only the subarray [1,4,1] contains exactly 3 elements where the sum of the first and third numbers equals half the middle number.

TC : o(n)
SC: o(1)
 */
public class CountSubarraysOfLengthThreeWithACondition {

    public static void main(String[] args) {
        System.out.println(new CountSubarraysOfLengthThreeWithACondition().countSubarrays(
                new int[]{1,2,1,4,1}
        ));
    }
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i < n - 1; ++i) {
            if (nums[i] == (nums[i - 1] + nums[i + 1]) * 2) {
                ++ans;
            }
        }
        return ans;
    }
}
