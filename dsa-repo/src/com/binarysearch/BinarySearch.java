package com.binarysearch;
/*
704. Binary Search

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function
to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

TC : o(logn)
 */
public class BinarySearch {

    public static void main(String[] args) {
        int target = 9, nums[] = new int[]{-1,0,3,5,9,12};
        System.out.println(new BinarySearch().search(nums,target));
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid]< target)
                l = mid+1;
            else
                r = mid-1;
        }
        return -1;
    }
}
