package com.array;

import java.util.Arrays;

/*
594. Longest Harmonious Subsequence

We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.



Example 1:

Input: nums = [1,3,2,2,5,2,3,7]

Output: 5

Explanation:

The longest harmonious subsequence is [3,2,2,2,3].

TC : o(nlogn)
SC: o(1)
 */
public class LongestHarmoniousSubsequence {

    public static void main(String[] args) {
        System.out.println(new LongestHarmoniousSubsequence().findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int min =0, count =0;
        for(int i=1;i<nums.length;){
            if(nums[i]-nums[min]==0){
                i++;
            }
            else if(nums[i]-nums[min] == 1){
                count = Math.max(count, i-min+1);
                i++;
            } else{
                min++;
            }
        }
        return count ;
    }
}
