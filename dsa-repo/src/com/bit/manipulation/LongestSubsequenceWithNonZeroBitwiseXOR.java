package com.bit.manipulation;
/*
3702. Longest Subsequence With Non-Zero Bitwise XOR

You are given an integer array nums.

Return the length of the longest subsequence in nums whose bitwise XOR is non-zero. If no such subsequence exists, return 0.



Example 1:

Input: nums = [1,2,3]

Output: 2

Explanation:

One longest subsequence is [2, 3]. The bitwise XOR is computed as 2 XOR 3 = 1, which is non-zero.

TC : o(n)
SC: o(1)
 */
public class LongestSubsequenceWithNonZeroBitwiseXOR {

    public static void main(String[] args) {
        System.out.println(new LongestSubsequenceWithNonZeroBitwiseXOR().longestSubsequence(
                new int[]{1,2,3}
        ));
    }
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int totalXor = 0;
        boolean allZero = true;

        for (int x : nums) {
            totalXor ^= x;
            if (x > 0) {
                allZero = false;
            }
        }
        if (totalXor > 0) {
            return n;
        }

        return allZero ? 0 : n - 1;
    }
}
