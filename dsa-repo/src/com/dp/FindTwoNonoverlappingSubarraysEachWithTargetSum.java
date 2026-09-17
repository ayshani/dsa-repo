package com.dp;

import java.util.Arrays;

/*
1477. Find Two Non-overlapping Sub-arrays Each With Target Sum

You are given an array of integers arr and an integer target.

You have to find two non-overlapping sub-arrays of arr each with a sum equal target. There can be multiple answers so you have to find an answer where the sum of the lengths of the two sub-arrays is minimum.

Return the minimum sum of the lengths of the two required sub-arrays, or return -1 if you cannot find such two sub-arrays.



Example 1:

Input: arr = [3,2,2,4,3], target = 3
Output: 2
Explanation: Only two sub-arrays have sum = 3 ([3] and [3]). The sum of their lengths is 2.

TC : o(n)
SC: o(n)
 */
public class FindTwoNonoverlappingSubarraysEachWithTargetSum {

    public static void main(String[] args) {
        System.out.println(new FindTwoNonoverlappingSubarraysEachWithTargetSum().minSumOfLengths(
                new int[]{3,2,2,4,3}, 3
        ));
    }
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length,
                ans = n + 1,
                sum = 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        for (int l = 0, r = 0; r < n; r++) {
            sum += arr[r];
            while (sum > target) sum -= arr[l++];
            dp[r + 1] = dp[r];
            if (sum == target) {
                ans = Math.min(ans, r - l + 1 + dp[l]);
                dp[r + 1] = Math.min(dp[r], r - l + 1);
            }
        }
        return ans == n + 1 ? -1 : ans;
    }
}
