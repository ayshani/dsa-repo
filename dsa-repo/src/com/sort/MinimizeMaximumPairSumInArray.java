package com.sort;

import java.util.Arrays;

/*
1877. Minimize Maximum Pair Sum in Array

The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.

For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) =
        max(6, 5, 8) = 8.
Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:

Each element of nums is in exactly one pair, and
The maximum pair sum is minimized.
Return the minimized maximum pair sum after optimally pairing up the elements.



Example 1:

Input: nums = [3,5,2,3]
Output: 7
Explanation: The elements can be paired up into pairs (3,3) and (5,2).
The maximum pair sum is max(3+3, 5+2) = max(6, 7) = 7.
TC : o(nlogn)
SC: o(1)
 */
public class MinimizeMaximumPairSumInArray {

    public static void main(String[] args) {
        System.out.println(new MinimizeMaximumPairSumInArray().minPairSum(new int[]{3,5,2,3}));
    }
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int maxSum =0;
        for(int i=0;i<nums.length;i++){
            maxSum = Math.max(maxSum, nums[i] + nums[nums.length-i-1]);
        }
        return maxSum;
    }
}
