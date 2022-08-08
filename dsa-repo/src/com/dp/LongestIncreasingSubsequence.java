package com.dp;
/*
300. Longest Increasing Subsequence

Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements
without changing the order of the remaining elements.
For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Logic
-------
Basic DP problem of LIS.
have one dp[] array. iterate over all element and check from the beginning of array to that element
how many smaller numbers are there and count it.

TC : o(n^2)
SC : o(n)
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];

        lis[0]=1;
        for(int i=1;i<n;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    lis[i]=Math.max(lis[i],lis[j]+1);
                }
            }
        }

        int res =lis[0];
        for(int i=1;i<n;i++){
            res = Math.max(res,lis[i]);
        }

        return res;
    }
}
