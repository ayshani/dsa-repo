package com.array;
/*
2750. Ways to Split Array Into Good Subarrays

You are given a binary array nums.

A subarray of an array is good if it contains exactly one element with the value 1.

Return an integer denoting the number of ways to split the array nums into good subarrays.
As the number may be too large, return it modulo 109 + 7.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [0,1,0,0,1]
Output: 3
Explanation: There are 3 ways to split nums into good subarrays:
- [0,1] [0,0,1]
- [0,1,0] [0,1]
- [0,1,0,0] [1]
Example 2:

Input: nums = [0,1,0]
Output: 1
Explanation: There is 1 way to split nums into good subarrays:
- [0,1,0]

TC : o(n)
SC: o(1)
 */
public class WaysToSplitArrayIntoGoodSubarrays {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,0,1};
        System.out.println(new WaysToSplitArrayIntoGoodSubarrays().numberOfGoodSubarraySplits(nums));
    }
    public int numberOfGoodSubarraySplits(int[] nums) {
        int minSubArray = 0, n = nums.length;
        long MOD = 1000000007;
        int prevIndex =-1;

        long count =1;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                if(prevIndex!=-1){
                    int diff = i - prevIndex;
                    count= (count*diff)%MOD;
                }
                prevIndex =i;
            }
        }

        return prevIndex==-1 ? 0:(int)(count%MOD);
    }
}
