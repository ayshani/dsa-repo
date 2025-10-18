package com.greedy;

import java.util.Arrays;

/*
3397. Maximum Number of Distinct Elements After Operations

You are given an integer array nums and an integer k.

You are allowed to perform the following operation on each element of the array at most once:

Add an integer in the range [-k, k] to the element.
Return the maximum possible number of distinct elements in nums after performing the operations.



Example 1:

Input: nums = [1,2,2,3,3,4], k = 2

Output: 6

Explanation:

nums changes to [-1, 0, 1, 2, 3, 4] after performing operations on the first four elements.

TC : o(nlogn)
SC: o(n)
 */
public class MaximumNumberOfDistinctElementsAfterOperations {

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfDistinctElementsAfterOperations().maxDistinctElements(
                new int[]{1,2,2,3,3,4}, 2
        ));
    }
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        int prev = Integer.MIN_VALUE;
        for (int num : nums) {
            int curr = Math.min(Math.max(num - k, prev + 1), num + k);
            if (curr > prev) {
                cnt++;
                prev = curr;
            }
        }
        return cnt;
    }
}
