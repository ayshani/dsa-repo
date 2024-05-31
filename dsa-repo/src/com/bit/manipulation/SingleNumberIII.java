package com.bit.manipulation;

import java.util.Arrays;

/*
260. Single Number III

Given an integer array nums, in which exactly two elements appear only once and all the other elements appear
exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.

TC : o(n)
SC: o(1)
 */
public class SingleNumberIII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SingleNumberIII().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
    public int[] singleNumber(int[] nums) {
        int n = nums.length, xor =0 ;
        for(int num : nums){
            xor ^= num;
        }

        //System.out.println(xor);
        xor &= -xor;
        //System.out.println(xor);
        int[] res = {0,0};
        for(int num : nums){
            if((xor&num)==0){
                res[0] ^= num;
            } else{
                res[1] ^= num;
            }
        }
        return res;
    }
}
