package com.array;

import java.util.Arrays;

/*
189. Rotate Array

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

TC : o(n)
SC: o(1)
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        new RotateArray().rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(nums==null || n<2)
            return;
        k = k%n;
        rev(nums, 0, n-k-1);
        rev(nums, n-k, n-1);
        rev(nums, 0, n-1);
    }

    public void rev(int[] nums, int i, int j){
        int temp=0;
        while(i<j){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
