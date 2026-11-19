package com.greedy;

import java.util.Arrays;

/*
2567. Minimum Score by Changing Two Elements

You are given an integer array nums.

The low score of nums is the minimum absolute difference between any two integers.
The high score of nums is the maximum absolute difference between any two integers.
The score of nums is the sum of the high and low scores.
Return the minimum score after changing two elements of nums.



Example 1:

Input:
int[] nums = new int[]{1, 4, 7, 8, 5};


Output: 3

Explanation:

Change nums[0] and nums[1] to be 6 so that nums becomes [6,6,7,8,5].
The low score is the minimum absolute difference: |6 - 6| = 0.
The high score is the maximum absolute difference: |8 - 5| = 3.
The sum of high and low score is 3.

TC : o(nlogn)
SC: o(logn)
 */
public class MinimumScoreByChangingTwoElements {

    public static void main(String[] args) {
        System.out.println(new MinimumScoreByChangingTwoElements().minimizeSum(new int[]{1, 4, 7, 8, 5}));
    }
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.min(
                Math.min(nums[n - 3] - nums[0], nums[n - 2] - nums[1]),
                nums[n - 1] - nums[2]
        );
    }
}
