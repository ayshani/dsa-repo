package com.array;
/*
896. Monotonic Array

An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.

Example 1:

Input: nums = [1,2,2,3]
Output: true

TC : o(n)
SC: o(1)
 */
public class MonotonicArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3};
        System.out.println(new MonotonicArray().isMonotonic(nums));
    }
    public boolean isMonotonic(int[] nums) {
        boolean inc = true, dec= true;
        for(int i=1;i<nums.length;i++){
            inc &= nums[i-1]<= nums[i];
            dec &= nums[i-1]>= nums[i];
        }
        return inc|| dec;
    }

}
