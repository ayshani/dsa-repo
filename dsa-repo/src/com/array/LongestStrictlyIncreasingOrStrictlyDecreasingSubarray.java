package com.array;
/*
3105. Longest Strictly Increasing or Strictly Decreasing Subarray

You are given an array of integers nums. Return the length of the longest
subarray
 of nums which is either
strictly increasing
 or
strictly decreasing
.



Example 1:

Input: nums = [1,4,3,3,2]

Output: 2

Explanation:

The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].

The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].

Hence, we return 2.

TC : o(n)
SC: o(n)
 */
public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

    public static void main(String[] args) {
        System.out.println(new LongestStrictlyIncreasingOrStrictlyDecreasingSubarray().longestMonotonicSubarray(
                new int[]{1,4,3,3,2}
        ));
    }
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length, maxLength =1;

        int[] increasingDp = new int[n];
        int[] decreasingDp = new int[n];

        increasingDp[0] =1;
        decreasingDp[0] =1;
        for(int i=1;i<n;i++){
            increasingDp[i] =1;
            decreasingDp[i]=1;
            if(nums[i-1]<nums[i]){
                increasingDp[i] = Math.max(increasingDp[i], increasingDp[i-1]+1);
            }
            if(nums[i-1]>nums[i]){
                decreasingDp[i] = Math.max(decreasingDp[i], decreasingDp[i-1]+1);
            }
            maxLength = Math.max(maxLength, Math.max(decreasingDp[i], increasingDp[i]));
        }
        return maxLength;
    }
}
