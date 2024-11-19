package com.slidingwindow;

import java.util.HashMap;

/*
2461. Maximum Sum of Distinct Subarrays With Length K

You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions

TC : o(n)
SC: o(n)
 */
public class MaximumSumOfDistinctSubarraysWithLengthK {

    public static void main(String[] args) {
        System.out.println(new MaximumSumOfDistinctSubarraysWithLengthK().maximumSubarraySum(
                new int[]{1,5,4,2,9,9,9}, 3
        ));
    }
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long currentSum = 0;
        int begin = 0;
        int end = 0;

        HashMap<Integer, Integer> numToIndex = new HashMap<>();

        while (end < nums.length) {
            int currNum = nums[end];
            int lastOccurrence = numToIndex.getOrDefault(currNum, -1);
            // if current window already has number or if window is too big, adjust window
            while (begin <= lastOccurrence || end - begin + 1 > k) {
                currentSum -= nums[begin];
                begin++;
            }
            numToIndex.put(currNum, end);
            currentSum += nums[end];
            if (end - begin + 1 == k) {
                ans = Math.max(ans, currentSum);
            }
            end++;
        }
        return ans;
    }
}
