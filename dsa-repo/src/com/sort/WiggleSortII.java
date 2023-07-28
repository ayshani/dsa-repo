package com.sort;

import java.util.Arrays;

/*
324. Wiggle Sort II

Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

You may assume the input array always has a valid answer.



Example 1:

Input: nums = [1,5,1,1,6,4]
Output: [1,6,1,5,1,4]
Explanation: [1,4,1,5,1,6] is also accepted.

TC : o(n)
SC: o(n)
 */
public class WiggleSortII {

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,1,1,6,4};
        new WiggleSortII().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void wiggleSort(int[] nums) {
        int n = nums.length-1;
        int[] res = Arrays.copyOf(nums, nums.length);
        Arrays.sort(res);
        for(int i=1;i<nums.length;i+=2){
            nums[i] =  res[n--];
        }
        for(int i=0;i<nums.length;i+=2){
            nums[i] =  res[n--];
        }
    }
}
