package com.dp;

import java.util.HashMap;
import java.util.Map;

/*
1027. Longest Arithmetic Subsequence

Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.

Recall that a subsequence of an array nums is a list nums[i1], nums[i2], ..., nums[ik] with
0 <= i1 < i2 < ... < ik <= nums.length - 1, and that a sequence seq is arithmetic if
seq[i+1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).

Example 1:

Input: nums = [3,6,9,12]
Output: 4
Explanation:
The whole array is an arithmetic sequence with steps of length = 3.

TC : o(n^2)
SC : o(n^2)
 */
public class LongestArithmeticSubsequence {

    public static void main(String[] args) {
        int[]  nums = new int[]{
                9,4,7,2,10
        };
        System.out.println(new LongestArithmeticSubsequence().longestArithSeqLength(nums));
    }
    public int longestArithSeqLength(int[] nums) {
        int res =2, n = nums.length;

        Map<Integer,Integer>[] dp = new HashMap[n];

        for(int i=0;i<n;i++){
            dp[i] = new HashMap<Integer,Integer>();

            for(int j=0;j<i;j++){
                int dif = nums[i] - nums[j];

                dp[i].put(dif, dp[j].getOrDefault(dif,1)+1);
                res = Math.max(res, dp[i].get(dif));
            }
        }
        return res;
    }
}
