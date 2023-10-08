package com.dp;
/*
1458. Max Dot Product of Two Subsequences

Given two arrays nums1 and nums2.

Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.

A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of
the characters without disturbing the relative positions of the remaining characters. (ie, [2,3,5] is a subsequence
of [1,2,3,4,5] while [1,5,3] is not).



Example 1:

Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
Output: 18
Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
Their dot product is (2*3 + (-2)*(-6)) = 18.

TC : o(m*n)
for every state (i,j) -> computed only onces
SC : o(m*n)
 */
public class MaxDotProductOfTwoSubsequences {

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,1,-2,5}, nums2 = new int[]{3,0,-6};
        System.out.println(new MaxDotProductOfTwoSubsequences().maxDotProduct(nums1,nums2));
    }
    int[][] memo;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num: nums1) {
            firstMax = Math.max(firstMax, num);
            firstMin = Math.min(firstMin, num);
        }

        for (int num: nums2) {
            secondMax = Math.max(secondMax, num);
            secondMin = Math.min(secondMin, num);
        }

        if (firstMax < 0 && secondMin > 0) {
            return firstMax * secondMin;
        }

        if (firstMin > 0 && secondMax < 0) {
            return firstMin * secondMax;
        }

        memo = new int[nums1.length][nums2.length];
        return dp(0, 0, nums1, nums2);
    }

    public int dp(int i, int j, int[] nums1, int[] nums2) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        /*
        there are two choices:
        1. consider i  and jth element and go for i+1, j+1
        2. consider current j with i+1
        3. consider current i with j+1
        among this, take the max
         */
        int use = nums1[i] * nums2[j] + dp(i + 1, j + 1, nums1, nums2);

        memo[i][j] = Math.max(use, Math.max(dp(i + 1, j, nums1, nums2), dp(i, j + 1, nums1, nums2)));

        return memo[i][j];
    }
}
