package com.array;
/*
2348. Number of Zero-Filled Subarrays

Given an integer array nums, return the number of subarrays filled with 0.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,3,0,0,2,0,0,4]
Output: 6
Explanation:
There are 4 occurrences of [0] as a subarray.
There are 2 occurrences of [0,0] as a subarray.
There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.

TC : o(n)
SC: o(1)
 */
public class NumberOfZeroFilledSubarrays {

    public static void main(String[] args) {
        int[] nums= new int[]{1,3,0,0,2,0,0,4};
        System.out.println(new NumberOfZeroFilledSubarrays().zeroFilledSubarray(nums));
    }
    public long zeroFilledSubarray(int[] nums) {
        long length=0,count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                length+=1;
                count +=length;
            } else{
                length=0;
            }
        }
        return count;
    }
}
