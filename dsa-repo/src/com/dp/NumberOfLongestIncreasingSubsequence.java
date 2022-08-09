package com.dp;

import java.util.Arrays;

/*
673. Number of Longest Increasing Subsequence

Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.



Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of the longest increasing subsequence is 1,
and there are 5 increasing subsequences of length 1, so output 5.

TC : o(n^2)
SC : o(n)
 */
public class NumberOfLongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7};
        System.out.println(new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(nums));
    }
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, maxLen = 0;
        int[] dpL=new int[n];
        int[] dpC = new int[n];
        Arrays.fill(dpL,1);
        Arrays.fill(dpC,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dpL[i]<dpL[j]+1){
                        dpL[i]=dpL[j]+1;
                        dpC[i] = dpC[j];
                    } else if(dpL[i]==dpL[j]+1){
                        dpC[i]+=dpC[j];
                    }
                }
            }
            maxLen = Math.max(maxLen,dpL[i]);
        }

        int count =0;
        for(int i=0;i<n;i++){
            if(dpL[i]==maxLen)
                count+=dpC[i];
        }

        return count;
    }
}
