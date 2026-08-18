package com.array;
/*
3471. Find the Largest Almost Missing Integer

You are given an integer array nums and an integer k.

An integer x is almost missing from nums if x appears in exactly one subarray of size k within nums.

Return the largest almost missing integer from nums. If no such integer exists, return -1.

A subarray is a contiguous sequence of elements within an array.


Example 1:

Input: nums = [3,9,2,1,7], k = 3

Output: 7

Explanation:

1 appears in 2 subarrays of size 3: [9, 2, 1] and [2, 1, 7].
2 appears in 3 subarrays of size 3: [3, 9, 2], [9, 2, 1], [2, 1, 7].
3 appears in 1 subarray of size 3: [3, 9, 2].
7 appears in 1 subarray of size 3: [2, 1, 7].
9 appears in 2 subarrays of size 3: [3, 9, 2], and [9, 2, 1].
We return 7 since it is the largest integer that appears in exactly one subarray of size k.

TC : o(n)
SC : o(1)
 */
public class FindTheLargestAlmostMissingInteger {

    public static void main(String[] args) {
        System.out.println(new FindTheLargestAlmostMissingInteger().largestInteger(new int[]{3,9,2,1,7}, 3));
    }
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        if (n == k) {
            int res = nums[0];
            for (int x : nums) {
                res = Math.max(res, x);
            }
            return res;
        }
        int[] count = new int[51];
        for (int x : nums) {
            count[x]++;
        }
        if (k == 1) {
            for (int i = 50; i >= 0; --i) {
                if (count[i] == 1) {
                    return i;
                }
            }
            return -1;
        }
        int res = -1;
        if (count[nums[0]] == 1) {
            res = Math.max(res, nums[0]);
        }
        if (count[nums[n - 1]] == 1) {
            res = Math.max(res, nums[n - 1]);
        }
        return res;
    }
}
