package com.slidingwindow;
/*
1004. Max Consecutive Ones III

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you
can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

TC: o(n)
SC: o(1)
 */
public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(new MaxConsecutiveOnesIII().longestOnes(nums,2));
    }
    public int longestOnes(int[] nums, int k) {
        /*
        Find the longest subarray with at most K zeros.
        For each A[j], try to find the longest subarray.
            If A[i] ~ A[j] has zeros <= K, we continue to increment j.
            If A[i] ~ A[j] has zeros > K, we increment i (as well as j).
        */
        int i=0, j;
        for(j=0;j<nums.length;j++){
            if(nums[j]==0)
                k--;
            if(k<0 && nums[i++]==0)
                k++;
        }

        return j-i;
    }
}
