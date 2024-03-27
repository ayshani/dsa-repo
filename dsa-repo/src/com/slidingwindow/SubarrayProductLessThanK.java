package com.slidingwindow;
/*
713. Subarray Product Less Than K

Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of
all the elements in the subarray is strictly less than k.



Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

TC : o(n)
SC: o(1)
 */
public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        System.out.println(new SubarrayProductLessThanK().numSubarrayProductLessThanK(
                new int[]{10,5,2,6}, 100
        ));
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)
            return 0;

        int totalCount =0, product =1;
        for(int left=0, right=0; right<nums.length;right++){
            product *= nums[right];
            while(product>=k){
                product /= nums[left++];
            }

            totalCount += (right-left)+1;
        }

        return totalCount;
    }
}

