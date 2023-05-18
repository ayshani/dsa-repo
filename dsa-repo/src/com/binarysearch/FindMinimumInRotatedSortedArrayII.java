package com.binarysearch;
/*
154. Find Minimum in Rotated Sorted Array II

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example,
the array nums = [0,1,4,4,5,6,7] might become:

[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the
array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.

You must decrease the overall operation steps as much as possible.



Example 1:

Input: nums = [1,3,5]
Output: 1

TC : o(logn)
SC: o(1)
 */
public class FindMinimumInRotatedSortedArrayII {

    public static void main(String[] args) {
        //int[] nums = new int[]{2,2,2,0,1};
        int[] nums = new int[]{3,1};
        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(nums));
    }
    public int findMin(int[] nums) {
        int left =0, right = nums.length-1;
        if(nums.length==1)
            return nums[0];

        if(nums[left]<nums[right])
            return nums[left];
        int mid =right/2;
        while(left<right){


            if(nums[mid]>nums[right]){
                left = mid+1;
                mid = (left+right)/2;
            }
            else if(nums[mid]<nums[right]){
                right = mid;
                mid = (left+right)/2;
            }
            else {
                if(nums[mid]== nums[left])
                    left++;
                if(nums[mid]==nums[right])
                    right--;
                mid = (left+right)/2;
            }
        }
        return nums[mid];
    }
}
