package com.binarysearch;

import java.util.Arrays;

/*
719. Find K-th Smallest Pair Distance

The distance of a pair of integers a and b is defined as the absolute difference between a and b.

Given an integer array nums and an integer k, return the kth smallest distance among all the pairs
nums[i] and nums[j] where 0 <= i < j < nums.length.

Example 1:

Input: nums = [1,3,1], k = 1
Output: 0
Explanation: Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
 */
public class FindKthSmallestPairDistance {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1};
        System.out.println(new FindKthSmallestPairDistance().smallestDistancePair(nums,1));
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0, high = Math.abs(nums[n-1]- nums[0]);

        while(low<high){
            int mid = low +(high-low)/2;

            int count = getTotalPairWithDifference(nums, mid, k);
            if(count<k){
                low = mid+1;
            } else{
                high = mid;
            }
        }

        return high;
    }

    private int getTotalPairWithDifference(int[] nums, int mid, int k){
        int count =0;

        for(int i=0;i<nums.length;i++){
            int j = i;
            while(j<nums.length && (nums[j]-nums[i]<=mid)){
                j++;
            }
            count += (j-i-1);
        }

        return count;
    }
}
