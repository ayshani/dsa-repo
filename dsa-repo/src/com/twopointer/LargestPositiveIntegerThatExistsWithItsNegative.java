package com.twopointer;

import java.util.Arrays;

/*
2441. Largest Positive Integer That Exists With Its Negative

Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k
also exists in the array.

Return the positive integer k. If there is no such integer, return -1.



Example 1:

Input: nums = [-1,2,-3,3]
Output: 3
Explanation: 3 is the only valid k we can find in the array.

TC : o(n)
SC: o(1)
 */
public class LargestPositiveIntegerThatExistsWithItsNegative {

    public static void main(String[] args) {
        System.out.println(new LargestPositiveIntegerThatExistsWithItsNegative().findMaxK(
                new int[]{-1,2,-3,3}
        ));
    }
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left =0, right =n-1;
        if(nums[left]>=0 || nums[right]<=0){
            return -1;
        }
        while(left<right){
            if(Math.abs(nums[left])==nums[right]){
                return nums[right];
            } else if(Math.abs(nums[left]) < nums[right]){
                right--;
            } else{
                left++;
            }
        }
        return -1;
    }
}
