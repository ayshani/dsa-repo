package com.sort;

import java.util.Arrays;

/*
977. Squares of a Sorted Array

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number
sorted in non-decreasing order.

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

TC : o(nlogn)
SSC: o(1)
 */
public class SquaresOfASortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};
        nums = new SquaresOfASortedArray().sortedSquares(nums);
        System.out.println(Arrays.toString(nums));
    }
    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
