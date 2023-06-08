package com.binarysearch;
/*
2529. Maximum Count of Positive Integer and Negative Integer

Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers
and the number of negative integers.

In other words, if the number of positive integers in nums is pos and the number of negative integers is neg,
then return the maximum of pos and neg.
Note that 0 is neither positive nor negative.



Example 1:

Input: nums = [-2,-1,-1,1,2,3]
Output: 3
Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.

TC : o(logn)
SC: o(1)
 */
public class MaximumCountOfPositiveIntegerAndNegativeInteger {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,-1,-1,1,2,3};
        System.out.println(new MaximumCountOfPositiveIntegerAndNegativeInteger().maximumCount(nums));
    }
    public int maximumCount(int[] nums) {
        int negative = binarySearch(nums, 0);
        int positive = nums.length - binarySearch(nums, 1);

        return Math.max(negative, positive);
    }

    private int binarySearch(int[] nums, int target){
        int low =0, high = nums.length-1;
        while(low<=high){
            int mid = low +(high - low)/2;
            if(nums[mid]<target){
                low = mid+1;
            } else{
                high = mid -1;
            }
        }
        return low;
    }
}
