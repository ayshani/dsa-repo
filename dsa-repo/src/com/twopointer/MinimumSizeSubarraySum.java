package com.twopointer;
/*
209. Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous
subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no
such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1

Intuition

Until now, we have kept the starting index of subarray fixed, and found the last position. Instead, we could move
the starting index of the current subarray as soon as we know that no better could be done with this index as the
starting index. We could keep 2 pointer,one for the start and another for the end of the current subarray,
and make optimal moves so as to keep the sum greater than target as well as maintain the lowest size possible.

TC : o(n)
SC : o(1)
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int target = 7;

        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(target,nums));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        int left =0, sum =0;
        for(int i=0;i<n;i++){
            sum+= nums[i];
            while(sum>=target){
                ans =  Math.min(ans, i-left+1);
                sum-=nums[left++];
            }
        }
        return ans!= Integer.MAX_VALUE ? ans : 0;
    }
}
