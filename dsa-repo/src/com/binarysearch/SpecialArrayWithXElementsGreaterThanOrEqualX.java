package com.binarysearch;
/*
1608. Special Array With X Elements Greater Than or Equal X

You are given an array nums of non-negative integers. nums is considered special if there exists a number x
such that there are exactly x numbers in nums that are greater than or equal to x.

Notice that x does not have to be an element in nums.

Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value
for x is unique.

Example 1:

Input: nums = [3,5]
Output: 2
Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.

TC : o(nlogn)
SC: o(1)
 */
public class SpecialArrayWithXElementsGreaterThanOrEqualX {

    public static void main(String[] args) {
        int[] nums = new int[]{0,4,3,4};
        System.out.println(new SpecialArrayWithXElementsGreaterThanOrEqualX().specialArray(nums));
    }
    public int specialArray(int[] nums) {
        int low =0, high = nums.length;

        while(low<=high){
            int mid = low+(high-low)/2;
            int count = getCount(nums,mid);

            if(count==mid)
                return mid;
            else if(count< mid){
                high = mid-1;
            } else{
                low = mid +1;
            }
        }

        return -1;
    }

    private int getCount(int[] nums, int mid){
        int count =0;
        for(int num : nums){
            if(num>=mid)
                count++;
        }
        return count;
    }
}
