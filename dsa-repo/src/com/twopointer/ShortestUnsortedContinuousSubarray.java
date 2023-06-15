package com.twopointer;

import java.util.Arrays;

/*
581. Shortest Unsorted Continuous Subarray

Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray
in non-decreasing order, then the whole array will be sorted in non-decreasing order.

Return the shortest such subarray and output its length.



Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
TC : o(nlogn)
SC: o(n)
 */
public class ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{2,6,4,8,10,9,15};
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(nums));
    }
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int i=0,j= nums.length-1;
        while(i<j){
            if(nums[i]==arr[i] && nums[j]==arr[j])
            {
                i++;
                j--;
            }
            else if(nums[i]==arr[i])
            {
                i++;
            }
            else if(nums[j]==arr[j])
            {
                j--;
            }
            else
            {
                return j-i+1;
            }
        }
        return 0;
    }
}
