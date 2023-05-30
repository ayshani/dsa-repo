package com.binarysearch;
/*
162. Find Peak Element

A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple
peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly
greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
TC : o(logn)
SC: o(logn)
 */
public class FindPeakElement {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(new FindPeakElement().findPeakElement(nums));
    }
    public int findPeakElement(int[] nums) {
        return search(nums, 0,nums.length-1);
    }

    private int search(int[] nums, int l, int r){
        if(l==r)
            return l;
        int mid = l+(r-l)/2;
        if(nums[mid]>nums[mid+1])
            return search(nums, l, mid);
        return search(nums, mid+1, r);
    }
}
