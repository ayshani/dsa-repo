package com.binarysearch;
/*
35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2

TC : o(logn)
SC: o(1)
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(new SearchInsertPosition().searchInsert(nums,5));
    }
    public int searchInsert(int[] nums, int target) {
        int l=0, r = nums.length-1, res =-1;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]> target)
                r = mid-1;
            else{
                res = mid;
                l = mid+1;
            }
        }
        return res+1;
    }
}
