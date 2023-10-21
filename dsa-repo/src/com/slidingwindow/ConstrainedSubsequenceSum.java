package com.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/*
1425. Constrained Subsequence Sum

Given an integer array nums and an integer k,
return the maximum sum of a non-empty subsequence of that array such that for every two consecutive
integers in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.

A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array,
leaving the remaining elements in their original order.

Example 1:

Input: nums = [10,2,-10,5,20], k = 2
Output: 37
Explanation: The subsequence is [10, 2, 5, 20].

Logic
------
We need to get the max element in k latest elements in O(1) by using Decreasing Monotonic Queue.
similar to  239. Sliding Window Maximum problem.

TC : o(n)
SC: o(n)
 */
public class ConstrainedSubsequenceSum {

    public static void main(String[] args) {
        int[] nums = new int[]{10,2,-10,5,20};
        int k =2;
        System.out.println(new ConstrainedSubsequenceSum().constrainedSubsetSum(nums,k));
    }

    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        // max sum till now in ith in dp[]
        int[] dp = new int[n];

        Deque<Integer> dq = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int max = Math.max(0,!dq.isEmpty()? dp[dq.peekFirst()]: 0);
            dp[i] = nums[i] + max;
            ans = Math.max(ans,dp[i]);
            // If  dq[deque.peekLast()] <= dp[i] -> Can discard the tail since it's useless
            while(!dq.isEmpty() && dp[dq.peekLast()]<=dp[i])
                dq.pollLast();
            dq.addLast(i);
            // remove the last element of range k
            if((i - dq.peekFirst()+1) > k)
                dq.pollFirst();
        }

        return ans;
    }
}
