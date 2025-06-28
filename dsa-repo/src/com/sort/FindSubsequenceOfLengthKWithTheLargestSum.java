package com.sort;

import java.util.Arrays;

/*
2099. Find Subsequence of Length K With the Largest Sum

You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: nums = [2,1,3,3], k = 2
Output: [3,3]
Explanation:
The subsequence has the largest sum of 3 + 3 = 6.

TC : o(nlogn)
SC; o(n)
 */
public class FindSubsequenceOfLengthKWithTheLargestSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindSubsequenceOfLengthKWithTheLargestSum().maxSubsequence(
                new int[]{2,1,3,3}, 2
        )));
    }
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] vals = new int[n][2]; // two-dimensional array stores index and value
        for (int i = 0; i < n; ++i) {
            vals[i][0] = i; // store index
            vals[i][1] = nums[i]; // store value
        }
        // sort by numerical value in descending order
        Arrays.sort(vals, (x1, x2) -> Integer.compare(x2[1], x1[1]));
        // select the first k elements and sort them in ascending order by index
        Arrays.sort(vals, 0, k, (x1, x2) -> Integer.compare(x1[0], x2[0]));
        int[] res = new int[k]; // target subsequence
        for (int i = 0; i < k; ++i) {
            res[i] = vals[i][1];
        }
        return res;
    }

}
