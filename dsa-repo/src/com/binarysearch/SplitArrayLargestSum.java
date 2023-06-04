package com.binarysearch;
/*
410. Split Array Largest Sum

Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum
of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.



Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

TC : o(nlogn)
SC: o(1)
 */
public class SplitArrayLargestSum {

    public static void main(String[] args) {
        int[] nums = new int[]{7,2,5,10,8};
        System.out.println(new SplitArrayLargestSum().splitArray(nums,2));
    }
    public int splitArray(int[] nums, int m) {
        int sum =0, maxE= Integer.MIN_VALUE;
        for(int e : nums){
            sum+=e;
            maxE = Math.max(maxE, e);
        }

        int l = maxE, r = sum, resultantSum =0;

        while(l<=r){
            int mid = l+(r-l)/2;

            if(minSubArray(nums, mid)<=m){
                r= mid -1 ;
                resultantSum = mid;
            } else
                l = mid+1;
        }
        return resultantSum;
    }

    public int minSubArray(int[] nums, int sum){
        int reqSize =0, curSum =0;

        for(int el : nums){
            if(curSum+el <=sum)
                curSum+=el;
            else{
                curSum = el;
                reqSize++;
            }
        }

        return reqSize+1;
    }
}
