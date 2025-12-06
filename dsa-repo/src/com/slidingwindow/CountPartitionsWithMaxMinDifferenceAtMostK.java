package com.slidingwindow;

import java.util.TreeMap;

/*
3578. Count Partitions With Max-Min Difference at Most K

You are given an integer array nums and an integer k. Your task is to partition nums into one or more non-empty contiguous segments such that in each segment, the difference between its maximum and minimum elements is at most k.

Return the total number of ways to partition nums under this condition.

Since the answer may be too large, return it modulo 109 + 7.



Example 1:

Input: nums = [9,4,1,3,7], k = 4

Output: 6

Explanation:

There are 6 valid partitions where the difference between the maximum and minimum elements in each segment is at most k = 4:

[[9], [4], [1], [3], [7]]
[[9], [4], [1], [3, 7]]
[[9], [4], [1, 3], [7]]
[[9], [4, 1], [3], [7]]
[[9], [4, 1], [3, 7]]
[[9], [4, 1, 3], [7]]

TC : o(nlogn)
SC: o(n)
 */
public class CountPartitionsWithMaxMinDifferenceAtMostK {

    public static void main(String[] args) {
        System.out.println(new CountPartitionsWithMaxMinDifferenceAtMostK().countPartitions(
                new int[]{9,4,1,3,7}, 4
        ));
    }
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long mod = (long) 1e9 + 7;
        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];
        TreeMap<Integer, Integer> cnt = new TreeMap<>();

        dp[0] = 1;
        prefix[0] = 1;
        for (int i = 0, j = 0; i < n; i++) {
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            // adjust window
            while (j <= i && cnt.lastKey() - cnt.firstKey() > k) {
                cnt.put(nums[j], cnt.get(nums[j]) - 1);
                if (cnt.get(nums[j]) == 0) {
                    cnt.remove(nums[j]);
                }
                j++;
            }

            dp[i + 1] = (prefix[i] - (j > 0 ? prefix[j - 1] : 0) + mod) % mod;
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % mod;
        }

        return (int) dp[n];
    }
}
