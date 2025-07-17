package com.dp;
/*
3202. Find the Maximum Length of Valid Subsequence II

You are given an integer array nums and a positive integer k.
A subsequence sub of nums with length x is called valid if it satisfies:

(sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k.
Return the length of the longest valid subsequence of nums.


Example 1:

Input: nums = [1,2,3,4,5], k = 2

Output: 5

Explanation:

The longest valid subsequence is [1, 2, 3, 4, 5].


TC : o(k^2 + n*k)
SC : o(k^2)
 */
public class FindTheMaximumLengthOfValidSubsequenceII {

    public static void main(String[] args) {
        System.out.println(new FindTheMaximumLengthOfValidSubsequenceII().maximumLength(new int[]{1,2,3,4,5}, 2));
    }
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int res = 0;
        for (int num : nums) {
            num %= k;
            for (int prev = 0; prev < k; prev++) {
                dp[prev][num] = dp[num][prev] + 1;
                res = Math.max(res, dp[prev][num]);
            }
        }
        return res;
    }
}
