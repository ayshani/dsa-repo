package com.bit.manipulation;
/*
136. Single Number

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,1]
Output: 1

TC : o(n)
SC: o(1)
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{4,2,1,2,1}));
    }
    public int singleNumber(int[] nums) {
        int xor =0;
        for(int i=0;i<nums.length;i++)
            xor^=nums[i];

        return xor;
    }
}
