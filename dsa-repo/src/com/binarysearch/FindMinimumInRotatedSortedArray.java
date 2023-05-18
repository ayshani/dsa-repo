package com.binarysearch;
/*
153. Find Minimum in Rotated Sorted Array

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example,
the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array
[a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

TC : o(logn)
SC: o(1)
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2};
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(nums));
    }
    public int findMin(int[] nums) {
        int left =0, right = nums.length-1;
        if(nums.length==1)
            return nums[0];

        if(nums[left]<nums[right])
            return nums[left];
        while(left<=right){
            int mid = (left+right)/2;

            if(nums[mid]>nums[mid+1])
                return nums[mid+1];
            else if(nums[mid]<nums[mid-1])
                return nums[mid];
            else if ( nums[0]< nums[mid])
                left = mid+1;
            else
                right = mid-1;
        }
        return Integer.MAX_VALUE;
    }
}
